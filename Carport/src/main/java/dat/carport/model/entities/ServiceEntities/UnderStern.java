package dat.carport.model.entities.ServiceEntities;

import static java.lang.Integer.parseInt;

public class UnderStern {
    String name;
    String sideAmount;
    String frontBackAmount;
    String height;
    String width;
    String sideLength;
    String frontBackLength;
    String unit;
    String sideDescription;
    String frontBackDescription;
    double price;

    public UnderStern() {
        this.name = "Trykimp. bræt. understern, ";
        this.sideAmount = " 4";
        this.frontBackAmount = " 4";
        this.height = " Højde: 25mm,";
        this.width = " Bredde: 200mm,";
        this.unit = " Enhed: stk.";
        this.sideDescription = " understernbrædder til sider";
        this.frontBackDescription = " understernbrædder til for & bag ende";
    }

    public UnderStern(String sideLength, String frontBackLength, double price) {
        this.sideLength = sideLength;
        this.frontBackLength = frontBackLength;
        this.price = price;
    }

    public int getSideAmount() {
        return parseInt(sideAmount.replaceAll("[^0-9]", ""));
    }

    public int getFrontBackAmount() {
        return parseInt(frontBackAmount.replaceAll("[^0-9]", ""));
    }

    public int getSideLength() {
        return parseInt(sideLength.replaceAll("[^0-9]", ""));
    }

    public int getFrontBackLength() {
        return parseInt(frontBackLength.replaceAll("[^0-9]", ""));
    }

    @Override
    public String toString() {
        return  name + "Antal sider:" +  sideAmount + " Antal for og bagende:" + frontBackAmount +  height +
                width + " Sider: "+  sideLength + "cm, For og bagende: " + frontBackLength + "cm," + unit +
                " Sider:"+ sideDescription + ", For og bagende:" + frontBackDescription + " Pris: " + price + "kr.";
    }
}
