package dat.carport.model.entities.ServiceEntities;

public class BeklædningSkruerInderst {
    String name;
    String amount;
    String length;
    String width;
    String unit;
    String description;
    double price;

    public BeklædningSkruerInderst(String amount, double price) {
        this.name = "Skruer, ";
        this.amount = amount;
        this.length = ", Længde: 50mm,";
        this.width = " Bredde: 4,5mm,";
        this.unit = " Enhed: pakke,";
        this.description = " til montering af inderste beklædning kommer i pakker med 300";
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + length + width + unit + description + " Pris: " + price + "kr.";
    }
}
