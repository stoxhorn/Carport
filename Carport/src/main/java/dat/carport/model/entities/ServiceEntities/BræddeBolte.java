package dat.carport.model.entities.ServiceEntities;

public class BræddeBolte {
    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;

    public BræddeBolte(String amount) {
        this.name = "Bræddebolt, ";
        this.amount = amount;
        this.height = ", Højde: 10mm,";
        this.width = " Bredde: 120mm,";
        this.unit = " Enhed: stk.,";
        this.description = " til montering af rem på stolper";
    }

    @Override
    public String toString() {
        return name + "antal: " + amount + height + width + unit + description;
    }
}
