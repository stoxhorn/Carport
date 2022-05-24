package dat.carport.model.entities.ServiceEntities;

public class Stolpe {
        String name;
        String amount;
        String height;
        String width;
        String unit;
        String description;
        String length;

    public Stolpe(String amount) {
        this.name = "Trykimp. stolpe, ";
        this.height = " Højde: 97mm,";
        this.width = " Bredde: 97mm,";
        this.length = " Længde: 300cm,";
        this.unit = " Enhed: stk.,";
        this.description = " stolper nedgraves 90 cm. i jord";
        this.amount = amount;
    }

    @Override
        public String toString(){
            return name + "Antal: " + amount + height + width + length + unit + description;
        }
}

