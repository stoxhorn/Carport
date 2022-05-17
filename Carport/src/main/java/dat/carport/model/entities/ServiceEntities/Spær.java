package dat.carport.model.entities.ServiceEntities;

public class Spær {

    String name;
    String raftersAmount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    String carportWidth;

    public Spær(String carportWidth, String amount, String length){
        this. name = "Spærtræ ubh. ";
        this. raftersAmount = amount;
        this. height = " 195mm";
        this. width = " 45mm";
        this. length = length;
        this. unit = " Enhed: stk.";
        this. description = " Spær, monteres på rem";
        this.carportWidth = carportWidth;
    }

    @Override
    public String toString(){
        return name+raftersAmount+height+width+length+unit+description+carportWidth;
    }

}
