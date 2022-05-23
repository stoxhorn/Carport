package dat.carport.model.services;

public class BuildCarportSVG {

    SVG svg;
    double width;
    double height;
    boolean shed;
    public BuildCarportSVG(){
        this.svg = new SVG(0,0, "0 0 800 620", 120, 120);
        this.width = 780;
        this.height = 600;
        this.shed = false;
    }

    public void addAllBjælker(){
        int loopamount = (int) (this.width /55);
        int xOffset = 0;
        while(loopamount > -1){

            this.addBjælke(xOffset);

            xOffset += 55;
            loopamount--;
        }
    }

    public void addBjælke(int xOffset){
        this.svg.addRect(10+xOffset,0, this.height,5);
    }

    public void addAllStolper(){
        int loopamount = (int) (this.width /310);

        int xOffset = 100;
        int yOffset = 0;

        // ShedOffset is to add an extra Stolpe or not,
        // depending on whether there is a shed or not.
        int shedOffset = 1;
        if(this.shed){
            shedOffset = 0;
        }

        int iterator = 0;
        while(iterator < loopamount+shedOffset){

            this.addStolpe(xOffset, yOffset);

            xOffset += 310;
            iterator++;
        }
        xOffset = 100;
        yOffset = 530;
        iterator = 0;
        while(iterator < loopamount+shedOffset){

            this.addStolpe(xOffset, yOffset);

            xOffset += 310;
            iterator++;
        }
    }

    public void addStolpe(int xOffset, int yOffset){
        this.svg.addRect(15+xOffset, 30+yOffset, 10.,10);
    }

    public void addTværBrædder(){
        this.svg.addRect(10,33, 5.,this.width);
        this.svg.addRect(10,563, 5.,this.width);
    }
}
