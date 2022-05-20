package dat.carport.model.services;

import dat.carport.model.entities.DBEntities.DBMaterials;
import dat.carport.model.entities.ServiceEntities.Materials;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.MaterialsMapper;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class CRUDMaterialsService {

    public static Materials readMaterial(String id, ConnectionPool cp) throws DatabaseException {
        MaterialsMapper mMapper = new MaterialsMapper(cp);
        for(DBMaterials dbm : mMapper.getMaterials()){
            if(dbm.getId() == Integer.getInteger(id)){
                return new Materials(dbm);
            }
        }
        return null;
    }

    public static ArrayList<Materials> getMaterials(ConnectionPool cp) throws DatabaseException{
        MaterialsMapper mMapper = new MaterialsMapper(cp);
        ArrayList<DBMaterials> dbmList = new ArrayList<>(mMapper.getMaterials());
        ArrayList<Materials> mList = new ArrayList<>();
        for(DBMaterials dbm : dbmList){
            Materials m = new Materials(dbm);
            mList.add(m);
        }
        return mList;

    }

    public static void createMaterials(String description, ConnectionPool cp) throws DatabaseException {
        MaterialsMapper mMapper = new MaterialsMapper(cp);

        // get highest ID in database +1
        int id = 0;
        for(DBMaterials dbm : mMapper.getMaterials()){
            if(dbm.getId() > id){
                id = dbm.getId() + 1;
            }
        }
        mMapper.createMaterial(new DBMaterials(id, description));
    }

    public static void updateMaterials(Materials mats, ConnectionPool cp) throws DatabaseException {
        MaterialsMapper mMapper = new MaterialsMapper(cp);
        mMapper.updateMaterials(new DBMaterials(mats));
    }

    public static void deleteMaterials(String id, ConnectionPool cp) throws DatabaseException {
        deleteMaterials(Integer.parseInt(id), cp);
    }
    public static void deleteMaterials(Materials mats, ConnectionPool cp) throws DatabaseException {
        deleteMaterials(new DBMaterials(mats), cp);
    }
    public static void deleteMaterials(int id, ConnectionPool cp) throws DatabaseException {
        MaterialsMapper mMapper = new MaterialsMapper(cp);
        for(DBMaterials dbm : mMapper.getMaterials()){
            if(dbm.getId() == id){
                deleteMaterials(dbm, cp);
            }
        }
    }
    private static void deleteMaterials(DBMaterials dbm, ConnectionPool cp) throws DatabaseException {
        MaterialsMapper mMapper = new MaterialsMapper(cp);
        mMapper.deleteMaterial(dbm);
    }
}
