package hu.multiteam.papyrum.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CardboardWindowBlock extends Block {

    public CardboardWindowBlock(Properties pProperties) {
        super(pProperties);
    }

    @OnlyIn(Dist.CLIENT)
    public boolean skipRendering(BlockState state, BlockState state2, Direction direction) {
        return state2.is(this) || super.skipRendering(state, state2, direction);
    }
}
