package dat.carport.model.entities.ServiceEntities;

public class Vindskeder {
    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public Vindskeder(String amount, double price){
        this.name = "Vindskeder, ";
        this.amount = amount;
        this.height = ", Højde: 100mm";
        this.width = ", Bredde: 19mm,";
        this.length = "270";
        this.unit = ", Enhed: stk.,";
        this.description = " Vindskeder til tag med hældning";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + "Antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
