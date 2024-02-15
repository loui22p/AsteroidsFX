package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
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
        enemyShip.setPolygonCoordinates(-10,-10,0,5,-10,10);
        enemyShip.setX(gameData.getDisplayHeight() / 2);
        enemyShip.setY(gameData.getDisplayWidth() / 2);
        enemyShip.setRotation(0.1 + Math.random()*359.9);   // Rotate between 0.1 and 360 degrees

        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(EnemySpaceship);
    }

}
