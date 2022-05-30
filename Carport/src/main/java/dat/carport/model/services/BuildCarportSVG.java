package dat.carport.model.services;

import dat.carport.model.entities.ServiceEntities.CustomerRequestData;

public class BuildCarportSVG {

    SVG svg;
    double width;
    double height;
    boolean shed;
    int xOffset;
    int yOffset;
    public BuildCarportSVG(CustomerRequestData crData){
        // this.svg = new SVG(0,0, "0 0 " + crData.getCarportWidth()+20 + " " +crData.getCarportLength()+20, 100, 100);
        this.xOffset = 41;
        this.yOffset = 40;
        this.width = Integer.parseInt(crData.getCarportLength());
        this.height = Integer.parseInt(crData.getCarportWidth());

        this.svg = new SVG(0,0, "0 0 " + (this.width + 45) + " " + (this.height + 45), 100, 100);
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
        this.svg.addRect(this.xOffset+xOffset,this.yOffset/2, this.height,5);
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
        yOffset = (int) (this.height-70);
        iterator = 0;
        while(iterator < loopamount+shedOffset){

            this.addStolpe(xOffset, yOffset);

            xOffset += 310;
            iterator++;
        }
    }

    public void addStolpe(int xOffset, int yOffset){
        this.svg.addRect(this.xOffset+xOffset, 30+yOffset+(this.yOffset/2), 10.,10);
    }

    public void addTværBrædder(){
        this.svg.addRect(this.xOffset,33+(this.yOffset/2), 5.,this.width);
        this.svg.addRect(this.xOffset, (int) (this.height-37)+(this.yOffset/2), 5.,this.width);
    }

    public void addBottomLine(){
        // bottom width line
        this.svg.addLine(this.xOffset, (int) (this.height)+this.yOffset-10, (int) this.width + this.xOffset, (int) ((this.height)+this.yOffset - 10));

        this.svg.addText((int) ((this.xOffset+this.width)/2), (int) (this.height+this.yOffset)+2, 0, this.width + "cm");

        // bottom widthline ends
        this.svg.addLine(this.xOffset, (int) this.height+this.yOffset-20, this.xOffset, (int) this.height +this.yOffset);
        this.svg.addLine((int) (this.width+this.xOffset), (int) this.height+this.yOffset-20, (int) (this.xOffset+this.width), (int) (this.height+this.yOffset));
    }

    public void addSideLines(){
        // left side heigth line
        this.svg.addLine(11, this.yOffset/2, 11, (int) (this.height+(this.yOffset/2)));

        this.svg.addText(11, (int) ((this.height+this.yOffset)/2), 270, (this.height) + "cm");

        // left side heightline ends
        this.svg.addLine(0, this.yOffset/2, 20, this.yOffset/2);
        this.svg.addLine(0, (int) (this.height + this.yOffset/2), 20, (int) (this.height + this.yOffset/2));

        // left side heigth line
        this.svg.addLine(31, this.yOffset/2 +35, 31, (int) (this.height + this.yOffset/2 -35));
        this.svg.addText( 31, (int) ((this.height+this.yOffset)/2), 270, (this.height-70) + "cm");
        // left side heightline ends
        this.svg.addLine(20, this.yOffset/2 +35, 40, this.yOffset/2 +35);
        this.svg.addLine(20, (int) (this.height + this.yOffset/2 -35), 40, (int) (this.height + this.yOffset/2 -35));

    }

    public void addTopLines(){
        this.svg.addLine(this.xOffset, 10, (int) (this.width+this.xOffset), 10);

        int loopamount = (int) (this.width /55);

        int xOffset = this.xOffset;
        while(loopamount > -1){

            this.svg.addLine(xOffset, 0, xOffset, 20);
            if(loopamount > 0){
                this.svg.addText(xOffset+7, 25, 0,"55cm");
            }


            xOffset += 55;
            loopamount--;
        }
    }

}
