package charten.ant.util;

import charten.ant.entites.custom.QueenAntEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GeneralUtil {
    public static Entity getEntityByUUID(ServerWorld world, UUID uuid) {
        return world.getEntity(uuid);


    }

    public static Collonie fromNbt(NbtCompound nbt, ServerWorld world, QueenAntEntity queenAntEntity) {
        Collonie collonie = new Collonie(null);
        System.out.println("got queen: " + nbt.getCompound("collonie").getUuid("queen"));
        System.out.println("got queen: " + nbt.getCompound("collonie").getCompound("listofantids").getUuid("ants0"));

        collonie.setQueenUUID(nbt.getCompound("collonie").getUuid("queen"));

        for (int count = 0;count >= nbt.getCompound("collonie").getCompound("listofantids").getSize(); count++) {
            UUID ant = nbt.getCompound("collonie").getCompound("listofantids").getUuid("ants" + count);
            if (ant == null) break;
            collonie.addAnt(ant);
        }
        return collonie;
    }
}
