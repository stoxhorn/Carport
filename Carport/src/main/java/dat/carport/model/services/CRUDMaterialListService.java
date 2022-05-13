package dat.carport.model.services;

import dat.carport.model.entities.DBEntities.DBMaterials;
import dat.carport.model.entities.DBEntities.DBMaterialsList;
import dat.carport.model.entities.DBEntities.DBMaterialsListLines;
import dat.carport.model.entities.ServiceEntities.MaterialListLine;
import dat.carport.model.entities.ServiceEntities.Materials;
import dat.carport.model.entities.ServiceEntities.MaterialsList;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.MaterialListLinesMapper;
import dat.carport.model.persistence.MaterialListMapper;
import dat.carport.model.persistence.MaterialsMapper;

import java.util.ArrayList;

public class CRUDMaterialListService {


    public static MaterialsList readMaterialList(String id, ConnectionPool cp) throws DatabaseException {
        return readMaterialList(Integer.parseInt(id), cp);
    }
    public static MaterialsList readMaterialList(int id, ConnectionPool cp) throws DatabaseException {
        MaterialListMapper mlMapper = new MaterialListMapper(cp);

        for(DBMaterialsList dbMl : mlMapper.getMaterialList()){
            if(dbMl.getId() == id){
                MaterialsList ml = new MaterialsList(dbMl);
                ml.fetchMaterialsListLines(cp);
                return ml;
            }
        }
        return null;
    }

    public static void createMaterialList(MaterialsList ml, ConnectionPool cp) throws DatabaseException {
        MaterialListMapper mlMapper = new MaterialListMapper(cp);
        MaterialListLinesMapper mllMapper = new MaterialListLinesMapper(cp);

        DBMaterialsList dbMl = new DBMaterialsList(ml);

        mlMapper.createMaterial(dbMl);

        for(MaterialListLine mll : ml.getLines()){
            DBMaterialsListLines dbMll = new DBMaterialsListLines(mll);
            mllMapper.createMaterialListLines(dbMll);
        }
    }

    public static void updateMaterialList(MaterialsList ml, ConnectionPool cp) throws DatabaseException {
        MaterialListMapper mlMapper = new MaterialListMapper(cp);
        MaterialListLinesMapper mllMapper = new MaterialListLinesMapper(cp);

        ArrayList<DBMaterialsListLines> list = new ArrayList<>(mllMapper.getMaterialListLines());
        DBMaterialsList dbMl = new DBMaterialsList(ml);

        mlMapper.updateMaterials(dbMl);


        updateMaterialListLines(list, mllMapper, ml);

        deleteOldLines(list, mllMapper, ml);

    }


    private static void updateMaterialListLines(ArrayList<DBMaterialsListLines> list, MaterialListLinesMapper mllMapper, MaterialsList ml) throws DatabaseException {
        // create or update materialsListLines
        for(MaterialListLine mll : ml.getLines()){
        boolean exists = false;
        for(DBMaterialsListLines dbMll : list){
            // if the line already exists, change the boolean value
            if(mll.getId() == dbMll.getId()){
                exists = true;
                break;}

        }

        if(exists){
            // if the line exists in the database: update
            mllMapper.updateMaterialListLines(new DBMaterialsListLines(mll));}
        else{
            // else create
            mllMapper.createMaterialListLines(new DBMaterialsListLines(mll));}
        }
    }
    private static void deleteOldLines(ArrayList<DBMaterialsListLines> list, MaterialListLinesMapper mllMapper, MaterialsList ml) throws DatabaseException {
        // i now have to delete the lines that no longer belong to this list
        for(DBMaterialsListLines dbMll : list){
            // if the DB objects's ID does NOT match any in the Service Entity lines:
            if(!(isIdInList(dbMll.getId(), ml.getLines()))){
                mllMapper.deleteMaterialListLines(dbMll);
            }
        }
    }
    private static boolean isIdInList(int id, ArrayList<MaterialListLine> list){
        for(MaterialListLine mll : list){
            if(id == mll.getId()){
                return true;
            }
        }
        return false;
    }

    public static void deleteMaterialList(String id, ConnectionPool cp) throws DatabaseException {
        deleteMaterialList(Integer.parseInt(id), cp);
    }
    public static void deleteMaterialList(int id, ConnectionPool cp) throws DatabaseException {
        MaterialListMapper mlMapper = new MaterialListMapper(cp);
        for(DBMaterialsList dbMl : mlMapper.getMaterialList()){
            if(dbMl.getId() == id){
                deleteMaterialList(dbMl, cp);
                return;
            }
        }
    }
    public static void deleteMaterialList(MaterialsList ml, ConnectionPool cp) throws DatabaseException {
        DBMaterialsList dbMl = new DBMaterialsList(ml);
        deleteMaterialList(dbMl, cp);
    }
    private static void deleteMaterialList(DBMaterialsList dbMl, ConnectionPool cp) throws DatabaseException {
        MaterialListMapper mlMapper = new MaterialListMapper(cp);
        mlMapper.deleteMaterial(dbMl);
    }
}
