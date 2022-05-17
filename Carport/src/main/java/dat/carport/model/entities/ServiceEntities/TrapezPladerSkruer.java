package dat.carport.model.entities.ServiceEntities;

public class TrapezPladerSkruer {
    String name;
    String amount;
    String unit;
    String description;

    public TrapezPladerSkruer(String amount) {
        this.name = "Plastmo bundskruer ";
        this.amount = amount;
        this.unit = " Enhed: pakke";
        this.description = " Skruer til tagplader kommer i pakker af 200 stk.";
    }
}
