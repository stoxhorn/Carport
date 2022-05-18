package dat.carport.model.entities.ServiceEntities;

public class OverStern {
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


    public OverStern(String frontBackAmount, String sideLength, String frontBackLength) {
        this.name = "Trykimp. bræt. overstern, ";
        this.sideAmount = " 4,";
        this.frontBackAmount = frontBackAmount;
        this.height = ", Højde: 25mm,";
        this.width = " Bredde: 125mm,";
        this.sideLength = sideLength;
        this.frontBackLength = frontBackLength;
        this.unit = " Enhed: stk.,";
        this.sideDescription = " oversternbrædder til sider,";
        this.frontBackDescription = " oversternbrædder til for & bag ende";
    }

    @Override
    public String toString() {
        return  name + "Antal sider:" +  sideAmount + " Antal for og bagende:" + frontBackAmount +  height +
                width + "Sider: "+  sideLength + "cm, For og bagende: " + frontBackLength + "cm," + unit +
                " Sider:"+ sideDescription + " For og bagende:" + frontBackDescription;
    }
}
