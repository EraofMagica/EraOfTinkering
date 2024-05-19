package com.eraoftinkering.registries;

import com.eraoftinkering.EraOfTinkering;
import net.minecraft.world.item.CreativeModeTab;
import slimeknights.mantle.util.SupplierCreativeTab;

public class CreativeModeTabs {

    public static final CreativeModeTab EOM_TOOLS = new SupplierCreativeTab(EraOfTinkering.MOD_ID, "tools", () -> Items.SAW.get().getRenderTool());
}
