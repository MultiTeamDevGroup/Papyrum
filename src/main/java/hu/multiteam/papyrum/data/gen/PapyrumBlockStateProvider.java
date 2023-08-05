package hu.multiteam.papyrum.data.gen;

import hu.multiteam.papyrum.block.PapyrumBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PapyrumBlockStateProvider extends BlockStateProvider {

    public PapyrumBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        axisBlockWithItem(PapyrumBlocks.PAPER_BLOCK);
        axisBlockWithItem(PapyrumBlocks.CARDBOARD_BOX);
        blockWithItem(PapyrumBlocks.CARDBOARD_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockReg){
        simpleBlockWithItem(blockReg.get(), cubeAll(blockReg.get()));
    }

    private void axisBlockWithItem(RegistryObject<RotatedPillarBlock> blockReg){
        ResourceLocation name = key(blockReg.get());
        ResourceLocation side = new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath() + "_side");
        ResourceLocation top = new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath() + "_top");
        simpleBlockItem(blockReg.get(), models().cubeColumn(name(blockReg.get()), side, top));
        axisBlock(blockReg.get(), side, top);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    private String name(Block block) {
        return key(block).getPath();
    }
}
