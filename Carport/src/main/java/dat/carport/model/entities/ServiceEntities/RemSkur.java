package dat.carport.model.entities.ServiceEntities;

public class RemSkur {

    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;

    public RemSkur(String length) {
        this.name = "Spærtræ ubh., ";
        this.amount = " 1";
        this.height = ", Højde: 195mm";
        this.width = ", Bredde: 45mm";
        this.length = length;
        this.unit = " Enhed: stk.,";
        this.description = " Remme i sider, sadles ned i stolper (skur del, deles)";
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + height + width + " Længde: " + length + "cm," + unit + description;
    }
}
