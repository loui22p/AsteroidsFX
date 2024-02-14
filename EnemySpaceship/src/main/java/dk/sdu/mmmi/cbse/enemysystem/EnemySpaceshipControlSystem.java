package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
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
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}