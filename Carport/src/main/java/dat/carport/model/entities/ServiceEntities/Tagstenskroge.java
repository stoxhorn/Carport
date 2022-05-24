package dat.carport.model.entities.ServiceEntities;

public class Tagstenskroge {
    String name;
    String amount;
    String unit;
    String description;
    double price;

    public Tagstenskroge(String amount, double price){
        this.name = "Tagstenskroge 533";
        this.amount = amount;
        this.unit = ", Enhed: stk.,";
        this.description = " Tagstenskroge til fastgørelse af tagsten";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + ", Antal: " + amount + unit + description + " Pris: " + price + "kr.";
    }
}
