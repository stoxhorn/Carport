package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.DBEntities.DBCustomer;
import dat.carport.model.entities.ServiceEntities.Customer;
import dat.carport.model.entities.ServiceEntities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.CustomerInfoMapper;
import dat.carport.model.services.CRUDCustomerService;
import dat.carport.model.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCustomerCommand extends Command{

    ConnectionPool cp;

    public CreateCustomerCommand(){this.cp = ApplicationStart.getConnectionPool();}


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        // first i get the customer parameters
        String customerEmail = request.getParameter("customerEmail");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String zipCode = request.getParameter("zipCode");
        String city = request.getParameter("city");
        String phoneNumber = request.getParameter("phoneNumber");

        // I need to create a user before a customer, because the user email is a constraint
        User u;
        try {
            // then i check if there is a user with his email
            u = UserFacade.login(customerEmail, "", this.cp);
        }
        catch(DatabaseException e){
            // if not existing, create a new user
            u = UserFacade.createUser(customerEmail, "", "customer", this.cp);

        }
        request.setAttribute("user", u);

        // i need to check if the customer exists
        Customer c = new Customer(customerEmail, firstName, lastName, address, zipCode, city, phoneNumber);
        Customer check = CRUDCustomerService.readCustomer(c.getEmail(), this.cp);

        // if he does not exist create him
        if(check == null){
            CustomerInfoMapper ciMapper = new CustomerInfoMapper(this.cp);
            ciMapper.createCustomer(new DBCustomer(c));
        }

        request.setAttribute("customer", c);

        // forward him to CRUDCustomerRequestCommand
        Command x = Command.get("CRUDCustomerRequest");
        String next = x.execute(request, response);
        return next;
    }
}
