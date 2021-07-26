package me.sakio.cosmetic.manager.objects;

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

    NONE("None",null, Material.REDSTONE_BLOCK),
    CREEPER("Creeper", EntityType.CREEPER, Material.TNT),
    SKELETON("Skeleton", EntityType.SKELETON, Material.ARROW),
    ZOMBIE("Zombie", EntityType.ZOMBIE, Material.ROTTEN_FLESH),
    MAGMA_CUBE("Magma Cube", EntityType.MAGMA_CUBE, Material.MAGMA_CREAM),
    WITCH("Witch", EntityType.WITCH, Material.POTION),
    PIG("Pig", EntityType.PIG, Material.PORK),
    SHEEP("Sheep", EntityType.SHEEP, Material.WOOL),
    COW("Cow", EntityType.COW, Material.LEATHER),
    CHICKEN("Chicken", EntityType.CHICKEN, Material.FEATHER),
    MUSHROOM_COW("Mushroom Cow", EntityType.MUSHROOM_COW, Material.MUSHROOM_SOUP),
    SLIME("Slime", EntityType.SLIME, Material.SLIME_BALL),
    SNOWMAN("Snowman", EntityType.SNOWMAN, Material.SNOW_BALL),
    OCELOT("Ocelot", EntityType.OCELOT, Material.RAW_FISH),
    IRON_GOLEM("Iron Golem", EntityType.IRON_GOLEM, Material.IRON_BLOCK),
    HORSE("Horse", EntityType.HORSE, Material.SADDLE),
    VILLAGER("Villager", EntityType.VILLAGER, Material.EMERALD),
    WOLF("Wolf", EntityType.WOLF, Material.BONE);

    private final String name;
    private final EntityType type;
    private final Material material;

}
