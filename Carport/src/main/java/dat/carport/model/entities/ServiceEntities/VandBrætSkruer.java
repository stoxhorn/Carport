package dat.carport.model.entities.ServiceEntities;

public class VandBrætSkruer {
    String name;
    String amount;
    String height;
    String width;
    String unit;
    String description;

    public VandBrætSkruer() {
        this.name = "Skruer til vandbræt og stern, ";
        this.amount = " Antal: 1,";
        this.height = " Højde: 4,5mm,";
        this.width = " Bredde: 60mm,";
        this.unit = " Enhed: pakke,";
        this.description = " Til montering af vandbræt og stern kommer i pakker med 200";
    }

    @Override
    public String toString() {
        return name + amount + height + width + unit + description;
    }
}
