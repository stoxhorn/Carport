package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.ServiceEntities.Employee;
import dat.carport.model.entities.ServiceEntities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.CRUDEmployeeService;
import dat.carport.model.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAdminCommand extends Command{

    ConnectionPool cp;
    public CreateAdminCommand(){this.cp = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        String employeeEmail = request.getParameter("employeeEmail");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        User u;
        try {
            // then i check if there is a user with his email
            u = UserFacade.login(employeeEmail, password, this.cp);
        }
        catch(DatabaseException e){
            // if not existing, create a new user
            u = UserFacade.createUser(employeeEmail, password, "admin", this.cp);

        }
        // then i check if employeeInfo object exists

        Employee em = CRUDEmployeeService.readEmployee(employeeEmail, this.cp);

        if(em == null){
            em = new Employee(employeeEmail, firstName, lastName);
            CRUDEmployeeService.createEmployee(em, this.cp);
        }
        else{
            throw new DatabaseException("this employee already exists");
        }

        return request.getParameter("next");
    }
}
