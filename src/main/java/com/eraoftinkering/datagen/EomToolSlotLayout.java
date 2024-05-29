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
                .addInputItem(TinkerToolParts.broadBlade, 39, 35)
                .addInputItem(TinkerToolParts.toolHandle, 21, 53)
                .build();

        defineModifiable(Items.HAMMER)
                .sortIndex(SORT_HARVEST)
                .addInputItem(TinkerToolParts.hammerHead, 39, 35)
                .addInputItem(TinkerToolParts.toolHandle, 21, 53)
                .build();

        defineModifiable(Items.FILE)
                .sortIndex(SORT_HARVEST)
                .addInputItem(TinkerToolParts.smallBlade, 39, 35)
                .addInputItem(TinkerToolParts.toughHandle, 21, 53)
                .build();

        defineModifiable(Items.SCREWDRIVER)
                .sortIndex(SORT_HARVEST)
                .addInputItem(TinkerToolParts.broadBlade, 39, 35)
                .addInputItem(TinkerToolParts.toughHandle, 21, 53)
                .build();

        defineModifiable(Items.WRENCH)
                .sortIndex(SORT_HARVEST)
                .addInputItem(Items.WRENCH_HEAD, 39, 35)
                .addInputItem(TinkerToolParts.toughHandle, 21, 53)
                .build();

        defineModifiable(Items.KNIFE)
                .sortIndex(SORT_HARVEST)
                .addInputItem(Items.KNIFE_HEAD, 39, 35)
                .addInputItem(TinkerToolParts.toolHandle, 21, 53)
                .build();
    }

    @Override
    public String getName() {
        return "Era of Tinkering Tool Station layout";
    }
}
