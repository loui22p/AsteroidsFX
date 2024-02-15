package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.security.Timestamp;

/**
 *
 * @author Emil
 */
public class Player extends Entity {

    private long bulletFiredTime;

    public long getBulletFiredTime() {
        return bulletFiredTime;
    }

    public void setBulletFiredTime(long bulletFiredTime) {
        this.bulletFiredTime = bulletFiredTime;
    }
}
