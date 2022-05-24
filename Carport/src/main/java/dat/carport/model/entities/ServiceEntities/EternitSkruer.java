package dat.carport.model.entities.ServiceEntities;

public class EternitSkruer {
    String name;
    String amount;
    String unit;
    String description;
    double price;

    public EternitSkruer(String amount, double price){
        this.name = "Eternitskruer";
        this.amount = amount;
        this.unit = ", Enhed: pakke,";
        this.description = " Eternitskruer til fastgørelse af eternitplader";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + ", Antal: " + amount + unit + description + " Pris: " + price + "kr.";
    }
}
