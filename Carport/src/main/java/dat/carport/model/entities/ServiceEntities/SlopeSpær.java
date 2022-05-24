package dat.carport.model.entities.ServiceEntities;

public class SlopeSpær {

    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public SlopeSpær(String amount, String length, double price){
        this.name = "Spærtræ ubh., ";
        this.amount = amount;
        this.height = ", Højde: 100mm";
        this.width = ", Bredde: 50mm,";
        this.length = length;
        this.unit = ", Enhed: stk.,";
        this.description = " Spær til tag med hældning monteres på rem";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + "Antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
