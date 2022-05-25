package dat.carport.model.entities.ServiceEntities;

public class Løsholter {
    String name;
    String sideAmount;
    String gavlAmount;
    String height;
    String width;
    String sideLength;
    String gavlLength;
    String unit;
    String description;

    public Løsholter(String sideAmount, String gavlAmount) {
        this.name = "Reglar ub. sider og gavl, ";
        this.sideAmount = sideAmount;
        this.gavlAmount = gavlAmount;
        this.height = ", Højde: 45mm,";
        this.width = " Bredde: 95mm,";
        this.sideLength = " Længde sider: 240cm,";
        this.gavlLength = " Længde gavl: 270cm,";
        this.unit = " Enhed: stk.,";
        this.description = " løsholter til skur sider og gavl";
    }

    @Override
    public String toString() {
        return name + "Antal sider: " + sideAmount + ", Antal gavl: " + gavlAmount + height + width + sideLength +
                gavlLength + unit + description;
    }
}
