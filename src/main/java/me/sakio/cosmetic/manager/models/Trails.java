package me.sakio.cosmetic.manager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Effect;

@AllArgsConstructor
@Getter
public enum Trails {

    //Default Trails is create to avoid some errors in console when you run without a trails
    DEFAULT("DEFAULT", null, ""),
    FIRE("FIRE", Effect.FLAME, "trails.flame"),
    NOTE("NOTE", Effect.NOTE, "trails.note"),
    HEART("HEART", Effect.HEART, "trails.heart"),
    CRITIC("CRITIC", Effect.CRIT, "trails.critic"),
    SMOKE("HEART", Effect.SMOKE, "trails.smoke"),
    FIREWORKS_SPARK("FIREWORKS_SPARK", Effect.FIREWORKS_SPARK, "trails.fireworks"),
    PORTAL("PORTAL", Effect.PORTAL, "trails.portal"),
    EXPLOSION("EXPLOSION", Effect.EXPLOSION, "trails.explosion");


    /*Add new trails with this format
    TRAILS("NAME", Effect.YourEffect, "your.perms");
     */
    private final String name;
    private final Effect effect;
    private final String permission;
}
