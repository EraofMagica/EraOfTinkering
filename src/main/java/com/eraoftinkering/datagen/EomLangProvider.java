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
        add("item.eot.wrench_head_cast", "Knife Head Gold Cast");
        add("item.eot.wrench_head_red_sand_cast", "Knife Head Red Sand Cast");
        add("item.eot.wrench_head_sand_cast", "Knife Head Sand Cast");
        add("item.eot.knife_head_cast", "Knife Head Gold Cast");
        add("item.eot.knife_head_red_sand_cast", "Knife Head Red Sand Cast");
        add("item.eot.knife_head_sand_cast", "Knife Head Sand Cast");


        //Creative Tabs
        add("itemGroup.eot.tools", "Era Of Tinkering");

        //Tool station Tooltips

        add("item.eot.saw.description", "The Saw is a versatile tool used for crafting with wood, mainly used for bringing wood into the right shape");
    }
}
