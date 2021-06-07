package me.sakio.cosmetic.manager.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.sakio.cosmetic.Cosmetic;
import org.bson.Document;

/**
 * Project: Cosmetic
 * Date: 07/06/2021 @ 22:53
 * Class: MongoConnection
 */
public class MongoConnection {
    public void mongoConnection(){
        String mongoUrl = Cosmetic.getInstance().getConfig().getString("MONGO.URL");
        MongoClientURI clientURI = new MongoClientURI(mongoUrl);
        MongoClient mongoClient = new MongoClient(clientURI);

        MongoDatabase mongoDatabase = mongoClient.getDatabase(Cosmetic.getInstance().getConfig().getString("MONGO.NAME"));
        MongoCollection<Document> collection = mongoDatabase.getCollection(Cosmetic.getInstance().getConfig().getString("MONGO.COLLECTION"));
    }
}
