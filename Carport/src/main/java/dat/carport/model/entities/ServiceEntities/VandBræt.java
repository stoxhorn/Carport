package dat.carport.model.entities.ServiceEntities;

import static java.lang.Integer.parseInt;

public class VandBræt {
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

    public VandBræt() {
        this.name = "Trykimp. bræt. overstern, ";
        this.sideAmount = " 4,";
        this.height = ", Højde: 19mm,";
        this.width = " Bredde: 100mm,";
        this.unit = " Enhed: stk.,";
        this.sideDescription = " vandbrædt på stern i sider,";
        this.frontBackDescription = " vandbrædt på stern i for & bag ende,";
    }

    public VandBræt(String frontBackAmount, String sideLength, String frontBackLength, double price) {
        this.frontBackAmount = frontBackAmount;
        this.sideLength = sideLength;
        this.frontBackLength = frontBackLength;
        this.price = price;
    }

    public int getFrontBackAmount() {
        return parseInt(frontBackAmount.replaceAll("[^0-9]", ""));
    }

    public int getSideAmount() {
        return parseInt(sideAmount.replaceAll("[^0-9]", ""));
    }

    public int getSideLength() {
        return parseInt(sideLength.replaceAll("[^0-9]", ""));
    }

    public int getFrontBackLength() {
        return parseInt(frontBackLength.replaceAll("[^0-9]", ""));
    }

    @Override
    public String toString() {
        return  name + "Antal sider: " +  sideAmount + "Antal for og bagende: " + frontBackAmount +  height +
                width + "Sider: "+  sideLength + "cm, For og bagende: " + frontBackLength + "cm," + unit +
                " Sider: "+ sideDescription + " For og bagende" + frontBackDescription + " Pris: " + price + "kr.";
    }
}
