package dat.carport.model.entities.ServiceEntities;

public class Beslagskruer {

    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;

    public Beslagskruer(String amount) {
        this.name = "Beslagskruer 4,0 x 50 mm. ";
        this.amount = amount;
        this.height = " 50mm";
        this.width = " 4mm";
        this.unit = " Enhed: pakke";
        this.description = " Til montering af universalbeslag + hulbånd";
    }

    @Override
    public String toString() {
        return name + "antal: " + amount + height + width + unit + description;
    }
}
