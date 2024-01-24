package charten.ant;

import charten.ant.entities.renderer.ModEntityRenderers;
import net.fabricmc.api.ClientModInitializer;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRenderers.registerModEntityRenderers();
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}