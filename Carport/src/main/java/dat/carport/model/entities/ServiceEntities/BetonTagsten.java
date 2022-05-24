package dat.carport.model.entities.ServiceEntities;

public class BetonTagsten {
    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public BetonTagsten(String name, String amount, double price){
        this.name = name;
        this.amount = amount;
        this.height = ", Højde: 336mm";
        this.width = ", Bredde: 10mm,";
        this.length = "40,4";
        this.unit = ", Enhed: stk.,";
        this.description = " Betontagsten til beklædning af tag";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + ", Antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
