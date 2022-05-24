package dat.carport.model.entities.ServiceEntities;

public class BetontagRygninger {
    String name;
    String amount;
    String length;
    String unit;
    String description;
    double price;

    public BetontagRygninger(String name, String amount, double price){
        this.name = name;
        this.amount = amount;
        this.length = "42";
        this.unit = ", Enhed: stk.,";
        this.description = " Betontagsten tagrygninger til beklædning af tag";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + " rygninger, Antal: " + amount + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
