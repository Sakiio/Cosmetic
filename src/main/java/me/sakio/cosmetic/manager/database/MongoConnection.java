package me.sakio.cosmetic.manager.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;

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
        client = new MongoClient("127.0.0.1", 27017);
        this.database = client.getDatabase("hydra");
        this.profilesCollection = this.database.getCollection("profiles");
    }
}
