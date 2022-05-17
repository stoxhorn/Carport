package dat.carport.model.entities.ServiceEntities;

public class Stalddørsgreb {
    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;

    public Stalddørsgreb() {
        this.name = "Stalddørsgreb ";
        this.amount = " 1,";
        this.height = " 50mm";
        this.width = " 75mm";
        this.unit = " Enhed: sæt";
        this.description = " til lås på skur dør";
    }

    @Override
    public String toString() {
        return name + "antal: " + amount + height + width + unit + description;
    }
}
