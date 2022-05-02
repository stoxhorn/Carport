package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.UserFacade;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends Command
{
    private ConnectionPool connectionPool;

    public Login()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // adding empty user object to session scope
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = UserFacade.login(username, password, connectionPool);
        session = request.getSession();
        session.setAttribute("user", user); // adding user object to session scope
        return "index";
    }
}