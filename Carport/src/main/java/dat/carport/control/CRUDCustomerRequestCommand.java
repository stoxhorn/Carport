package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.entities.ServiceEntities.CustomerRequestData;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.CustomerRequestMapper;
import dat.carport.model.services.CRUDCustomerRequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CRUDCustomerRequestCommand extends Command{
    ConnectionPool connectionPool;

    public CRUDCustomerRequestCommand(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        String crudType = request.getParameter("crud");
        String customerEmail = request.getParameter("customerEmail");
        if(crudType.equals("create")){

            CustomerRequestData crData = (CustomerRequestData) request.getAttribute("customerRequestData");
            CRUDCustomerRequestService.createCustomerRequest(customerEmail, this.connectionPool);

        }
        else if(crudType.equals("read")){
            CustomerRequest cr = CRUDCustomerRequestService.readCustomerRequest(customerEmail, this.connectionPool);
            request.setAttribute("readCustomerRequest", cr);
        }
        else if(crudType.equals("update")){
            //updateCustomerRequest(customerEmail);
        }
        else if(crudType.equals("delete")){
            //deleteCustomerRequest(customerEmail);
            }
        return null;
        }


}
