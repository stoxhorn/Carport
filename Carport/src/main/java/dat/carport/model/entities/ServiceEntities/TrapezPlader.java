package dat.carport.model.entities.ServiceEntities;

public class TrapezPlader {
    String name;
    String amount;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public TrapezPlader(String amount, String length, double price) {
        this.name = "Plastmo ecolite blåtonet, ";
        this.amount = amount;
        this.width = ", Bredde: 109cm,";
        this.length = length;
        this.unit = " Enhed: stk.,";
        this.description = " tagplader monteres på spær";
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + width + " Længde: " + length + "cm," + unit + description + " Pris: " + price + "kr.";
    }
}
