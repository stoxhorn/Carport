package dat.carport.model.entities.ServiceEntities;

public class TrapezPladerSkruer {
    String name;
    String amount;
    String unit;
    String description;
    double price;

    public TrapezPladerSkruer(String amount, double price) {
        this.name = "Plastmo bundskruer, ";
        this.amount = amount;
        this.unit = ", Enhed: pakke,";
        this.description = " Skruer til tagplader kommer i pakker af 200 stk.";
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + unit + description + " Pris: " + price + "kr.";
    }
}
