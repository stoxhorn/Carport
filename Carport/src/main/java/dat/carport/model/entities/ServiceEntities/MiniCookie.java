package dat.carport.model.entities.ServiceEntities;

import java.util.ArrayList;


public class MiniCookie {

    private Customer customer;
    private Materials mats;
    private MaterialsList matList;
    private ArrayList<MaterialListLine> matListLines;
    private CustomerRequest customerRequest;
    private CustomerRequestData customerRequestData;
    private User user;

    public MiniCookie(){

    }

    public void setCustomer(Customer cust){
        this.customer = cust;
    }
    public boolean customerExists(){
        return customer != null;
    }
    public Customer getCustomer(){
        return customer;
    }

}
