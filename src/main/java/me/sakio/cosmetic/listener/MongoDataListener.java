package me.sakio.cosmetic.listener;

import me.sakio.cosmetic.manager.database.MongoConnection;
import me.sakio.cosmetic.manager.objects.Gadgets;
import me.sakio.cosmetic.manager.objects.Trails;
import org.bson.Document;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Project: Cosmetic
 * Date: 09/06/2021 @ 16:06
 * Class: MongoDataListener
 */
public class MongoDataListener {
    @EventHandler
    public void createDataOnJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Document playerDocs = new Document("UUID", player.getUniqueId());
        Document found = (Document) new MongoConnection().getProfilesCollection().find(playerDocs).first();
        if (found == null){
            playerDocs.append("TRAILS", Trails.DEFAULT);
            playerDocs.append("GADGETS", Gadgets.DEFAULT);
            new MongoConnection().getProfilesCollection().insertOne(playerDocs);
        }else{
            
        }
    }
}
