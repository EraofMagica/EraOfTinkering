package com.eraoftinkering.datagen;

import com.eraoftinkering.EraOfTinkering;
import com.eraoftinkering.registries.Items;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.TinkerTags;

public class EomItemTagsProvider extends ItemTagsProvider {


    public EomItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, blockTags, EraOfTinkering.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TinkerTags.Items.MODIFIABLE).add(Items.SAW.get(), Items.HAMMER.get(), Items.FILE.get());
        tag(TinkerTags.Items.DURABILITY).add(Items.SAW.get(), Items.HAMMER.get(), Items.FILE.get());
        tag(TinkerTags.Items.MULTIPART_TOOL).add(Items.SAW.get(), Items.HAMMER.get(), Items.FILE.get());
        tag(TinkerTags.Items.MELEE).add(Items.SAW.get(), Items.HAMMER.get(), Items.FILE.get());
        tag(TinkerTags.Items.HELD).add(Items.SAW.get(), Items.HAMMER.get(), Items.FILE.get());
        tag(TinkerTags.Items.HARVEST).add(Items.SAW.get(), Items.HAMMER.get(), Items.FILE.get());
    }
}
