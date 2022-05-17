package dat.carport.model.entities.ServiceEntities;

public class BeklædningSkruerYderst {
    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;

    public BeklædningSkruerYderst(String amount) {
        this.name = "Skruer ";
        this.amount = amount;
        this.height = " 4,5mm";
        this.width = " 70mm";
        this.unit = " Enhed: pakke";
        this.description = " til montering af yderste beklædning kommer i pakker med 400";
    }

    @Override
    public String toString() {
        return name + "antal: " + amount + height + width + unit + description;
    }
}
