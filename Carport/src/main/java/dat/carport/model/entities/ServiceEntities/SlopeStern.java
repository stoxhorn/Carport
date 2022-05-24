package dat.carport.model.entities.ServiceEntities;

public class SlopeStern {
    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public SlopeStern(String amount, double price){
        this.name = "Sternbrædder, ";
        this.amount = amount;
        this.height = ", Højde: 100mm";
        this.width = ", Bredde: 19mm,";
        this.length = "300";
        this.unit = ", Enhed: stk.,";
        this.description = " Sternbrædder til stern og udhæng";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + "Antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
