package hu.multiteam.papyrum.block;

import hu.multiteam.papyrum.Papyrum;
import hu.multiteam.papyrum.item.PapyrumItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PapyrumBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Papyrum.MODID);
    public static final RegistryObject<RotatedPillarBlock> PAPER_BLOCK = register("paper_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE)), new Item.Properties());
    public static final RegistryObject<RotatedPillarBlock> CARDBOARD_BOX = register("cardboard_box", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)), new Item.Properties());
    public static final RegistryObject<Block> CARDBOARD_BLOCK = register("cardboard_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)), new Item.Properties());

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Item.Properties itemProperties){
        RegistryObject<T> ret = registerNoItem(name, block);
        PapyrumItems.ITEMS.register(name, () -> new BlockItem(ret.get(), itemProperties));
        return ret;
    }
}
