package charten.ant.util;

import charten.ant.entites.ModEntities;
import charten.ant.entites.custom.AntEntity;
import charten.ant.entites.custom.MajorAntEntity;
import charten.ant.entites.custom.QueenAntEntity;
import charten.ant.entites.custom.WorkerAntEntity;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Collonie {
    private List<UUID> AntsUUID = new ArrayList<>();
    private UUID QueenUUID;
    public Collonie (UUID QueenAntUUID) {
        this.QueenUUID = QueenAntUUID;
    }
    public float getFoodAverage(ServerWorld world) {
        float food = 0;
        for (AntEntity ant: this.getAnts(world)) {
            food += ant.getFood();
        }
        return food / ((float)this.getSize(world));
    }


    public List<UUID> getAntsUUID() {
        return this.AntsUUID;
    }
    public List<AntEntity> getAnts(ServerWorld world) {
        List<AntEntity> Ants = new ArrayList<>();
        for (UUID uuid:this.getAntsUUID()) {
            if (!world.isClient()) {
                Entity ant = GeneralUtil.getEntityByUUID(world, uuid);
                if (ant instanceof AntEntity) {
                    Ants.add((AntEntity) ant);
                }
            }
        }
        return Ants;
    }
    public List<WorkerAntEntity> getWorkerAnts(ServerWorld world) {
        List<WorkerAntEntity> Ants = new ArrayList<>();
        for (UUID uuid : this.getAntsUUID()) {
            if (!world.isClient()) {
                Entity ant = GeneralUtil.getEntityByUUID(world, uuid);
                if (ant instanceof WorkerAntEntity) {
                    Ants.add((WorkerAntEntity) ant);
                }
            }
        }
        return Ants;
    }
    public List<MajorAntEntity> getMajorAnts(ServerWorld world) {
        List<MajorAntEntity> Ants = new ArrayList<>();
        for (UUID uuid:this.getAntsUUID()) {
            if (!world.isClient()) {
                Entity ant = GeneralUtil.getEntityByUUID(world, uuid);
                if (ant instanceof MajorAntEntity) {
                    Ants.add((MajorAntEntity) ant);
                }
            }
        }
        return Ants;
    }
    public List<MajorAntEntity> getRoyalGuard(ServerWorld world) {
        List<MajorAntEntity> Ants = new ArrayList<>();
        for (UUID uuid:this.getAntsUUID()) {
            if (!world.isClient()) {
                Entity ant = GeneralUtil.getEntityByUUID(world, uuid);
                if (ant instanceof MajorAntEntity && ((MajorAntEntity)ant).getActivity().equals("royal_guard")) {
                    Ants.add((MajorAntEntity) ant);
                }
            }
        }
        return Ants;
    }
    public List<WorkerAntEntity> getStorageAnt(ServerWorld world) {
        List<WorkerAntEntity> Ants = new ArrayList<>();
        for (UUID uuid:this.getAntsUUID()) {
            if (!world.isClient()) {
                Entity ant = GeneralUtil.getEntityByUUID(world, uuid);
                if (ant instanceof WorkerAntEntity && ((WorkerAntEntity)ant).getActivity().equals("storage")) {
                    Ants.add((WorkerAntEntity) ant);
                }
            }
        }
        return Ants;
    }


    public QueenAntEntity getQueen(ServerWorld world) {
        QueenAntEntity queenAnt = null;
        if (!world.isClient()) {
            Entity ant = GeneralUtil.getEntityByUUID(world, this.QueenUUID);
            if (ant instanceof QueenAntEntity) {
                queenAnt = (QueenAntEntity) ant;
            }
        }
        return queenAnt;
    }
    public NbtCompound toNbt(ServerWorld world) {
        NbtCompound nbt = new NbtCompound();
        NbtCompound NBT = new NbtCompound();
        int count = 0;
        for (UUID uuid: this.getAntsUUID()) {
            NBT.putUuid("ants" +  count, uuid);
            count++;
        }
        nbt.put("listofantids", NBT);
        if (world != null && this.QueenUUID != null) {
            nbt.putUuid("queen", this.QueenUUID);
        }

        return nbt;
    }
    public static Collonie fromNbt(NbtCompound nbt, ServerWorld world, QueenAntEntity queenAntEntity) {
        Collonie collonie = new Collonie(null);

        collonie.setQueenUUID(nbt.getCompound("collonie").getUuid("queen"));

        for (int count = 0;;count++) {
            UUID ant = null;
            if (nbt.getCompound("collonie").getCompound("listofantids").contains("ants" + count)) {
                ant = nbt.getCompound("collonie").getCompound("listofantids").getUuid("ants" + count);
            }
            if (ant == null) break;
            collonie.addAnt(ant);
        }
        return collonie;
    }
    public int getSize(ServerWorld world) {
        return this.getAnts(world).size();
    }
    public void setQueenUUID(UUID uuid) {
        this.QueenUUID = uuid;
    }
    public void addAnt(UUID ant) {
        if (ant != null) {
            this.AntsUUID.add(ant);
        }
    }
    public void removeAnt(UUID ant) {
        if (ant != null) {
            this.AntsUUID.remove(ant);
        }
    }
}
