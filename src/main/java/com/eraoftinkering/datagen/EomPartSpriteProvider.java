package com.eraoftinkering.datagen;

import com.eraoftinkering.EraOfTinkering;
import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;

public class EomPartSpriteProvider extends AbstractPartSpriteProvider {

    public EomPartSpriteProvider() {
        super(EraOfTinkering.MOD_ID);
    }

    /**
     * Gets the name of these part sprites
     */
    @Override
    public String getName() {
        return "Era Of Magica Part Sprite Provider";
    }

    /**
     * Function to add both sprites and materials
     */
    @Override
    protected void addAllSpites() {
        addHead("wrench_head");
        addHead("knife_head");
        addHead("wirecutter_head");

        buildTool("saw").addBreakableHead("blade").addHandle("handle");
        buildTool("hammer").addBreakableHead("head").addHandle("handle");
        buildTool("file").addBreakableHead("head").addHandle("handle");
        buildTool("screwdriver").addBreakableHead("head").addHandle("handle");
        buildTool("wrench").addBreakableHead("head").addHandle("handle");
        buildTool("knife").addBreakableHead("head").addHandle("handle");
        buildTool("wirecutter").addBreakableHead("head").addHandle("handle_left").addHandle("handle_right");
    }
}
