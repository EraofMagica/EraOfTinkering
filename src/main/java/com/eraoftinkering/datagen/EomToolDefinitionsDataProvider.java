package com.eraoftinkering.datagen;

import com.eraoftinkering.EraOfTinkering;
import com.eraoftinkering.tinkers.ToolDefinitions;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerToolParts;

import javax.annotation.Nonnull;

public class EomToolDefinitionsDataProvider extends AbstractToolDefinitionDataProvider {

    public EomToolDefinitionsDataProvider(DataGenerator generator) {
        super(generator, EraOfTinkering.MOD_ID);
    }

    /**
     * Function to add all relevant tool definitions
     */
    @Override
    protected void addToolDefinitions() {

        define(ToolDefinitions.SAW)
                .part(TinkerToolParts.broadBlade)
                .part(TinkerToolParts.toolHandle)
                .stat(ToolStats.ATTACK_DAMAGE, 1f)
                .stat(ToolStats.ATTACK_SPEED, 0.8f)
                .startingSlots(SlotType.UPGRADE, 2);

        define(ToolDefinitions.HAMMER)
                .part(TinkerToolParts.hammerHead)
                .part(TinkerToolParts.toolHandle)
                .stat(ToolStats.ATTACK_DAMAGE, 1f)
                .stat(ToolStats.ATTACK_SPEED, 0.8f)
                .startingSlots(SlotType.UPGRADE, 2);

    }

    /**
     * Gets a name for this provider, to use in logging.
     */
    @Nonnull
    @Override
    public String getName() {
        return "Era Of Magic Tool Definition Provider";
    }
}
