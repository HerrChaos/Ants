package charten.ant;

import charten.ant.entities.renderer.ModEntityRenderers;
import charten.ant.entities.util.networking.ModPackeges;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.TitleScreen;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRenderers.registerModEntityRenderers();
		ModPackeges.registerAllPackets();
	}
}