package dat.carport.model.entities.ServiceEntities;

public class TagLægter {

    String name;
    String amount;
    String height;
    String width;
    String length;
    String unit;
    String description;
    double price;

    public TagLægter(String amount, double price){
        this.name = "Lægter, ";
        this.amount = amount;
        this.height = ", Højde: 73mm";
        this.width = ", Bredde: 38mm,";
        this.length = "300";
        this.unit = ", Enhed: stk.,";
        this.description = " Taglægter til tag med hældning";
        this.price = price;
    }

    @Override
    public String toString(){
        return name + "Antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description + " Pris: " + price + "kr.";
    }
}
