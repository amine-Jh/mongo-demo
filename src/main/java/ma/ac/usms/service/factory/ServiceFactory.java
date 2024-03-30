package ma.ac.usms.service.factory;

import com.mongodb.client.MongoDatabase;
import ma.ac.usms.config.MongoClientConnection;
import ma.ac.usms.dao.ProjectDao;
import ma.ac.usms.dao.TacheDao;
import ma.ac.usms.service.ProjectService;
import ma.ac.usms.service.TacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceFactory {

    private static Logger LOGGER= LoggerFactory.getLogger(ServiceFactory.class);

    public static ProjectService getprojectService(){
        LOGGER.error("getting project service");
        MongoDatabase db=MongoClientConnection.getInstance().getMongoDb();
        ProjectDao projectDao=ProjectDao.getInstance(db);
        return new ProjectService(projectDao);
    }

    public static TacheService getTacheService(){
        LOGGER.error("getting Tache service");
        MongoDatabase db=MongoClientConnection.getInstance().getMongoDb();
        TacheDao tacheService= TacheDao.getInstance(db);
        return new TacheService(tacheService);
    }

}
