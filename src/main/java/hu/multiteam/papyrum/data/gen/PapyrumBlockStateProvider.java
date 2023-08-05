package hu.multiteam.papyrum.data.gen;

import hu.multiteam.papyrum.block.PapyrumBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class PapyrumBlockStateProvider extends BlockStateProvider {

    public PapyrumBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(PapyrumBlocks.PAPER_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockReg){
        simpleBlockWithItem(blockReg.get(), cubeAll(blockReg.get()));
    }
}
