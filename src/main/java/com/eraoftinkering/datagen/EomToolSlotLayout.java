package com.eraoftinkering.datagen;

import com.eraoftinkering.registries.Items;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;
import slimeknights.tconstruct.tools.TinkerToolParts;

public class EomToolSlotLayout extends AbstractStationSlotLayoutProvider {
    public EomToolSlotLayout(DataGenerator generator) {
        super(generator);
    }

    /**
     * Function to add all relevant layouts
     */
    @Override
    protected void addLayouts() {
        defineModifiable(Items.SAW)
                .sortIndex(SORT_HARVEST)
                .addInputItem(TinkerToolParts.toolHandle, 46, 56)
                .addInputItem(TinkerToolParts.broadBlade, 28, 38)
                .build();

        defineModifiable(Items.HAMMER)
                .sortIndex(SORT_HARVEST)
                .addInputItem(TinkerToolParts.toolHandle, 46, 56)
                .addInputItem(TinkerToolParts.hammerHead, 28, 38)
                .build();
    }

    @Override
    public String getName() {
        return "Era of Tinkering Tool Station layout";
    }
}
