package dat.carport.model.entities.ServiceEntities;

public class Hulbånd {

    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;

    public Hulbånd(String amount, String length) {
        this.name = "Hulbånd 1x20 mm, ";
        this.amount = amount;
        this.height = ", Højde: 1mm,";
        this.width = " Bredde: 20mm,";
        this.length = length;
        this.unit = ", Enhed: Rulle,";
        this.description = " Til vindkryds på spær";
    }

    @Override
    public String toString() {
        return  name + "Antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description;
    }
}
