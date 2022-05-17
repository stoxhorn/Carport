package dat.carport.model.entities.ServiceEntities;

public class TrapezPlader {
    String name;
    String amount;
    String width;
    String length;
    String unit;
    String description;

    public TrapezPlader(String amount, String length) {
        this.name = "Plastmo ecolite blåtonet ";
        this.amount = amount;
        this.width = " 110cm";
        this.length = length;
        this.unit = " Enhed: stk.";
        this.description = " tagplader monteres på spær";
    }

    @Override
    public String toString() {
        return name + "antal: " + amount + width + length + "cm" + unit + description;
    }
}
