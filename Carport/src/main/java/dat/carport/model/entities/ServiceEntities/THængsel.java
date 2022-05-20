package dat.carport.model.entities.ServiceEntities;

public class THængsel {
    String name;
    String amount;
    String width;
    String unit;
    String description;

    public THængsel() {
        this.name = "Skruer, ";
        this.amount = " 2,";
        this.width = " Bredde: 390mm,";
        this.unit = " Enhed: stk.,";
        this.description = " til skurdør";
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + width + unit + description;
    }
}
