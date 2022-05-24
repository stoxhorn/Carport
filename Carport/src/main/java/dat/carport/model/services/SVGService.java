package dat.carport.model.services;

import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.entities.ServiceEntities.CustomerRequestData;

public class SVGService {

    public static String getCarpotSVGString(CustomerRequest cr){
        BuildCarportSVG bSVG = new BuildCarportSVG(cr.getRequestData());
        bSVG.addAllBjælker();
        bSVG.addTværBrædder();
        bSVG.addAllStolper();
        bSVG.addBottomLine();
        bSVG.addSideLines();
        bSVG.addTopLines();

        return bSVG.svg.toString();
    }
}
