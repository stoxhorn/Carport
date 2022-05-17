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
    String sideDescription;
    String gavlDescription;

    public Løsholter(String sideAmount, String gavlAmount) {
        this.name = "Reglar ub. sider og gavl";
        this.sideAmount = sideAmount;
        this.gavlAmount = gavlAmount;
        this.height = " 45mm";
        this.width = " 95mm";
        this.sideLength = " Længde sider: 240cm";
        this.gavlLength = " Længde gavl: 270cm";
        this.unit = " Enhed: stk.";
        this.sideDescription = " løsholter til skur sider";
        this.gavlDescription = " løsholter til skur gavle";
    }

    @Override
    public String toString() {
        return name + "antal sider: " + sideAmount + " antal gavl:" + gavlAmount + height + width + sideLength +
                gavlLength + unit + " sider:"+ sideDescription + " gavl:" + gavlDescription;
    }
}
