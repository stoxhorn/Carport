package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.CustomerRequestMapper;
import dat.carport.model.services.CRUDCustomerRequestService;
import dat.carport.model.services.SVGService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetSVGCommand extends Command{

    ConnectionPool cp;

    public GetSVGCommand(){this.cp = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        String customerEmail = request.getParameter("customerEmail");

        CustomerRequest cr = CRUDCustomerRequestService.readCustomerRequest(customerEmail, this.cp);


        String tmp = SVGService.getCarpotSVGString(cr);

        request.setAttribute("CustomerRequestSVG", tmp);
        request.getSession().setAttribute("CustomerRequestSVG", tmp);

        return request.getParameter("next");
    }
}
