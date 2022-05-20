package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.entities.ServiceEntities.Materials;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.CRUDCustomerRequestService;
import dat.carport.model.services.CRUDMaterialsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ReadAllMaterialsCommand extends Command{

    ConnectionPool cp;

    public ReadAllMaterialsCommand(){ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        ArrayList<Materials> mList = CRUDMaterialsService.getMaterials(this.cp);
        request.setAttribute("MaterialsList", mList);

        return request.getParameter("next");
    }
}
