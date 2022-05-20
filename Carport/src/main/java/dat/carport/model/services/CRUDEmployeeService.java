package dat.carport.model.services;

import dat.carport.model.entities.DBEntities.DBCustomer;
import dat.carport.model.entities.DBEntities.DBEmployee;
import dat.carport.model.entities.ServiceEntities.Customer;
import dat.carport.model.entities.ServiceEntities.Employee;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.CustomerInfoMapper;
import dat.carport.model.persistence.EmployeeInfoMapper;

public class CRUDEmployeeService {

    public static Employee readEmployee(String employeeEmail, ConnectionPool cp) throws DatabaseException {
        EmployeeInfoMapper eiMapper = new EmployeeInfoMapper(cp);
        for(DBEmployee dbe : eiMapper.getEmployee()){
            if(dbe.getUserEmail().equals(employeeEmail)){
                return new Employee(dbe);
            }
        }
        return null;
    }

    public static void createEmployee(Employee emp, ConnectionPool cp) throws DatabaseException {
        EmployeeInfoMapper eiMapper = new EmployeeInfoMapper(cp);
        eiMapper.createEmployee(new DBEmployee(emp));

    }
}
