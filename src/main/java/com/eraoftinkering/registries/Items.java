package com.eraoftinkering.registries;

import com.eraoftinkering.EraOfTinkering;
import com.eraoftinkering.tinkers.ToolDefinitions;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EraOfTinkering.MOD_ID);

    private static final Item.Properties TOOL = new Item.Properties().stacksTo(1).tab(CreativeModeTabs.EOM_TOOLS);

    public static final RegistryObject<ModifiableItem> SAW = ITEMS.register("saw", () -> new ModifiableItem(TOOL, ToolDefinitions.SAW));

}
