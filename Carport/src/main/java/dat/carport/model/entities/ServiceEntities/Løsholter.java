package dat.carport.model.entities.ServiceEntities;

import static java.lang.Integer.parseInt;

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
    double price;

    public Løsholter() {
        this.name = "Reglar ub. sider og gavl, ";
        this.height = ", Højde: 45mm,";
        this.width = " Bredde: 95mm,";
        this.sideLength = " Længde sider: 240cm,";
        this.gavlLength = " Længde gavl: 270cm,";
        this.unit = " Enhed: stk.,";
        this.sideDescription = " løsholter til skur sider,";
        this.gavlDescription = " løsholter til skur gavle";
    }

    public Løsholter(String sideAmount, String gavlAmount, double price) {
        this.sideAmount = sideAmount;
        this.gavlAmount = gavlAmount;
        this.price = price;
    }

    public int getSideAmount() {
        return parseInt(sideAmount.replaceAll("[^0-9]", ""));
    }

    public int getGavlAmount() {
        return parseInt(gavlAmount.replaceAll("[^0-9]", ""));
    }

    public int getSideLength() {
        return parseInt(sideLength.replaceAll("[^0-9]", ""));
    }

    public int getGavlLength() {
        return parseInt(gavlLength.replaceAll("[^0-9]", ""));
    }



    @Override
    public String toString() {
        return name + "Antal sider: " + sideAmount + ", Antal gavl:" + gavlAmount + height + width + sideLength +
                gavlLength + unit + " Sider:"+ sideDescription + " Gavl:" + gavlDescription + " Pris: " + price + "kr.";
    }
}
