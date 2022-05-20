package dat.carport.model.entities.ServiceEntities;

public class DørLægte {
    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;

    public DørLægte() {
        this.name = "Lægte ubh., ";
        this.amount = " Antal: 1,";
        this.height = " Højde: 38mm,";
        this.width = " Bredde: 73mm,";
        this.length = " Længde: 420cm,";
        this.unit = " Enhed: stk.,";
        this.description = " til z på bagside af dør";
    }

    @Override
    public String toString() {
        return name + amount + height + width + length + unit + description;
    }
}
