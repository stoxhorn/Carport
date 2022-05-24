package dat.carport.model.entities.ServiceEntities;

import static java.lang.Integer.parseInt;

public class DørLægte {
    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public DørLægte() {
        this.name = "Lægte ubh., ";
        this.amount = " Antal: 1,";
        this.height = " Højde: 38mm,";
        this.width = " Bredde: 73mm,";
        this.length = " Længde: 420cm,";
        this.unit = " Enhed: stk.,";
        this.description = " til z på bagside af dør";
    }

    public DørLægte(double price) {
        this.price = price;
    }

    public int getLength() {
        return parseInt(length.replaceAll("[^0-9]", ""));
    }

    public int getAmount() {
        return parseInt(amount.replaceAll("[^0-9]", ""));
    }

    @Override
    public String toString() {
        return name + amount + height + width + length + unit + description + " Pris: " + price + "kr.";
    }
}
