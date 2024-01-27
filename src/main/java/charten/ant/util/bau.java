package charten.ant.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class bau {
    private List<BlockPos> FoodChambers;
    private List<BlockPos> NestChambers;
    private BlockPos HomeChamber;
    private World world;
    private Random random = new Random();
    public bau(BlockPos StartChamber, World worldy) {
        this.HomeChamber = StartChamber;
        this.world = worldy;
        /*
        this.FoodChambers.add(getRandomValidBlockPosAroundPos(StartChamber, 10, this.world));
        this.NestChambers.add(getRandomValidBlockPosAroundPos(StartChamber, 10, this.world));
         */
    }
    private BlockPos getRandomValidBlockPosAroundPos(BlockPos startPos, int radius, World world) {
        BlockPos selected = startPos.add(random.nextInt(radius), random.nextInt(radius), random.nextInt(radius));
        if (isInRange(startPos, selected, radius) &&
                !world.getBlockState(selected).isAir() &&
                world.getBlockState(selected).getHardness(world, selected) < Blocks.STONE.getHardness()) {
            return selected;
        }
        return null;
    }
    private boolean isInRange(BlockPos center, BlockPos selected, int radius) {
        int dx = selected.getX() - center.getX();
        int dy = selected.getY() - center.getY();
        int dz = selected.getZ() - center.getZ();
        return dx * dx + dy * dy + dz * dz <= radius * radius;
    }

    public List<BlockPos> getFoodChambers() {
        return this.FoodChambers;
    }
    public List<BlockPos> getNestChambers() {
        return this.NestChambers;
    }
    public World getWorld() {
        return this.world;
    }
    public void generateFoodChamber(BlockPos startingPos, int radius) {
        this.getFoodChambers().add(getRandomValidBlockPosAroundPos(startingPos, radius, this.getWorld()));
    }
    public void generateNestChamber(BlockPos startingPos, int radius) {
        this.getNestChambers().add(getRandomValidBlockPosAroundPos(startingPos, radius, this.getWorld()));
    }
}
