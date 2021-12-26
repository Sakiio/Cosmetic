package me.sakio.cosmetic.manager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;


/**
 * Project: Cosmetic
 * Date: 26/07/2021 @ 19:28
 * Class: Pets
 */
@AllArgsConstructor
@Getter
public enum Pets {

    DEFAULT("None",null, Material.REDSTONE_BLOCK),
    CREEPER("Creeper", EntityType.CREEPER, Material.TNT),
    SKELETON("Skeleton", EntityType.SKELETON, Material.ARROW),
    ZOMBIE("Zombie", EntityType.ZOMBIE, Material.ROTTEN_FLESH);

    private final String name;
    private final EntityType type;
    private final Material material;
}
