package dat.carport.model.entities.ServiceEntities;

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

    public VandBræt(String frontBackAmount, String sideLength, String frontBackLength) {
        this.name = "Trykimp. bræt. overstern ";
        this.sideAmount = " 4";
        this.frontBackAmount = frontBackAmount;
        this.height = " 19mm";
        this.width = " 100mm";
        this.sideLength = sideLength;
        this.frontBackLength = frontBackLength;
        this.unit = " Enhed: stk.";
        this.sideDescription = " vandbrædt på stern i sider";
        this.frontBackDescription = " vandbrædt på stern i for & bag ende";
    }

    @Override
    public String toString() {
        return  name + "antal sider: " +  sideAmount + "antal for og bagende: " + frontBackAmount +  height +
                width + "sider: "+  sideLength + "cm, for og bagende: " + frontBackLength + "cm" + unit +
                "sider: "+ sideDescription + "for og bagende" + frontBackDescription;
    }
}
