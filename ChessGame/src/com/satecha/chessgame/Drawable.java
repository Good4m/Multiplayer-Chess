package com.satecha.chessgame;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public abstract class Drawable {

	protected static TextureAtlas graphics_textures = new TextureAtlas("data/tileset.txt");
	public static ArrayList<AtlasRegion> graphics = new ArrayList<AtlasRegion>();

    private Sprite sprite;

    //Default constructor: no width/height specified = maximum sprite size
    public Drawable(float x, float y, TextureRegion textureRegion) {
        sprite = new Sprite(textureRegion);
        sprite.setSize(Settings.getMaxTileWidth(), Settings.getMaxTileHeight());
        sprite.setX(x);
        sprite.setY(y);
    }

    //Custom sprite size specified (for smaller things like effects)
    public Drawable(float x, float y, int width, int height, TextureRegion textureRegion) {
        sprite = new Sprite(textureRegion);
        sprite.setSize(width, height);
        sprite.setX(x);
        sprite.setY(y);
    }

    public void setSprite(TextureRegion region) {
    	sprite = new Sprite(region);
    }

    public void setLocation(float x, float y) {
        sprite.setPosition(x, y);
    }

    public void setX(float x) {
        sprite.setX(x);
    }

    public void setY(float y) {
        sprite.setY(y);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public abstract void drawMe();

    public static void loadGraphics() {
    	for(AtlasRegion region : graphics_textures.getRegions()) {
    		graphics.add(region);
    	}
    }

    public static void unloadGraphics() {
    	graphics_textures.dispose();
    }
}
