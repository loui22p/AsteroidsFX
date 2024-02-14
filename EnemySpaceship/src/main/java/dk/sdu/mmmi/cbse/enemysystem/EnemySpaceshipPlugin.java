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

        Entity playerShip = new EnemySpaceship();
        playerShip.setPolygonCoordinates(-7,-7,7,7,-7,7);
        playerShip.setX(gameData.getDisplayHeight()/Math.random());
        playerShip.setY(gameData.getDisplayWidth()/Math.random());
        return playerShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(EnemySpaceship);
    }

}
