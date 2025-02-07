package com.eraoftinkering.registries;

import com.eraoftinkering.EraOfTinkering;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Fluids {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, EraOfTinkering.MOD_ID);

    public static final RegistryObject<FlowingFluid> MOLTEN_VINTEUM_SOURCE
            = FLUIDS.register("molten_vinteum", () -> new ForgeFlowingFluid.Source(Fluids.VINTEUM_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MOLTEN_VINTEUM_FLOWING
            = FLUIDS.register("molten_vinteum_flowing", () -> new ForgeFlowingFluid.Flowing(Fluids.VINTEUM_PROPERTIES));

    public static final ForgeFlowingFluid.Properties VINTEUM_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MOLTEN_VINTEUM_SOURCE.get(), () -> MOLTEN_VINTEUM_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.BUCKET_EMPTY_LAVA).overlay(WATER_OVERLAY_RL)
            .color(0xF9FFFFFF)).slopeFindDistance(1).levelDecreasePerBlock(1)
            .block(() -> Fluids.MOLTEN_VINTEUM_BLOCK.get()).bucket(() -> Items.MOLTEN_VINTEUM_BUCKET.get());

    public static final RegistryObject<LiquidBlock> MOLTEN_VINTEUM_BLOCK = Blocks.BLOCKS.register("molten_vinteum",
            () -> new LiquidBlock(() -> Fluids.MOLTEN_VINTEUM_SOURCE.get(), BlockBehaviour.Properties.of(Material.LAVA)
                    .noCollission().strength(100f).noDrops()));
}
