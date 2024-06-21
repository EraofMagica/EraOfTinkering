package com.eraoftinkering.datagen;

import com.eraoftinkering.EraOfTinkering;
import com.eraoftinkering.registries.Items;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class EomLangProvider extends LanguageProvider {
    public EomLangProvider(DataGenerator gen) {
        super(gen, EraOfTinkering.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //Items
        addItem(Items.SAW, "Saw");
        addItem(Items.HAMMER, "Hammer");
        addItem(Items.FILE, "File");
        addItem(Items.SCREWDRIVER, "Screwdriver");
        addItem(Items.WRENCH, "Wrench");
        addItem(Items.WRENCH_HEAD, "Wrench Head");
        addItem(Items.KNIFE, "Knife");
        addItem(Items.KNIFE_HEAD, "Knife Head");
        addItem(Items.WIRECUTTER, "Wirecutter");
        addItem(Items.WIRECUTTER_HEAD, "Wirecutter Head");
        addItem(Items.MOLTEN_VINTEUM_BUCKET, "Molten Vinteum Bucket");
        add("item.eot.wrench_head_cast", "Knife Head Gold Cast");
        add("item.eot.wrench_head_red_sand_cast", "Knife Head Red Sand Cast");
        add("item.eot.wrench_head_sand_cast", "Knife Head Sand Cast");
        add("item.eot.knife_head_cast", "Knife Head Gold Cast");
        add("item.eot.knife_head_red_sand_cast", "Knife Head Red Sand Cast");
        add("item.eot.knife_head_sand_cast", "Knife Head Sand Cast");
        add("item.eot.wirecutter_head_cast", "Wirecutter Head Cast");
        add("item.eot.wirecutter_head_sand_cast", "Wirecutter Head Sand Cast");
        add("item.eot.wirecutter_head_red_sand_cast", "Wirecutter Head Red Sand Cast");


        //Creative Tabs
        add("itemGroup.eot.tools", "Era Of Tinkering");

        //Tool station Tooltips
        add("item.eot.file.description", "The File is a tool used in woodworking to remove fine amounts of material of a workpiece");
        add("item.eot.screwdriver.description", "A Screwdriver is a tool, usually operated manually for turning screws");
        add("item.eot.wrench.description", "The Wrench is used in building machines and operating them");
        add("item.eot.hammer.description", "The Hammer is used in building and completing machines, as well as pulverising brittle and weaker materials");
        add("item.eot.knife.description", "The Knife is used in carving and chopping mostly in cooking, it can be used for carving pumpkins, slicing cake, and chopping vegetables on a cutting board");
        add("item.eot.saw.description", "The Saw is a versatile tool used for crafting with wood, mainly used for bringing wood into the right shape");
        add("item.eot.wirecutter.description", "The Wirecutter is a tool mainly used for cutting wires but also used for bending metal");

        //Part Builder
        add("pattern.eot.knife_head", "Knife Head");
        add("pattern.eot.wrench_head", "Wrench head");
        add("pattern.eot.wirecutter_head", "Wirecutter Head");
    }
}
