package dat.startcode.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends Command
{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }
}