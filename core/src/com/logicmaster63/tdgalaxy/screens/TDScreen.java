package com.logicmaster63.tdgalaxy.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.logicmaster63.tdgalaxy.TDGalaxy;
import com.logicmaster63.tdgalaxy.ui.MessageWindow;

public abstract class TDScreen implements Screen {

    Game game;
    protected SpriteBatch spriteBatch;
    protected OrthographicCamera orthographicCamera;
    protected Viewport viewport;
    protected Stage stage;
    private InputMultiplexer multiplexer;

    public TDScreen (Game game) {
        this.game = game;
    }

    @Override
    public void resize (int width, int height) {
        viewport.update(width, height);
        System.out.println("Resize");
    }

    public void addInputProcessor(InputProcessor processor) {
        multiplexer.addProcessor(processor);
    }

    @Override
    public void show () {
        orthographicCamera = new OrthographicCamera(2560, 1600);
        spriteBatch = new SpriteBatch();
        orthographicCamera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        viewport = new FitViewport(2560, 1600, orthographicCamera);
        viewport.apply();
        stage = new Stage(viewport);
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);
        if(TDGalaxy.isDebug())
            stage.setDebugAll(true);
    }

    @Override
    public void hide () {
        System.out.println("Hide");
    }

    @Override
    public void pause () {
        System.out.println("Pause");
    }

    @Override
    public void resume () {
        System.out.println("Resume");
    }

    @Override
    public void dispose () {
        System.out.println("Dispose");
    }

    @Override
    public void render(float delta) {
        stage.act(Gdx.graphics.getDeltaTime());
        orthographicCamera.update();
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        spriteBatch.begin();
        //TDWorld.getFonts().get("ui32").draw(spriteBatch, orthographicCamera.unproject(tmp.set(Gdx.input.getX(), Gdx.input.getY(), 0)).toString(), 100, 100);
        spriteBatch.end();
        stage.draw();
    }
}