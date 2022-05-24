package dat.carport.model.entities.ServiceEntities;

public class SpærBeslag {

    String name;
    String amount;
    String unit;
    String description;
    double price;

    public SpærBeslag(String amount, double price) {
        this.name = "Universal 190 mm højre og venstre, ";
        this.amount = amount;
        this.unit = ", Enhed: stk.,";
        this.description = " montering af spær på rem";
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + unit + description + " Pris: " + price + "kr.";
    }
}
