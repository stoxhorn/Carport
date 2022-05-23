package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.CRUDCustomerRequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ReadAllRequestsCommand extends Command{

    ConnectionPool cp;

    public ReadAllRequestsCommand(){this.cp = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        ArrayList<CustomerRequest> crList = CRUDCustomerRequestService.getAllRequests(this.cp);

        request.setAttribute("CustomerRequestList", crList);

        return request.getParameter("next");
    }
}
