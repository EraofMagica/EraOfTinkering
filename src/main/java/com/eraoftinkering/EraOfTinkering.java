package com.eraoftinkering;

import com.eraoftinkering.datagen.EomLangProvider;
import com.eraoftinkering.datagen.EomToolDefinitionsDataProvider;
import com.eraoftinkering.registries.Items;
import com.mojang.logging.LogUtils;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.Logger;
import slimeknights.tconstruct.library.client.model.tools.ToolModel;
import slimeknights.tconstruct.tools.data.material.MaterialRenderInfoProvider;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;


@Mod("eot")
@Mod.EventBusSubscriber(bus =Mod.EventBusSubscriber.Bus.MOD)
public class EraOfTinkering {
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final String MOD_ID = "eot";

    public EraOfTinkering() {

        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        Items.ITEMS.register(MOD_BUS);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer()) {
            gen.addProvider(new EomToolDefinitionsDataProvider(gen));
        }
        if (event.includeClient()) {
            TinkerMaterialSpriteProvider materialSpriteProvider = new TinkerMaterialSpriteProvider();
            gen.addProvider(new MaterialRenderInfoProvider(gen, materialSpriteProvider));
            gen.addProvider(new EomLangProvider(gen));
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID, value = Dist.CLIENT)
    public static class EraOfTinkeringClient {

        @SubscribeEvent
        public static void itemColors(ColorHandlerEvent.Item event) {
            final ItemColors colors = event.getItemColors();
            ToolModel.registerItemColors(colors, Items.SAW);
        }
    }
}