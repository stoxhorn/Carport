package dat.carport.model.entities.ServiceEntities;

import static java.lang.Integer.parseInt;

public class VandBrætSkruer {
    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;
    double price;

    public VandBrætSkruer() {
        this.name = "Skruer til vandbræt og stern, ";
        this.amount = " Antal: 1,";
        this.height = " Højde: 4,5mm,";
        this.width = " Bredde: 60mm,";
        this.unit = " Enhed: pakke,";
        this.description = " Til montering af vandbræt og stern kommer i pakker med 200";
    }

    public VandBrætSkruer(double price) {
        this.price = price;
    }

    public int getAmount() {
        return parseInt(amount.replaceAll("[^0-9]", ""));
    }


    @Override
    public String toString() {
        return name + amount + height + width + unit + description + " Pris: " + price + "kr.";
    }
}
