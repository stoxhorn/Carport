package dat.carport.model.entities.ServiceEntities;

public class CustomerRequest {
    private int id;
    private String customerUserEmail;
    private CustomerRequestData requestData;
    private MaterialsList materialList;

    public CustomerRequest(int id, String customerUserEmail, String carportWidth, String carportLength, String roofType, String roofMaterial, String roofSlope, String shedWidth, String shedLength) {
        this.id = id;
        this.customerUserEmail = customerUserEmail;
        this.requestData = new CustomerRequestData(carportWidth, carportLength, roofType, roofMaterial, roofSlope, shedWidth, shedLength);
    }

    public CustomerRequest(int id, String customerUserEmail, CustomerRequestData requestData){
        this.id = id;
        this.customerUserEmail = customerUserEmail;
        this.requestData = requestData;
    }

    public void setMaterialList(MaterialsList mList){
        this.materialList = mList;
    }

    public CustomerRequestData getRequestData(){
        return this.requestData;
    }

    public MaterialsList getMaterialList(){
        return this.materialList;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "id=" + id +
                ", customerUserEmail='" + customerUserEmail + '\'' +
                ", requestData=" + requestData +
                ", materialList=" + materialList +
                '}';
    }
}
