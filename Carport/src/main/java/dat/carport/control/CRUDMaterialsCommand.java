package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.ServiceEntities.Materials;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.CRUDMaterialsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CRUDMaterialsCommand extends Command{

    ConnectionPool cp;

    public CRUDMaterialsCommand(){this.cp = ApplicationStart.getConnectionPool();}

    /**
     * Takes crud and materialsID as parameters
     * crud can be create, read, update, delete. ANything else will not register
     * @param request
     * @param response
     * @return
     * @throws DatabaseException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        String crudType = request.getParameter("crud");

        switch (crudType) {
            case "create":
                CRUDMaterialsService.createMaterials(request.getParameter("description"), this.cp);
                return request.getParameter("next");

            case "read":
                String id = request.getParameter("materialsID");
                Materials m = CRUDMaterialsService.readMaterials(id, this.cp);
                request.setAttribute("Material", m);
                return request.getParameter("next");

            case "update":
                id = request.getParameter("materialsID");
                m = new Materials(
                        Integer.getInteger(id),
                        request.getParameter("description"));
                CRUDMaterialsService.updateMaterials(m, this.cp);
                return request.getParameter("next");

            case "delete":
                id = request.getParameter("materialsID");
                m = new Materials(
                        Integer.getInteger( id ),
                        request.getParameter("description"));
                CRUDMaterialsService.deleteMaterials(m, this.cp);
                return request.getParameter("next");
        }

        return null;
    }
}
