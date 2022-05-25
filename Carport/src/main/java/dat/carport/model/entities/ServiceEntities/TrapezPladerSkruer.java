package dat.carport.model.entities.ServiceEntities;

public class TrapezPladerSkruer {
    String name;
    String amount;
    String unit;
    String description;

    public TrapezPladerSkruer(String amount) {
        this.name = "Trapezplade bundskruer, ";
        this.amount = amount;
        this.unit = ", Enhed: pakke,";
        this.description = " Skruer til plastmo tagplader kommer i pakker af 200 stk.";
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + unit + description;
    }
}
