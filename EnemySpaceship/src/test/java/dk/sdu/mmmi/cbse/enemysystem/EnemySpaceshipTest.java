package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

class EnemySpaceshipTest {

    private Bullet bulletMock;
    private EnemySpaceship enemySpaceship;

    private GameData gameDataMock;
    private World worldMock;

    @BeforeEach
    void setUp() {
        bulletMock = mock(Bullet.class);
        enemySpaceship = new EnemySpaceship();
        gameDataMock = mock(GameData.class);
        worldMock = mock(World.class);
    }

    @Test
    void handleFirstBulletCollisionTest() {
        enemySpaceship.handleCollision(gameDataMock, worldMock, bulletMock);
        assertTrue(enemySpaceship.getTimesHit() == 1);
    }
}