package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.ServiceEntities.Materials;
import dat.carport.model.entities.ServiceEntities.MaterialsList;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.CRUDMaterialListService;
import dat.carport.model.services.CRUDMaterialsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CRUDMaterialListCommand extends Command{

    ConnectionPool cp;

    public CRUDMaterialListCommand(){this.cp = ApplicationStart.getConnectionPool();}

    /**
     * crud can be create, read, update, delete
     * There needs to be a MaterialsList object in session scope in order to create/update/delete
     * For read there needs to be an ID in requestscope
     * I will be assuming that a MaterialsList object will be passed around in sessionscope
     * This makes everything much easier to deal with.
     * This is not an object that should be created in a JSP page anyways
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
                MaterialsList ml = (MaterialsList) request.getSession().getAttribute("MaterialList");
                CRUDMaterialListService.createMaterialList(ml, this.cp);
                return request.getParameter("next");

            case "read":
                ml = CRUDMaterialListService.readMaterialList(
                        request.getParameter("id"),
                        this.cp);
                request.setAttribute("MaterialsList", ml);
                request.getSession().setAttribute("MaterialsList", ml);
                return request.getParameter("next");

            case "update":
                ml = (MaterialsList) request.getSession().getAttribute("MaterialList");
                CRUDMaterialListService.updateMaterialList(ml, this.cp);
                return request.getParameter("next");

            case "delete":
                ml = (MaterialsList) request.getSession().getAttribute("MaterialList");
                CRUDMaterialListService.deleteMaterialList(ml, this.cp);
                return request.getParameter("next");
        }

        return request.getParameter("next");
    }
}

