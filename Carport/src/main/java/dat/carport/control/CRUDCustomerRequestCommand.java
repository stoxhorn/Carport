package dat.carport.control;

import dat.carport.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CRUDCustomerRequestCommand extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        String crudType = request.getParameter("crud");
        String customerEmail = request.getParameter("customerEmail");
/*
        if(){
        }
else if(){

        }
    else if(){

        }
        else if(){

            }
  */      return null;
        }


    private void readCustomerRequest(String customerEmail){

    }

    private void createCustomerRequest(String customerEmail){

    }

    private void updateCustomerRequest(String customerEmail){

    }

    private void deleteCustomerRequest(String customerEmail){

    }
}
