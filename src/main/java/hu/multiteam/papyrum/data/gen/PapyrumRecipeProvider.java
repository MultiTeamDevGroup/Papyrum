package hu.multiteam.papyrum.data.gen;

import hu.multiteam.papyrum.block.PapyrumBlocks;
import hu.multiteam.papyrum.item.PapyrumItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class PapyrumRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public PapyrumRecipeProvider(PackOutput output){
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, Items.PAPER, RecipeCategory.MISC, PapyrumBlocks.PAPER_BLOCK.get().asItem());
    }


}
