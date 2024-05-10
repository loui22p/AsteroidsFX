package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.asteroidsystem.Asteroid;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.playersystem.Player;
import dk.sdu.mmmi.cbse.enemysystem.EnemySpaceship;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CollisionSystem implements IPostEntityProcessingService {

    private Boolean skipCollision = false;
    public String newScore;
    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity : world.getEntities()) {
            for (Entity collideEntity : world.getEntities()) {
                skipCollision = false;

                if(entity == collideEntity) {
                    continue;
                }
                if(entity.getClass() == Asteroid.class && collideEntity.getClass() == Asteroid.class) {
                    continue;
                }

                //If either entity or collide entity are Players, it checks whether the colliding bullet is made by that player.
                if(entity.getClass() == Player.class && collideEntity.getClass() == Bullet.class) {
                    for(Entity bullet : ((Player)entity).getBullets()) {
                        if (bullet == collideEntity) {
                            skipCollision = true;
                        }
                    }
                }
                //If either entity or collide entity are EnemySpaceships, it checks whether the colliding bullet is made by that enemy spaceship.
                if(entity.getClass() == EnemySpaceship.class && collideEntity.getClass() == Bullet.class) {
                    for(Entity bullet : ((EnemySpaceship)entity).getBullets()) {
                        if (bullet == collideEntity) {
                            skipCollision = true;
                        }
                    }
                }

                if(skipCollision == true) {
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
                    if(entity.getClass() == Asteroid.class || entity.getClass() == Player.class || entity.getClass() == EnemySpaceship.class) {
                        //Increment player score-points if it hits anything with one of its bullets
                        entity.handleCollision(gameData, world, collideEntity);
                    }
                }
            }
        }
    }
}
