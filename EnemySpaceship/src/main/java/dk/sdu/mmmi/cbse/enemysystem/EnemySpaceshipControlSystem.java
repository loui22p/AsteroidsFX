package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class EnemySpaceshipControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
            
        for (Entity enemySpaceship : world.getEntities(EnemySpaceship.class)) {
            double changeX = Math.cos(Math.toRadians(enemySpaceship.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemySpaceship.getRotation()));
            enemySpaceship.setX(enemySpaceship.getX() + changeX);
            enemySpaceship.setY(enemySpaceship.getY() + changeY);

            if(fireBullet(System.currentTimeMillis(), (EnemySpaceship) enemySpaceship)) {
                for(BulletSPI bullet : getBulletSPIs()) {
                    Entity bulletEntity = bullet.createBullet(enemySpaceship, gameData);
                    bulletEntity.setRotation(0.1 + Math.random()*359.9);
                    world.addEntity(bulletEntity);
                }
            }
        }
    }

    public boolean fireBullet(long currentTime, EnemySpaceship enemySpaceship) {
        long fireNewBulletTime = enemySpaceship.getBulletFiredTime() + 1000;
        if(enemySpaceship.getBulletFiredTime() == 0) {
            enemySpaceship.setBulletFiredTime(currentTime);
            return true;
        } else if (currentTime >= fireNewBulletTime) {
            enemySpaceship.setBulletFiredTime(currentTime);
            return true;
        } else {
            return false;
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
