package dat.carport.model.services;

import dat.carport.model.entities.ServiceEntities.CustomerRequest;

public class SVGService {

    public static String getCarpotSVGString(CustomerRequest cr){
        BuildCarportSVG bSVG = new BuildCarportSVG();
        bSVG.addAllBjælker();
        bSVG.addTværBrædder();
        bSVG.addAllStolper();

        return bSVG.svg.toString();
    }
}
