package ma.ac.usms.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ma.ac.usms.dto.Project;
import ma.ac.usms.dto.Tache;

import java.util.ArrayList;
import java.util.List;

public class TacheDao extends AbstractDao {

    private static TacheDao instance;

    public static TacheDao getInstance(MongoDatabase db){
        if(instance == null){
            instance=new TacheDao(db);
        }
        return instance;

    }
    private MongoCollection<Tache> tacheCollection;
    private TacheDao(MongoDatabase db) {
        super(db);
        tacheCollection=db.getCollection("taches", Tache.class);
    }

    public List<Tache>  getTaches(){
        List<Tache> taches = new ArrayList<>();
        return tacheCollection.find().into(taches);
    }

    public void   createTache(Tache tache){
         tacheCollection.insertOne(tache);
    }

    public boolean deleteTache(Tache tache){
        return tacheCollection.deleteMany(Filters.eq("title",tache.getTitle())).getDeletedCount()>0;
    }
}
