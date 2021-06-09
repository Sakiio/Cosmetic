package me.sakio.cosmetic.manager.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import me.sakio.cosmetic.Cosmetic;

/**
 * Project: Cosmetic
 * Date: 07/06/2021 @ 22:53
 * Class: MongoConnection
 */
@Getter
public class MongoConnection {
    String uri = Cosmetic.getInstance().getConfig().getString("MONGO.LINK");
    private final MongoDatabase database;
    private final MongoCollection profilesCollection;

    public MongoConnection() {
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clientURI);
        this.database = mongoClient.getDatabase(Cosmetic.getInstance().getConfig().getString("MONGO.NAME"));
        this.profilesCollection = this.database.getCollection(Cosmetic.getInstance().getConfig().getString("MONGO.COLLECTION"));
    }
}
