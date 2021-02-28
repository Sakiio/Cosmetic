package me.sakio.cosmetic.manager.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Effect;

@AllArgsConstructor
@Getter
public enum Trails {

    DEFAULT("DEFAULT", null, ""),
    FIRE("FIRE", Effect.FLAME, "trails.flame"),
    NOTE("NOTE", Effect.NOTE, "trails.note"),
    HEART("HEART", Effect.HEART, "trails.heart"),
    CRITIC("CRITIC", Effect.CRIT, "trails.critic"),
    SMOKE("HEART", Effect.SMOKE, "trails.smoke"),
    FIREWORKS_SPARK("FIREWORKS_SPARK", Effect.FIREWORKS_SPARK, "trails.fireworks");

    private final String name;
    private final Effect effect;
    private final String permission;
}
