package com.eraoftinkering.tinkers;

import com.eraoftinkering.registries.Items;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;

import javax.tools.Tool;

public class ToolDefinitions {

    public static final ToolDefinition SAW = ToolDefinition.builder(Items.SAW).meleeHarvest().build();
}
