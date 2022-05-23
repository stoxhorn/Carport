package dat.carport.control;

import dat.carport.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

abstract class Command
{

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("logout", new Logout());
        commands.put("about", new About());
        commands.put("CRUDCustomerRequest", new CRUDCustomerRequestCommand());
        commands.put("CRUDMaterials", new CRUDMaterialsCommand());
        commands.put("CRUDMaterialList", new CRUDMaterialListCommand());
        commands.put("createCustomer", new CreateCustomerCommand());
        commands.put("ReadAllMaterials", new ReadAllMaterialsCommand());
        commands.put("ReadAllRequests", new ReadAllRequestsCommand());
        commands.put("updateCustomerRequestStatus", new SetCustomerRequestStatusCommand());
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );   // unknowncommand er default.
    }

    static Command get(String commandName){
        return commands.getOrDefault(commandName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws DatabaseException;

}
