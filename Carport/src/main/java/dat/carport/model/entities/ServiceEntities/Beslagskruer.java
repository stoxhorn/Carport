package dat.carport.model.entities.ServiceEntities;

public class Beslagskruer {

    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;

    public Beslagskruer(String amount) {
        this.name = "Beslagskruer 4,0 x 50 mm., ";
        this.amount = amount;
        this.height = ", Højde: 50mm,";
        this.width = " Bredde: 4mm,";
        this.unit = " Enhed: pakke,";
        this.description = " Til montering af universalbeslag + hulbånd kommer i pakker af 250";
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + height + width + unit + description;
    }
}