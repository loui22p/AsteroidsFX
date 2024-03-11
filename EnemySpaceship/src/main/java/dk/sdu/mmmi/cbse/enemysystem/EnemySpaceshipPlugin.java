package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class EnemySpaceshipPlugin implements IGamePluginService {

    private Entity EnemySpaceship;

    public EnemySpaceshipPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        EnemySpaceship = createEnemySpaceship(gameData);
        world.addEntity(EnemySpaceship);
    }

    private Entity createEnemySpaceship(GameData gameData) {

        Entity enemyShip = new EnemySpaceship();
        enemyShip.setPolygonCoordinates(-10,0,-5,3,-3,6,3,6,5,3,10,0,3,-3,-3,-3);
        enemyShip.setWidth(20);
        enemyShip.setHeight(9);
        setStartPoint(gameData, enemyShip);
//        enemyShip.setRotation(0.1 + Math.random()*359.9);   // Rotate between 0.1 and 360 degrees

        return enemyShip;
    }

    private Entity setStartPoint (GameData gamedata, Entity enemySpaceship) {
        int randomizer = (int) (Math.random() * (4-1) + 1);
        Random random = new Random();
        switch(randomizer) {
            case 1:
                enemySpaceship.setX(Math.random() * gamedata.getDisplayWidth());
                enemySpaceship.setY(0);                                             //set enemy at top
                enemySpaceship.setRotation(Math.random() * (180) + 0.1); //set rotation between 0 and 180
                break;
            case 2:
                enemySpaceship.setX(Math.random() * gamedata.getDisplayWidth());
                enemySpaceship.setY(gamedata.getDisplayHeight());                   //set enemy at bottom
                enemySpaceship.setRotation(Math.random() * (-180) - 0.1);    //set rotation between 0 and -180
                break;
            case 3:
                enemySpaceship.setX(0);                                             //set enemy to the left
                enemySpaceship.setY(Math.random() * gamedata.getDisplayHeight());
                enemySpaceship.setRotation(random.nextDouble(90 + 90) - 90);  //set rotation between -90 and 90
                break;
            case 4:
                enemySpaceship.setX(gamedata.getDisplayWidth());                    //set enemy to the right
                enemySpaceship.setY(Math.random() * gamedata.getDisplayHeight());
                enemySpaceship.setRotation(random.nextDouble(90 + 90) + 90);    //set rotation between 90 and -90
                break;
        }

        return enemySpaceship;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(EnemySpaceship);
    }

}
