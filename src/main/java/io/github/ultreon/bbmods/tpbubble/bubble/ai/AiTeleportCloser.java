package io.github.ultreon.bbmods.tpbubble.bubble.ai;

import com.ultreon.bubbles.entity.Entity;
import com.ultreon.bubbles.entity.ai.AiTask;
import com.ultreon.bubbles.random.JavaRandom;
import com.ultreon.bubbles.random.valuesource.RandomValueSource;
import com.ultreon.bubbles.random.valuesource.ValueSource;

public class AiTeleportCloser extends AiTask {
    private final JavaRandom random = new JavaRandom();
    private final ValueSource distance;
    private final float chance;

    public AiTeleportCloser() {
        this(RandomValueSource.random(10, 20));
    }

    public AiTeleportCloser(ValueSource distance) {
        this(distance, 0.004f);
    }

    public AiTeleportCloser(ValueSource distance, float chance) {
        super();

        this.distance = distance;
        this.chance = chance;
    }

    @Override
    public boolean executeTask(Entity entity) {
        Entity target = entity.getTarget();
        if (target == null) {
            return false;
        }
        if (target.distanceTo(entity) > 80 && random.chance(chance)) {
            float angleToTarget = entity.getAngleTo(target);

            double distance = this.distance.getValue();
            float deltaX = (float) (Math.cos(angleToTarget) * distance);
            float deltaY = (float) (Math.sin(angleToTarget) * distance);

            entity.move(deltaX, deltaY);
        }

        return false;
    }
}
