import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires CommonBullet;
    requires AstroidTest;
    requires Player;
    requires EnemySpaceship;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.collision.CollisionSystem;
}