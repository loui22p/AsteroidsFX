package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public class EnemySpaceship extends Entity {

    private long bulletFiredTime;

    public long getBulletFiredTime() {
        return bulletFiredTime;
    }

    public void setBulletFiredTime(long bulletFiredTime) {
        this.bulletFiredTime = bulletFiredTime;
    }

    @Override
    public void handleCollision(GameData gameData, World world, Entity collidingEntity) {
        System.out.println("BANG ENEMY");
    }
}
