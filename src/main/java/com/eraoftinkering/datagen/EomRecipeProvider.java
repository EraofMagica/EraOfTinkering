package com.eraoftinkering.datagen;

import com.eraoftinkering.registries.Items;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;

import java.util.function.Consumer;

public class EomRecipeProvider extends RecipeProvider implements IToolRecipeHelper {
    public EomRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        String toolFolder = "tools/building/";
        String partFolder = "tools/parts/";
        String castFolder = "smeltery/casts/";

        toolBuilding(consumer, Items.SAW, toolFolder);
        toolBuilding(consumer, Items.HAMMER, toolFolder);
        toolBuilding(consumer, Items.FILE, toolFolder);
        toolBuilding(consumer, Items.SCREWDRIVER, toolFolder);
        toolBuilding(consumer, Items.WRENCH, toolFolder);

        partRecipes(consumer, Items.WRENCH_HEAD, Items.WRENCH_HEAD_CAST, 3, partFolder, castFolder);
    }

    @Override
    public String getModId() {
        return "eot";
    }
}
