package dat.carport.model.entities.ServiceEntities;

public class VinkelBeslag {
    String name;
    String amount;
    String unit;
    String description;
    double price;

    public VinkelBeslag(String amount, double price) {
        this.name = "Vinkelbeslag 35, ";
        this.amount = amount;
        this.unit = ", Enhed: stk.,";
        this.description = " til montering af løsholter i skur";
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "antal: " + amount + unit + description + " Pris: " + price + "kr.";
    }

}
