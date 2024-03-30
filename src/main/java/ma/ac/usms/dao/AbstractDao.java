package ma.ac.usms.dao;

import com.mongodb.client.MongoDatabase;
import ma.ac.usms.config.MongoClientConnection;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class AbstractDao {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjectDao.class);
    protected MongoDatabase mongoDatabase;

    public AbstractDao(MongoDatabase db) {
        LOGGER.error("createing abstractDao");
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        this.mongoDatabase=db.withCodecRegistry(pojoCodecRegistry);
    }
}
