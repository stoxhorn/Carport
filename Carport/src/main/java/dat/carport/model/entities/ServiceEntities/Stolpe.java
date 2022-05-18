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
        this.name = "Trykimp. stolpe ";
        this.height = " 97mm";
        this.width = " 97mm";
        this.length = " 300cm";
        this.unit = " Enhed: stk.";
        this.description = " stolper nedgraves 90 cm. i jord";
        this.amount = amount;
    }

    @Override
        public String toString(){
          String ret = "";

          ret += name;
          ret += amount;
          ret += height;
          ret += width;
          ret += unit;
          ret += description;
          return ret;
        }
}

