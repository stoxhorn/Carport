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
    String description;

    public VandBræt(String frontBackAmount, String sideLength, String frontBackLength) {
        this.name = "Trykimp. vandbræt, ";
        this.sideAmount = " 4, ";
        this.frontBackAmount = frontBackAmount;
        this.height = ", Højde: 19mm,";
        this.width = " Bredde: 100mm, ";
        this.sideLength = sideLength;
        this.frontBackLength = frontBackLength;
        this.unit = " Enhed: stk.,";
        this.description = " Vandbrædt på stern i forende, bagende og sider,";
    }

    @Override
    public String toString() {
        return  name + "Antal sider: " +  sideAmount + "Antal for og bagende: " + frontBackAmount +  height +
                width + "Sider: "+  sideLength + "cm, For og bagende: " + frontBackLength + "cm," + unit +
                description;
    }
}
