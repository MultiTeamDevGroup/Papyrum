package hu.multiteam.papyrum.data;

import hu.multiteam.papyrum.Papyrum;
import hu.multiteam.papyrum.data.gen.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Papyrum.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private DataGenerators() {

    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        gen.addProvider(true, new PapyrumRecipeProvider(packOutput));
        gen.addProvider(true, PapyrumLootTableProvider.create(packOutput));
        gen.addProvider(true, new PapyrumBlockStateProvider(packOutput, Papyrum.MODID, fileHelper));
        gen.addProvider(true, new PapyrumItemModelProvider(packOutput, Papyrum.MODID, fileHelper));


    }
}
