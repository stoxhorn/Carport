package dat.carport.model.entities.ServiceEntities;

import static java.lang.Integer.parseInt;

public class Rem {

    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public Rem() {
        this.name = "Spærtræ ubh., ";;
        this.amount = " 2,";
        this.height = " Højde: 195mm,";
        this.width = " Bredde: 45mm,";
        this.unit = ", Enhed: stk.,";
        this.description = " Remme i sider, sadles ned i stolper";
    }

    public Rem(String length, double price) {
        this.length = length;
        this.price = price;
    }

    public int getAmount() {
        return parseInt(amount.replaceAll("[^0-9]", ""));
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
