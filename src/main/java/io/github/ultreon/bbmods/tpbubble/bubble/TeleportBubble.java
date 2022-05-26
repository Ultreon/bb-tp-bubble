package io.github.ultreon.bbmods.tpbubble.bubble;

import com.badlogic.gdx.math.Rectangle;
import io.github.ultreon.bbmods.tpbubble.bubble.ai.AiTeleportCloser;
import com.ultreon.bubbles.bubble.BubbleType;
import com.ultreon.bubbles.entity.Bubble;
import com.ultreon.bubbles.entity.Entity;
import com.ultreon.bubbles.entity.ai.AiAttack;
import com.ultreon.bubbles.entity.ai.AiTarget;
import com.ultreon.bubbles.entity.player.Player;
import com.ultreon.bubbles.init.Entities;
import com.ultreon.bubbles.random.JavaRandom;
import com.ultreon.bubbles.random.valuesource.ConstantValueSource;
import com.ultreon.bubbles.random.valuesource.RandomValueSource;
import com.ultreon.bubbles.render.Color;
import com.ultreon.bubbles.world.World;

public class TeleportBubble extends BubbleType {
    private final JavaRandom random = new JavaRandom();

    public TeleportBubble() {
        this.setColors(Color.rgb(0xFF3243), Color.rgb(0x55FF32), Color.rgb(0x3277FF));

        this.setAttack(ConstantValueSource.of(0.1f));
        this.setHardness(ConstantValueSource.of(0.5f));
        this.setRadius(RandomValueSource.random(15, 45));
        this.setSpeed(RandomValueSource.random(8.5, 14.5));
        this.setScore(ConstantValueSource.of(5.0f));

        this.setPriority(5_000_000);

        this.addAiTask(0, new AiAttack());
        this.addAiTask(1, new AiTarget(Entities.PLAYER));
        this.addAiTask(2, new AiTeleportCloser());
    }

    @Override
    public void onCollision(Bubble source, Entity target) {
        super.onCollision(source, target);

        World world = source.getWorld();
        Rectangle gameBounds = world.getGamemode().getGameBounds();

        if (target instanceof Player player && random.chance(4)) {
            int x = random.nextInt((int) gameBounds.x, (int) (gameBounds.x + gameBounds.width));
            int y = random.nextInt((int) gameBounds.y, (int) (gameBounds.y + gameBounds.height));
            player.teleport(x, y);
        }
    }
}
