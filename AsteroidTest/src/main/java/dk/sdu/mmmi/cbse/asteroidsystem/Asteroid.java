package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class Asteroid extends Entity {
    @Override
    public void handleCollision(Entity collidingEntity) {
        System.out.println("BANG ASTEROID");
    }
}
