package com.eraoftinkering.tinkers;

import com.eraoftinkering.registries.Items;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;

public class ToolDefinitions {

    public static final ToolDefinition SAW = ToolDefinition.builder(Items.SAW).meleeHarvest().build();
    public static final ToolDefinition HAMMER = ToolDefinition.builder(Items.HAMMER).meleeHarvest().build();
    public static final ToolDefinition FILE = ToolDefinition.builder(Items.FILE).meleeHarvest().build();
    public static final ToolDefinition SCREWDRIVER = ToolDefinition.builder(Items.SCREWDRIVER).meleeHarvest().build();
    public static final ToolDefinition WRENCH = ToolDefinition.builder(Items.WRENCH).meleeHarvest().build();
    public static final ToolDefinition KNIFE = ToolDefinition.builder(Items.KNIFE).meleeHarvest().build();
}
