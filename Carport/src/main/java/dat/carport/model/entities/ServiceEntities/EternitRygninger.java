package dat.carport.model.entities.ServiceEntities;

public class EternitRygninger {
    String name;
    String amount;
    String length;
    String unit;
    String description;
    double price;

    public EternitRygninger(String name, String amount, double price){
        this.name = name;
        this.amount = amount;
        this.length = "110";
        this.unit = ", Enhed: stk.,";
        this.description = " Eternit tagrygninger til beklædning af tag";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + " tagrygninger, " + "Antal: " + amount + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
