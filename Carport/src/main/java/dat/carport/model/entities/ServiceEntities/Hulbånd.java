package dat.carport.model.entities.ServiceEntities;

public class Hulbånd {

    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public Hulbånd(String amount, String length, double price) {
        this.name = "Hulbånd 1x20 mm. 10mtr., ";
        this.amount = amount;
        this.height = ", Højde: 1mm,";
        this.width = " Bredde: 20mm,";
        this.length = length;
        this.unit = ", Enhed: Rulle,";
        this.description = " Til vindkryds på spær";
        this.price = price;
    }

    @Override
    public String toString() {
        return  name + "Antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
