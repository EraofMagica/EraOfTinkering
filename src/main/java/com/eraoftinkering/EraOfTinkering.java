package com.eraoftinkering;

import com.eraoftinkering.datagen.*;
import com.eraoftinkering.registries.Blocks;
import com.eraoftinkering.registries.Fluids;
import com.eraoftinkering.registries.Items;
import com.mojang.logging.LogUtils;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.Logger;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.model.tools.ToolModel;


@Mod("eot")
@Mod.EventBusSubscriber(bus =Mod.EventBusSubscriber.Bus.MOD)
public class EraOfTinkering {
    
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final String MOD_ID = "eot";

    public EraOfTinkering() {

        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        Items.ITEMS.register(MOD_BUS);
        Items.TCONSTRUCT.register(MOD_BUS);
        Blocks.BLOCKS.register(MOD_BUS);
        Fluids.FLUIDS.register(MOD_BUS);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(Fluids.MOLTEN_VINTEUM_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(Fluids.MOLTEN_VINTEUM_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(Fluids.MOLTEN_VINTEUM_FLOWING.get(), RenderType.translucent());
        });
    }

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            EomBlockTagsProvider tags = new EomBlockTagsProvider(gen, fileHelper);
            gen.addProvider(new EomToolDefinitionsDataProvider(gen));
            gen.addProvider(new EomToolSlotLayout(gen));
            gen.addProvider(new EomRecipeProvider(gen));
            gen.addProvider(new EomItemTagsProvider(gen, tags, fileHelper));
            gen.addProvider(new EomFluidTagsProvider(gen, fileHelper));
        }
        if (event.includeClient()) {
            EomPartSpriteProvider partSprites = new EomPartSpriteProvider();
            gen.addProvider(new EomLangProvider(gen));
            gen.addProvider(new GeneratorPartTextureJsonGenerator(gen, EraOfTinkering.MOD_ID, partSprites));

            //Note that this generated textures in the four digits, keep this commented unless neccesary or it will cause issues with git
            //gen.addProvider(new MaterialPartTextureGenerator(gen, fileHelper, partSprites, new TinkerMaterialSpriteProvider()));
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