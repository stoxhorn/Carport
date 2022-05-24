package dat.carport.model.entities.ServiceEntities;

public class Spær {

    String name;
    String raftersAmount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public Spær(String amount, String length, double price){
        this.name = "Spærtræ ubh., ";
        this.raftersAmount = amount;
        this.height = ", Højde: 195mm";
        this.width = ", Bredde: 45mm,";
        this.length = length;
        this.unit = ", Enhed: stk.,";
        this.description = " Spær monteres på rem";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + "Antal: " + raftersAmount + height + width + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }

}
