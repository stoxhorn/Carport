package dat.carport.model.entities.ServiceEntities;

public class Firkantskiver {
    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public Firkantskiver(String amount, double price) {
        this.name = "Firkantskiver, ";
        this.amount = amount;
        this.height = ", Højde: 11mm,";
        this.width = " Brede: 40mm,";
        this.length = " Længde: 40mm,";
        this.unit = " Enhed: stk.,";
        this.description = " til montering af rem på stolper";
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + height + width + length + unit + description + " Pris: " + price + "kr.";
    }
}
