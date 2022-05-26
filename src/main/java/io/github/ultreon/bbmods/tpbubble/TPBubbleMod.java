package io.github.ultreon.bbmods.tpbubble;

import io.github.ultreon.bbmods.tpbubble.init.ModBubbles;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TPBubbleMod implements ModInitializer {
    public static final String MOD_ID = "teleportbubble";

    public static final Logger LOGGER = LoggerFactory.getLogger("ExampleMod");

    @Override
    public void onInitialize() {
        LOGGER.info("Hello, world!");

        ModBubbles.register();
    }
}
