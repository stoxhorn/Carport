package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.ServiceEntities.Customer;
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

    /**
     *
     * There is a lack of optimization when interacting with database, goes through everything
     * @param request
     * @param response
     * @return
     * @throws DatabaseException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        String crudType = request.getParameter("crud");
        String customerEmail = request.getParameter("customerEmail");
        if(crudType.equals("create")){
            CustomerRequestData crData = new CustomerRequestData(
                    request.getParameter("carportWidth"),
                    request.getParameter("carportLength"),
                    request.getParameter("roofType"),
                    request.getParameter("roofMaterial"),
                    request.getParameter("roofSlope"),
                    request.getParameter("shedWidth"),
                    request.getParameter("shedLength"));
            try{
                CRUDCustomerRequestService.createCustomerRequest(customerEmail, crData, this.connectionPool);
            } catch (DatabaseException e) {
                throw new RuntimeException(e);
            }
            return request.getParameter("next");
        }
        else if(crudType.equals("read")){
            CustomerRequest cr = CRUDCustomerRequestService.readCustomerRequest(customerEmail, this.connectionPool);
            request.setAttribute("readCustomerRequest", cr);
        }
        else if(crudType.equals("update")){
            CustomerRequestData crData = new CustomerRequestData(
                    request.getParameter("carportWidth"),
                    request.getParameter("carportLength"),
                    request.getParameter("roofType"),
                    request.getParameter("roofMaterial"),
                    request.getParameter("roofSlope"),
                    request.getParameter("shedWidth"),
                    request.getParameter("shedLength"));
            try{
                CRUDCustomerRequestService.updateCustomerRequest(customerEmail, crData, this.connectionPool);
            } catch (DatabaseException e) {
                throw new RuntimeException(e);
            }
            return request.getParameter("next");
        }
        else if(crudType.equals("delete")){
            try{
                CRUDCustomerRequestService.deleteCustomerRequest(customerEmail, this.connectionPool);
            } catch (DatabaseException e) {
                throw new RuntimeException(e);
            }
            return request.getParameter("next");
        }
        return request.getParameter("next");
        }


}
