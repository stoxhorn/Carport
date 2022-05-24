package dat.carport.model.entities.ServiceEntities;

public class Eternitplader {
    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public Eternitplader(String name, String amount, double price){
        this.name = name;
        this.amount = amount;
        this.height = ", Højde: 1090mm";
        this.width = ", Bredde: 10mm,";
        this.length = "110";
        this.unit = ", Enhed: stk.,";
        this.description = " Eternitplader til beklædning af tag";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + ", Antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
