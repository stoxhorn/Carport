package dat.carport.control;

import dat.carport.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class About extends Command
{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {
        String hilsen = "Her kan du se hvordan man sender indhold til en jsp-side.";
        request.setAttribute("hilsen", hilsen);
        return "about";
    }
}
