package com.eraoftinkering.registries;

import com.eraoftinkering.EraOfTinkering;
import com.eraoftinkering.items.ModifiedKnifeItem;
import com.eraoftinkering.tinkers.ToolDefinitions;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EraOfTinkering.MOD_ID);
    public static final ItemDeferredRegisterExtension TCONSTRUCT = new ItemDeferredRegisterExtension(EraOfTinkering.MOD_ID);

    private static final Item.Properties TOOL = new Item.Properties().stacksTo(1).tab(CreativeModeTabs.EOM_TOOLS);
    private static final Item.Properties PART_PROPS = new Item.Properties().tab(CreativeModeTabs.EOM_TOOLS);
    private static final Item.Properties SMELTERY_PROPS = new Item.Properties().tab(TinkerSmeltery.TAB_SMELTERY);

    //Tools
    public static final RegistryObject<ModifiableItem> SAW = ITEMS.register("saw", () -> new ModifiableItem(TOOL, ToolDefinitions.SAW));
    public static final RegistryObject<ModifiableItem> HAMMER = ITEMS.register("hammer", ()-> new ModifiableItem(TOOL, ToolDefinitions.HAMMER));
    public static final RegistryObject<ModifiableItem> FILE = ITEMS.register("file", () -> new ModifiableItem(TOOL, ToolDefinitions.FILE));
    public static final RegistryObject<ModifiableItem> SCREWDRIVER = ITEMS.register("screwdriver", () -> new ModifiableItem(TOOL, ToolDefinitions.SCREWDRIVER));
    public static final RegistryObject<ModifiableItem> WRENCH = ITEMS.register("wrench", () -> new ModifiableItem(TOOL, ToolDefinitions.WRENCH));
    public static final RegistryObject<ModifiedKnifeItem> KNIFE = ITEMS.register("knife", () -> new ModifiedKnifeItem(TOOL, ToolDefinitions.KNIFE));
    public static final RegistryObject<ModifiableItem> WIRECUTTER = ITEMS.register("wirecutter", () -> new ModifiableItem(TOOL, ToolDefinitions.WIRECUTTER));

    //Parts
    public static final ItemObject<ToolPartItem> KNIFE_HEAD = TCONSTRUCT.register("knife_head", () -> new ToolPartItem(PART_PROPS, HeadMaterialStats.ID));
    public static final ItemObject<ToolPartItem> WRENCH_HEAD = TCONSTRUCT.register("wrench_head", () -> new ToolPartItem(PART_PROPS, HeadMaterialStats.ID));
    public static final ItemObject<ToolPartItem> WIRECUTTER_HEAD = TCONSTRUCT.register("wirecutter_head", () -> new ToolPartItem(PART_PROPS, HeadMaterialStats.ID));

    //Casts
    public static final CastItemObject KNIFE_HEAD_CAST = TCONSTRUCT.registerCast("knife_head", SMELTERY_PROPS);
    public static final CastItemObject WRENCH_HEAD_CAST = TCONSTRUCT.registerCast("wrench_head", SMELTERY_PROPS);
    public static final CastItemObject WIRECUTTER_HEAD_CAST = TCONSTRUCT.registerCast("wirecutter_head", SMELTERY_PROPS);

    //Buckets
    public static final RegistryObject<Item> MOLTEN_VINTEUM_BUCKET = ITEMS.register("molten_vinteum_bucket", () -> new BucketItem(Fluids.MOLTEN_VINTEUM_FLOWING, new Item.Properties().tab(CreativeModeTabs.EOM_SMELTERY).stacksTo(1)));
}
