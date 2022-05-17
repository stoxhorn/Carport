package dat.carport.model.entities.ServiceEntities;

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


    public UnderStern(String sideLength, String frontBackLength) {
        this.name = "Trykimp. bræt. understern ";
        this.sideAmount = " 4";
        this.frontBackAmount = " 4";
        this.height = " 25mm";
        this.width = " 200mm";
        this.sideLength = sideLength;
        this.frontBackLength = frontBackLength;
        this.unit = " Enhed: stk.";
        this.sideDescription = " understernbrædder til sider";
        this.frontBackDescription = " understernbrædder til for & bag ende";
    }

    @Override
    public String toString() {
        return  name + "antal sider: " +  sideAmount + " antal for og bagende: " + frontBackAmount +  height +
                width + " sider:"+  sideLength + "cm, for og bagende: " + frontBackLength + "cm" + unit +
                " sider:"+ sideDescription + " for og bagende:" + frontBackDescription;
    }
}
