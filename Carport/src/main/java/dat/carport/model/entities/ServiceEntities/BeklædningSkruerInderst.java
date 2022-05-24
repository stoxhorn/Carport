package dat.carport.model.entities.ServiceEntities;

public class BeklædningSkruerInderst {
    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;

    public BeklædningSkruerInderst(String amount) {
        this.name = "Skruer, ";
        this.amount = amount;
        this.height = ", Højde: 4,5mm,";
        this.width = " Bredde: 50mm,";
        this.unit = " Enhed: pakke,";
        this.description = " til montering af inderste beklædning kommer i pakker med 300";
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + height + width + unit + description;
    }
}
