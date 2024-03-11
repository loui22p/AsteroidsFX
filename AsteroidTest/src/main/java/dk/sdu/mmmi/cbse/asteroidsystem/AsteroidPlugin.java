package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {

        Entity asteroid = new Asteroid();
        asteroid.setPolygonCoordinates(-9,3,-3,9,3,9,9,3,9,-3,3,-9,-3,-9,-9,-3,-9, 3);
        asteroid.setWidth(18);
        asteroid.setHeight(18);
        setStartPoint(gameData, asteroid);

        return asteroid;
    }

    private Entity setStartPoint (GameData gamedata, Entity astroid) {
        int randomizer = (int) (Math.random() * (4-1) + 1);
        Random random = new Random();
        switch(randomizer) {
            case 1:
                astroid.setX(Math.random() * gamedata.getDisplayWidth());
                astroid.setY(0);                                             //set enemy at top
                astroid.setRotation(Math.random() * (180) + 0.1); //set rotation between 0 and 180
                break;
            case 2:
                astroid.setX(Math.random() * gamedata.getDisplayWidth());
                astroid.setY(gamedata.getDisplayHeight());                   //set enemy at bottom
                astroid.setRotation(Math.random() * (-180) - 0.1);    //set rotation between 0 and -180
                break;
            case 3:
                astroid.setX(0);                                             //set enemy to the left
                astroid.setY(Math.random() * gamedata.getDisplayHeight());
                astroid.setRotation(random.nextDouble(90 + 90) - 90);  //set rotation between -90 and 90
                break;
            case 4:
                astroid.setX(gamedata.getDisplayWidth());                    //set enemy to the right
                astroid.setY(Math.random() * gamedata.getDisplayHeight());
                astroid.setRotation(random.nextDouble(90 + 90) + 90);    //set rotation between 90 and -90
                break;
        }

        return astroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }

}
