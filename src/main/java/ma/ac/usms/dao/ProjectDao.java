package ma.ac.usms.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ma.ac.usms.dto.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProjectDao extends AbstractDao{

    private static Logger LOGGER = LoggerFactory.getLogger(ProjectDao.class);
    private static ProjectDao instance;
    public static ProjectDao getInstance(MongoDatabase db){
        LOGGER.error("getting instance of ProjectService");
        if(instance == null){
            instance= new ProjectDao(db);
        }
        return instance;

    }
    private MongoCollection<Project> projectCollection;

    private ProjectDao(MongoDatabase mongoDatabase) {
        super(mongoDatabase);
        this.projectCollection=this.mongoDatabase.getCollection("projects", Project.class);
    }

    public List<Project> getProjects(){
        List<Project> taches = new ArrayList<>();
        return this.projectCollection.find().into(taches);
    }

    public boolean deleteProject(Project project){
        return this.projectCollection.deleteOne(Filters.eq("owner",project.getOwner())).getDeletedCount()>0;

    }

    public void   createProject(Project project){
        this.projectCollection.insertOne(project);
    }
}
