package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.asteroidsystem.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class CollisionSystem implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities()) {
            for (Entity collideEntity : world.getEntities()) {
                if(entity == collideEntity) {
                    continue;
                }
                if(entity.getClass() == Asteroid.class && collideEntity.getClass() == Asteroid.class) {
                    continue;
                }

                // check if collision-boxes overlap
                double startEntity = entity.getX() + entity.getWidth() / 2;
                double startCollideEntity = collideEntity.getX() + collideEntity.getWidth() / 2;
                double endEntity = entity.getY() + entity.getHeight() / 2;
                double endCollideEntity = collideEntity.getY() + collideEntity.getHeight() / 2;

                // Calculate the distance between the centers of the entities' square hit-boxes
                double distanceX = Math.abs((startEntity) - (startCollideEntity));
                double distanceY = Math.abs((endEntity) - (endCollideEntity));

                // Calculate the minimum distance between the centers at which a collision can occur
                double minDistanceX = entity.getWidth() / 2 + collideEntity.getWidth() / 2;
                double minDistanceY = entity.getHeight() / 2 + collideEntity.getHeight() / 2;

                if (distanceX < minDistanceX && distanceY < minDistanceY) {
                    //handle the collision for different entities
                    if(entity.getClass() == Asteroid.class) {
                        entity.handleCollision(gameData, world, collideEntity);
                    }
                }
            }
        }
    }
}
