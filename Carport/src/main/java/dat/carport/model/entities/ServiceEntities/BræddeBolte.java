package dat.carport.model.entities.ServiceEntities;

public class BræddeBolte {
    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;
    double price;

    public BræddeBolte(String amount, double price) {
        this.name = "Bræddebolt, ";
        this.amount = amount;
        this.height = ", Højde: 10mm,";
        this.width = " Bredde: 120mm,";
        this.unit = " Enhed: stk.,";
        this.description = " til montering af rem på stolper";
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + height + width + unit + description + " Pris: " + price + "kr.";
    }
}
