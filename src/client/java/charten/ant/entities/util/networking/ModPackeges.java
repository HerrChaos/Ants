package charten.ant.entities.util.networking;

import charten.ant.Main;
import charten.ant.entites.custom.AntEntity;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class ModPackeges {
    public static final Identifier ANTWALK = new Identifier(Main.MOD_ID, "ant_walk");
    private static void registerC2SPackets() {
    }

    private static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ANTWALK, (client, handler, buf, responseSender) -> {
            int entityID = buf.readInt();
            client.execute(() -> {
                if (client.player == null) return;
                Entity entity = client.player.getWorld().getEntityById(entityID);
                if (entity instanceof AntEntity) {
                    System.out.println("Ant is walking registered by client");
                }
            });
        });
    }

    public static void registerAllPackets() {
        registerC2SPackets();
        registerS2CPackets();
    }

}
