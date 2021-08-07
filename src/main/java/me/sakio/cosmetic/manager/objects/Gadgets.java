package me.sakio.cosmetic.manager.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gadgets {

    DEFAULT("DEFAULT", null),
    PEARLS("PEARLS", "gadgets.pearls"),
    SNOW_PEARLS("SNOW_PEARLS", "gadgets.snowball"),
    LIGHT_STRIKE("LIGHT_STRIKE", "gadgets.light_strike");
    /*Add new gadgets with this format
    GADGETS("NAME", "your.perms");
     */


    private final String name;
    private final String permissions;
}
