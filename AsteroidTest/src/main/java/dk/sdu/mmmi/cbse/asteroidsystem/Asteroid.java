package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Asteroid extends Entity {

    private int asteroidSize;

    private AsteroidPlugin asteroidPlugin = new AsteroidPlugin();

    @Override
    public void handleCollision(GameData gameData, World world, Entity collidingEntity) {

        if(getAsteroidSize() == 1) {
            callPlayerScoring();
            world.removeEntity(collidingEntity);
            world.removeEntity(this);
        } else if (getAsteroidSize() == 2) {
            Entity asteroidChild1 = asteroidPlugin.createAsteroid(gameData);
            asteroidPlugin.setNewPolygonCoordinates(asteroidChild1, 1);
            asteroidChild1.setX(this.getX());
            asteroidChild1.setY(this.getY());
            asteroidChild1.setRotation(Math.random() * 360);
            world.addEntity(asteroidChild1);

            Entity asteroidChild2 = asteroidPlugin.createAsteroid(gameData);
            asteroidPlugin.setNewPolygonCoordinates(asteroidChild2, 1);
            asteroidChild2.setX(this.getX());
            asteroidChild2.setY(this.getY());
            asteroidChild2.setRotation(Math.random() * 360);
            world.addEntity(asteroidChild2);

            world.removeEntity(collidingEntity);
            world.removeEntity(this);
        } else {
            Entity asteroidChild1 = asteroidPlugin.createAsteroid(gameData);
            asteroidPlugin.setNewPolygonCoordinates(asteroidChild1, 2);
            asteroidChild1.setX(this.getX());
            asteroidChild1.setY(this.getY());
            asteroidChild1.setRotation(Math.random() * 360);
            world.addEntity(asteroidChild1);

            Entity asteroidChild2 = asteroidPlugin.createAsteroid(gameData);
            asteroidPlugin.setNewPolygonCoordinates(asteroidChild2, 2);
            asteroidChild2.setX(this.getX());
            asteroidChild2.setY(this.getY());
            asteroidChild2.setRotation(Math.random() * 360);
            world.addEntity(asteroidChild2);

            world.removeEntity(collidingEntity);
            world.removeEntity(this);
        }
    }

    private void callPlayerScoring() {
        final String uri = "http://localhost:8080/newScore?point=1";

        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.getResponseCode();
            connection.disconnect();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public int getAsteroidSize() {
        return asteroidSize;
    }

    public void setAsteroidSize(int asteroidSize) {
        this.asteroidSize = asteroidSize;
    }
}
