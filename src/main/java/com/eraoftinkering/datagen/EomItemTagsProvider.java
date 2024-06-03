package com.eraoftinkering.datagen;

import com.eraoftinkering.EraOfTinkering;
import com.eraoftinkering.registries.Items;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.common.registration.CastItemObject;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Consumer;

public class EomItemTagsProvider extends ItemTagsProvider {


    public EomItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, blockTags, EraOfTinkering.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TinkerTags.Items.MODIFIABLE).add(
                Items.SAW.get(),
                Items.HAMMER.get(),
                Items.FILE.get(),
                Items.SCREWDRIVER.get(),
                Items.WRENCH.get(),
                Items.KNIFE.get(),
                Items.WIRECUTTER.get()
        );

        tag(TinkerTags.Items.DURABILITY).add(
                Items.SAW.get(),
                Items.HAMMER.get(),
                Items.FILE.get(),
                Items.SCREWDRIVER.get(),
                Items.WRENCH.get(),
                Items.KNIFE.get(),
                Items.WIRECUTTER.get()
        );

        tag(TinkerTags.Items.MULTIPART_TOOL).add(
                Items.SAW.get(),
                Items.HAMMER.get(),
                Items.FILE.get(),
                Items.SCREWDRIVER.get(),
                Items.WRENCH.get(),
                Items.KNIFE.get(),
                Items.WIRECUTTER.get()
        );

        tag(TinkerTags.Items.MELEE).add(
                Items.SAW.get(),
                Items.HAMMER.get(),
                Items.FILE.get(),
                Items.SCREWDRIVER.get(),
                Items.WRENCH.get(),
                Items.KNIFE.get(),
                Items.WIRECUTTER.get()
        );

        tag(TinkerTags.Items.HELD).add(
                Items.SAW.get(),
                Items.HAMMER.get(),
                Items.FILE.get(),
                Items.SCREWDRIVER.get(),
                Items.WRENCH.get(),
                Items.KNIFE.get(),
                Items.WIRECUTTER.get()
        );

        tag(TinkerTags.Items.HARVEST).add(
                Items.SAW.get(),
                Items.HAMMER.get(),
                Items.FILE.get(),
                Items.SCREWDRIVER.get(),
                Items.WRENCH.get(),
                Items.KNIFE.get(),
                Items.WIRECUTTER.get()
        );

        tag(ModTags.KNIVES).add(
                Items.KNIFE.get()
        );

        tag(ForgeTags.TOOLS_KNIVES).add(
                Items.KNIFE.get()
        );

        tag(ModTags.STRAW_HARVESTERS).add(
                Items.KNIFE.get()
        );

        tag(TinkerTags.Items.TOOL_PARTS).add(
                Items.WRENCH_HEAD.get(),
                Items.KNIFE_HEAD.get(),
                Items.WRENCH_HEAD.get()
        );

        // tag each type of cast
        TagAppender<Item> goldCasts = this.tag(TinkerTags.Items.GOLD_CASTS);
        TagAppender<Item> sandCasts = this.tag(TinkerTags.Items.SAND_CASTS);
        TagAppender<Item> redSandCasts = this.tag(TinkerTags.Items.RED_SAND_CASTS);
        TagAppender<Item> singleUseCasts = this.tag(TinkerTags.Items.SINGLE_USE_CASTS);
        TagAppender<Item> multiUseCasts = this.tag(TinkerTags.Items.MULTI_USE_CASTS);
        Consumer<CastItemObject> addCast = cast -> {
            // tag based on material
            goldCasts.add(cast.get());
            sandCasts.add(cast.getSand());
            redSandCasts.add(cast.getRedSand());
            // tag based on usage
            singleUseCasts.addTag(cast.getSingleUseTag());
            this.tag(cast.getSingleUseTag()).add(cast.getSand(), cast.getRedSand());
            multiUseCasts.addTag(cast.getMultiUseTag());
            this.tag(cast.getMultiUseTag()).add(cast.get());
        };

        // small heads
        addCast.accept(Items.WRENCH_HEAD_CAST);
        addCast.accept(Items.WIRECUTTER_HEAD_CAST);
        addCast.accept(Items.KNIFE_HEAD_CAST);

        // add all casts to a common tag
        this.tag(TinkerTags.Items.CASTS)
                .addTags(TinkerTags.Items.GOLD_CASTS, TinkerTags.Items.SAND_CASTS, TinkerTags.Items.RED_SAND_CASTS, TinkerTags.Items.TABLE_EMPTY_CASTS, TinkerTags.Items.BASIN_EMPTY_CASTS);
    }
}
