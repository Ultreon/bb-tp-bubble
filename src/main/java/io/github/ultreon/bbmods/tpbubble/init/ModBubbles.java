package io.github.ultreon.bbmods.tpbubble.init;

import io.github.ultreon.bbmods.tpbubble.TPBubbleMod;
import io.github.ultreon.bbmods.tpbubble.bubble.TeleportBubble;
import com.ultreon.bubbles.bubble.BubbleType;
import com.ultreon.bubbles.registry.Registries;
import com.ultreon.libs.registries.v0.DelayedRegister;
import com.ultreon.libs.registries.v0.RegistrySupplier;

public class ModBubbles {
    private static final DelayedRegister<BubbleType> REGISTER = DelayedRegister.create(TPBubbleMod.MOD_ID, Registries.BUBBLES);

    public static final RegistrySupplier<TeleportBubble> TELEPORT = REGISTER.register("teleport", TeleportBubble::new);

    public static void register() {
        REGISTER.register();
    }
}
