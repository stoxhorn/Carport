package dat.carport.model.entities.ServiceEntities;

public class Stalddørsgreb {
    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;
    double price;

    public Stalddørsgreb(double price) {
        this.name = "Stalddørsgreb, ";
        this.amount = " 1,";
        this.height = " Højde: 50mm,";
        this.width = " Bredde: 75mm,";
        this.unit = " Enhed: sæt,";
        this.description = " til lås på skur dør";
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + height + width + unit + description + " Pris: " + price + "kr.";
    }
}
