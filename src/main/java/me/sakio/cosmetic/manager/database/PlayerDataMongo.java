package me.sakio.cosmetic.manager.database;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import lombok.Getter;
import lombok.Setter;
import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.manager.objects.Gadgets;
import me.sakio.cosmetic.manager.objects.Trails;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Project: Cosmetic
 * Date: 09/06/2021 @ 10:10
 * Class: PlayerDataMongo
 */
@Getter
@Setter
public class PlayerDataMongo {

    private static Map<UUID, PlayerDataMongo> playerDataMongoHashMap = new HashMap<>();

    private String name;
    private UUID uuid;

    private Trails trails;
    private Gadgets gadgets;

    public PlayerDataMongo(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;

        if(this.getGadgets() != null) this.setGadgets(Gadgets.DEFAULT);
        if(this.getTrails() != null) this.setTrails(Trails.DEFAULT);

        this.load();

        playerDataMongoHashMap.put(uuid, this);
    }

    public void save() {
        Document document = new Document("_id", this.uuid);

        document.put("name", this.name);
        document.put("gadgets", this.gadgets);
        document.put("trails", this.trails);

        Bson filter = Filters.eq("_id", this.uuid);
        FindIterable iterable = Cosmetic.getInstance().getMongoConnection().getProfilesCollection().find(filter);

        if (iterable.first() == null) {
            Cosmetic.getInstance().getMongoConnection().getProfilesCollection().insertOne(document);
        } else {
            Cosmetic.getInstance().getMongoConnection().getProfilesCollection().replaceOne(filter, document);
        }
    }

    public void load() {
        Document document = (Document) Cosmetic.getInstance().getMongoConnection().getProfilesCollection().find(Filters.eq("_id", this.uuid)).first();

        if (document == null) return;

        this.name = document.getString("name");
        this.gadgets = Gadgets.valueOf(document.getString("gadgets"));
        this.trails = Trails.valueOf(document.getString("trails"));
    }

    public static PlayerDataMongo getPlayer(Player player) {
        return playerDataMongoHashMap.get(player.getUniqueId());
    }
}
