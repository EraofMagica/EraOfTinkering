package com.eraoftinkering;

import com.eraoftinkering.datagen.EomLangProvider;
import com.eraoftinkering.datagen.EomPartSpriteProvider;
import com.eraoftinkering.datagen.EomToolDefinitionsDataProvider;
import com.eraoftinkering.datagen.EomToolSlotLayout;
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
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.client.model.tools.ToolModel;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;


@Mod("eot")
@Mod.EventBusSubscriber(bus =Mod.EventBusSubscriber.Bus.MOD)
public class EraOfTinkering {
    
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
            gen.addProvider(new EomToolSlotLayout(gen));
        }
        if (event.includeClient()) {
            EomPartSpriteProvider partSprites = new EomPartSpriteProvider();
            gen.addProvider(new EomLangProvider(gen));
            gen.addProvider(new GeneratorPartTextureJsonGenerator(gen, EraOfTinkering.MOD_ID, partSprites));

            //Tool part generator, keep this executing as the last one, it crashes at "overslime border"
            //But seems to function the same practically, this may cause future issues
            gen.addProvider(new MaterialPartTextureGenerator(gen, event.getExistingFileHelper(), partSprites, new TinkerMaterialSpriteProvider()));
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