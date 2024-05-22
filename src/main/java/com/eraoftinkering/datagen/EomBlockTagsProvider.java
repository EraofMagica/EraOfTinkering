package com.eraoftinkering.datagen;

import com.eraoftinkering.EraOfTinkering;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class EomBlockTagsProvider extends BlockTagsProvider {
    public EomBlockTagsProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, EraOfTinkering.MOD_ID, existingFileHelper);
    }
}
