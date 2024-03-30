package ma.ac.usms.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoClientConnection {

    private static Logger LOGGER= LoggerFactory.getLogger(MongoClientConnection.class);
    private static final String USERNAME = "ayoub";
    private static final String PASSWORD = "ayoubayoub2003";
    private static final String DATABASE_NAME = "ayoubdb";
    private static final String CONNECTION_STRING =
            "mongodb+srv://" + USERNAME + ":" + PASSWORD +
                    "@amine-jh99.wb6y8rx.mongodb.net/?retryWrites=true&w=majority&appName=amine-jh99";

    private static volatile MongoClientConnection instance;
    private final MongoClient mongoClient;

    private MongoClientConnection() {
        LOGGER.error("mongo client getting");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                .build();
        this.mongoClient = MongoClients.create(settings);
    }

    public static MongoClientConnection getInstance() {

        if (instance == null) {
            instance = new MongoClientConnection();
        }
        return instance;
    }

    public MongoDatabase getMongoDb() {
        return mongoClient.getDatabase(DATABASE_NAME);
    }

}
