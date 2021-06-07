package me.sakio.cosmetic.manager.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gadgets {

    DEFAULT("DEFAULT", null),
    PEARLS("PEARLS", "gadgets.pearls"),
    SNOW_PEARLS("SNOW_PEARLS", "gadgets.snowball"),
    LITGTH_STRIKE("LIGTH_STRIKE", "gadgets.ligthstrike");
    /*Add new gadgets with this format
    GADGETS("NAME", "your.perms");
     */


    private final String name;
    private final String permissions;
}
