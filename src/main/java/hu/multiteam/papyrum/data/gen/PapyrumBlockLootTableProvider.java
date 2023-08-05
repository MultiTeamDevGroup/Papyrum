package hu.multiteam.papyrum.data.gen;

import hu.multiteam.papyrum.block.PapyrumBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class PapyrumBlockLootTableProvider extends BlockLootSubProvider {
    public PapyrumBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(PapyrumBlocks.PAPER_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return PapyrumBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
