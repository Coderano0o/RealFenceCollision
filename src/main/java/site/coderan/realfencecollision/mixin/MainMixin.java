package site.coderan.realfencecollision.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CrossCollisionBlock.class)
public class MainMixin {
    @ModifyReturnValue(method = "makeShapes", at = @At("RETURN"))
    public VoxelShape[] makeShapes(VoxelShape[] original) {
        VoxelShape voxelshape = Block.box(6, 0, 6, 10, 16, 10);

        VoxelShape voxelshape1_1 = Block.box(7, 12, 0, 9, 15, 9);
        VoxelShape voxelshape1_2 = Block.box(7, 6, 0, 9, 9, 9);
        VoxelShape voxelshape1 = Shapes.or(voxelshape1_1, voxelshape1_2);

        VoxelShape voxelshape2_1 = Block.box(7, 12, 7, 9, 15, 16);
        VoxelShape voxelshape2_2 = Block.box(7, 6, 7, 9, 9, 16);
        VoxelShape voxelshape2 = Shapes.or(voxelshape2_1, voxelshape2_2);

        VoxelShape voxelshape3_1 = Block.box(0, 12, 7, 9, 15, 9);
        VoxelShape voxelshape3_2 = Block.box(0, 6, 7, 9, 9, 9);
        VoxelShape voxelshape3 = Shapes.or(voxelshape3_1, voxelshape3_2);

        VoxelShape voxelshape4_1 = Block.box(7, 12, 7, 16, 15, 9);
        VoxelShape voxelshape4_2 = Block.box(7, 6, 7, 16, 9, 9);
        VoxelShape voxelshape4 = Shapes.or(voxelshape4_1, voxelshape4_2);

        VoxelShape voxelshape5 = Shapes.or(voxelshape1, voxelshape4);
        VoxelShape voxelshape6 = Shapes.or(voxelshape2, voxelshape3);
        VoxelShape[] avoxelshape = new VoxelShape[]{Shapes.empty(), voxelshape2, voxelshape3, voxelshape6, voxelshape1, Shapes.or(voxelshape2, voxelshape1), Shapes.or(voxelshape3, voxelshape1), Shapes.or(voxelshape6, voxelshape1), voxelshape4, Shapes.or(voxelshape2, voxelshape4), Shapes.or(voxelshape3, voxelshape4), Shapes.or(voxelshape6, voxelshape4), voxelshape5, Shapes.or(voxelshape2, voxelshape5), Shapes.or(voxelshape3, voxelshape5), Shapes.or(voxelshape6, voxelshape5)};

        for(int i = 0; i < 16; ++i) {
            avoxelshape[i] = Shapes.or(voxelshape, avoxelshape[i]);
        }

        return avoxelshape;
    }
}
