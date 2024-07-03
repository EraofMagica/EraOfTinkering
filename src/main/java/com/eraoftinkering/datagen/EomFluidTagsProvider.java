package com.eraoftinkering.datagen;

import com.eraoftinkering.EraOfTinkering;
import com.eraoftinkering.registries.Fluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class EomFluidTagsProvider extends FluidTagsProvider {
    public EomFluidTagsProvider(DataGenerator p_126523_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126523_, EraOfTinkering.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(FluidTags.LAVA).add(Fluids.MOLTEN_VINTEUM_SOURCE.get(), Fluids.MOLTEN_VINTEUM_FLOWING.get());
    }
}
