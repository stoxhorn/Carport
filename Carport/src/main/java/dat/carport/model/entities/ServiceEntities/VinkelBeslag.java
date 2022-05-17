package dat.carport.model.entities.ServiceEntities;

public class VinkelBeslag {
    String name;
    String amount;
    String unit;
    String description;

    public VinkelBeslag(String amount) {
        this.name = "Vinkelbeslag 35 ";
        this.amount = amount;
        this.unit = "Enhed: stk.";
        this.description = " til montering af løsholter i skur";
    }

    @Override
    public String toString() {
        return name + "antal: " + amount + unit + description;
    }

}
