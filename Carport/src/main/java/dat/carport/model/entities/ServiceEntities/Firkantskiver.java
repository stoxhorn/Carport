package dat.carport.model.entities.ServiceEntities;

public class Firkantskiver {
    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;

    public Firkantskiver(String amount) {
        this.name = "Firkantskiver ";
        this.amount = amount;
        this.height = " 11mm";
        this.width = " 40mm";
        this.length = " 40mm";
        this.unit = " stk.";
        this.description = " til montering af rem på stolper";
    }

    @Override
    public String toString() {
        return name + "antal: " + amount + height + width + length + unit + description;
    }
}
