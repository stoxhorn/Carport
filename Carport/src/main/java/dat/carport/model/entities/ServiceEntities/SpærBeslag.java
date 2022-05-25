package dat.carport.model.entities.ServiceEntities;

public class SpærBeslag {

    String name;
    String amount;
    String unit;
    String description;

    public SpærBeslag(String amount) {
        this.name = "Universalbeslag 190 mm højre og venstre, ";
        this.amount = amount;
        this.unit = ", Enhed: stk.,";
        this.description = " Spær beslag til montering af spær på rem";
    }

    @Override
    public String toString() {
        return name + "Antal: " + amount + unit + description;
    }
}
