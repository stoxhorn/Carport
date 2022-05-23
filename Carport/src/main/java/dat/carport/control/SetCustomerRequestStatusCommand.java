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

    public SetCustomerRequestStatusCommand(){this.cp = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");


        if(!u.getRole().equals("admin")){
            // if user is not admin, sent him back to admin dashboard
            return request.getParameter("admin-dashboard");
        }

        String customerEmail = request.getParameter("customerEmail");

        CustomerRequest cr = CRUDCustomerRequestService.readCustomerRequest(customerEmail, cp);

        if(cr.getStatus().equals(Status.pending)){
            cr.setStatus(Status.completed);
        }else if(cr.getStatus().equals(Status.completed)){
            cr.setStatus(Status.pending);
        }

        CRUDCustomerRequestService.updateCustomerRequest(cr, cp);


        return request.getParameter("next");
    }
}
