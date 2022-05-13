package dat.carport.control;

import dat.carport.model.entities.ServiceEntities.Materials;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.services.CRUDMaterialsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CRUDMaterialListCommand extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        String crudType = request.getParameter("crud");

        switch (crudType) {
            case "create":

                return request.getParameter("next");

            case "read":
                return request.getParameter("next");

            case "update":
                return request.getParameter("next");

            case "delete":
                return request.getParameter("next");
        }

        return null;
    }
    }
}
