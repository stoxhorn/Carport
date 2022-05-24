package dat.carport.model.entities.ServiceEntities;

public class SkurBeklædning {
    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;

    public SkurBeklædning(String amount) {
        this.name = "Tryk imp. bræt, ";
        this.amount = amount;
        this.height = ", Højde: 19mm,";
        this.width = " Bredde: 100mm,";
        this.length = " Længde: 210cm,";
        this.unit = " Enhed: stk.,";
        this.description = " til beklædning af skur 1 på 2";
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + height + width + length + unit + description;
    }
}
