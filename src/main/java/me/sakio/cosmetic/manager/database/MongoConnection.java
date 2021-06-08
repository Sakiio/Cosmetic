package me.sakio.cosmetic.manager.database;

import com.mongodb.MongoClient;
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
    private final MongoClient client;
    private final MongoDatabase database;
    private final MongoCollection profilesCollection;

    public MongoConnection() {
        client = new MongoClient(Cosmetic.getInstance().getConfig().getString("MONGO.HOST"), Cosmetic.getInstance().getConfig().getInt("MONGO.PORT"));
        this.database = client.getDatabase(Cosmetic.getInstance().getConfig().getString("MONGO.NAME"));
        this.profilesCollection = this.database.getCollection(Cosmetic.getInstance().getConfig().getString("MONGO.COLLECTION"));
    }
}
