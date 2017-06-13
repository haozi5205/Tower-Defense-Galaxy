package com.logicmaster63.tdgalaxy.tower.basic;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.physics.bullet.collision.btBoxShape;
import com.badlogic.gdx.physics.bullet.collision.btCollisionWorld;
import com.badlogic.gdx.utils.IntMap;
import com.logicmaster63.tdgalaxy.projectiles.basic.Bullet;
import com.logicmaster63.tdgalaxy.tools.Dependency;
import com.logicmaster63.tdgalaxy.tower.ProjectileTower;

import java.util.ArrayList;
import java.util.List;

public class Gun extends ProjectileTower{

    public static final int HP = 20;
    public static final float COOLDOWN = 2f;
    public static final int RANGE = 3000;
    public static final String ATTACK_ANIMATION = "";
    public static final Vector3 ATTACK_OFFSET = Vector3.Zero;

    public Gun(Vector3 pos, int types, ModelInstance instance, ModelInstance bulletInstance, btCollisionWorld world, IntMap<com.logicmaster63.tdgalaxy.entity.Entity> entities, boolean isTemplate) {
        super(pos, HP, RANGE, COOLDOWN, types, instance, new btBoxShape(instance.calculateBoundingBox(new BoundingBox()).getDimensions(new Vector3())), world, entities, ATTACK_ANIMATION, new Bullet(bulletInstance, true, world, entities), ATTACK_OFFSET, isTemplate);
        for(int i = 0; i < instance.nodes.size; i++)
            System.out.println(instance.nodes.get(i).id);
    }

    @Override
    public void tick(float delta) {
        super.tick(delta);
    }

    @Override
    public void render(float delta, ModelBatch modelBatch, ShapeRenderer shapeRenderer) {
        super.render(delta, modelBatch, shapeRenderer);

    }

    public static ArrayList<com.logicmaster63.tdgalaxy.tools.Asset> getAssets() {
        ArrayList<com.logicmaster63.tdgalaxy.tools.Asset> assets = new ArrayList<com.logicmaster63.tdgalaxy.tools.Asset>();
        assets.add(new com.logicmaster63.tdgalaxy.tools.Asset("theme/basic/tower/Gun.g3db", Model.class));
        return assets;
    }

    public static List getDependencies() {
        List<Dependency> dependencies = new ArrayList<Dependency>();
        dependencies.add(new Dependency(Bullet.class, "Bullet"));
        return dependencies;
    }
}