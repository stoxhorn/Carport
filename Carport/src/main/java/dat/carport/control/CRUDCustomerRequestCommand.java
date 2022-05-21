package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.Enums.Status;
import dat.carport.model.entities.ServiceEntities.Customer;
import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.entities.ServiceEntities.CustomerRequestData;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.CustomerRequestMapper;
import dat.carport.model.services.CRUDCustomerRequestService;
import dat.carport.model.services.CRUDCustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CRUDCustomerRequestCommand extends Command{
    ConnectionPool connectionPool;

    public CRUDCustomerRequestCommand(){this.connectionPool = ApplicationStart.getConnectionPool();}

    /**
     * There is a lack of optimization when interacting with database, goes through everything
     * crud can be create, read, update, delete. ANything else will not register
     *
     *
     * @param request
     * @param response
     * @return
     * @throws DatabaseException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        String crudType = request.getParameter("crud");
        String customerEmail = request.getParameter("customerEmail");
        HttpSession session = request.getSession();
        switch (crudType) {
            case "create": {
                CustomerRequestData crData = new CustomerRequestData(
                        request.getParameter("carportWidth"),
                        request.getParameter("carportLength"),
                        request.getParameter("roofType"),
                        request.getParameter("roofMaterial"),
                        request.getParameter("roofSlope").isEmpty() ? null : request.getParameter("roofSlope"),
                        request.getParameter("shedWidth").isEmpty() ? null : request.getParameter("shedWidth"),
                        request.getParameter("shedLength").isEmpty() ? null : request.getParameter("shedLength"));
                try {
                    CRUDCustomerRequestService.createCustomerRequest(customerEmail, crData, this.connectionPool);
                } catch (DatabaseException e) {
                    throw new RuntimeException(e);
                }
                return request.getParameter("next");
            }
            case "read":
                 try {
                    CustomerRequest customerRequest = CRUDCustomerRequestService.readCustomerRequest(customerEmail, this.connectionPool);
                    if (customerRequest != null) {
                        Customer customer = CRUDCustomerService.readCustomer(customerEmail, this.connectionPool);

                        session.setAttribute("customer", customer);
                        session.setAttribute("customerRequest", customerRequest);
                    } else {
                        request.setAttribute("error", "Der er ingen ordre tilknyttet denne mail");
                    }
                 } catch (DatabaseException e) {
                     throw new RuntimeException(e);
                }
                break;
            case "update": {
                CustomerRequestData crData = new CustomerRequestData(
                        request.getParameter("carportWidth"),
                        request.getParameter("carportLength"),
                        request.getParameter("roofType"),
                        request.getParameter("roofMaterial"),
                        request.getParameter("roofSlope"),
                        request.getParameter("shedWidth"),
                        request.getParameter("shedLength"));
                try {
                    Status status = Status.valueOf(request.getParameter("status"));

                    CRUDCustomerRequestService.updateCustomerRequest(customerEmail, crData, this.connectionPool, status);
                } catch (DatabaseException e) {
                    throw new RuntimeException(e);
                }
                return request.getParameter("next");
            }
            case "delete":
                try {
                    CRUDCustomerRequestService.deleteCustomerRequest(customerEmail, this.connectionPool);
                } catch (DatabaseException e) {
                    throw new RuntimeException(e);
                }
                return request.getParameter("next");
        }
        return request.getParameter("next");
    }


}
