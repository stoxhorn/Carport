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
        this.name = "Trykimp. bræt. understern, ";
        this.sideAmount = " 4";
        this.frontBackAmount = " 4";
        this.height = " Højde: 25mm,";
        this.width = " Bredde: 200mm,";
        this.sideLength = sideLength;
        this.frontBackLength = frontBackLength;
        this.unit = " Enhed: stk.";
        this.sideDescription = " understernbrædder til sider";
        this.frontBackDescription = " understernbrædder til for & bag ende";
    }

    @Override
    public String toString() {
        return  name + "Antal sider:" +  sideAmount + " Antal for og bagende:" + frontBackAmount +  height +
                width + " Sider: "+  sideLength + "cm, For og bagende: " + frontBackLength + "cm," + unit +
                " Sider:"+ sideDescription + ", For og bagende:" + frontBackDescription;
    }
}