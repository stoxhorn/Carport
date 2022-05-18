package dat.carport.model.entities.ServiceEntities;

public class Rem {

    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;

    public Rem(String length) {
        this.name = "Spærtræ ubh., ";;
        this.amount = " 2,";
        this.height = " Højde: 195mm,";
        this.width = " Bredde: 45mm,";
        this.length = length;
        this.unit = ", Enhed: stk.,";
        this.description = " Remme i sider, sadles ned i stolper";
    }

    @Override
    public String toString() {
        return name + "antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description;
    }
}
