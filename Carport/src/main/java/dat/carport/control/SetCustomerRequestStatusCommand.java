package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.Enums.Status;
import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.entities.ServiceEntities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.CRUDCustomerRequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetCustomerRequestStatusCommand extends Command{

    ConnectionPool cp;

    public SetCustomerRequestStatusCommand(){ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");

        Status status = Status.valueOf(request.getParameter("status"));

        if(!u.getRole().equals("admin")){
            // if user is not admin, sent him back to index
            return request.getParameter("index");
        }

        String customerEmail = request.getParameter("CustomerEmail");

        CustomerRequest cr = CRUDCustomerRequestService.readCustomerRequest(customerEmail, this.cp);
        cr.setStatus(status);

        CRUDCustomerRequestService.updateCustomerRequest(cr, this.cp);


        return request.getParameter("next");
    }
}
