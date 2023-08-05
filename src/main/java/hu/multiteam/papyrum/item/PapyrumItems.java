package hu.multiteam.papyrum.item;

import hu.multiteam.papyrum.Papyrum;
import hu.multiteam.papyrum.block.PapyrumBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PapyrumItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Papyrum.MODID);

    public static final RegistryObject<Item> CARDBOARD = ITEMS.register("cardboard", () -> new Item(new Item.Properties()));


    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Papyrum.MODID);

    public static final RegistryObject<CreativeModeTab> PAPYRUM_TAB = CREATIVE_MODE_TABS.register("papyrum_tab", () -> CreativeModeTab.builder()
            .icon(() -> PapyrumItems.CARDBOARD.get().getDefaultInstance())
            .title(Component.translatable("creativetab.papyrum_tab"))
            .displayItems((parameters, output) -> {
                output.accept(PapyrumBlocks.PAPER_BLOCK.get());
                output.accept(PapyrumItems.CARDBOARD.get());
                output.accept(PapyrumBlocks.CARDBOARD_BLOCK.get());
                output.accept(PapyrumBlocks.CARDBOARD_BOX.get());
            }).build());

    public static void register(IEventBus bus){
        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
    }
}
