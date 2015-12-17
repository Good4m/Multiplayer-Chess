package com.satecha.chessgame;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Tile extends Drawable {

    public static final int WHITE = 0, BLACK = 1;

	private int tileType;

    public Tile(float x, float y, int width, int height, int tileType) {
    	super(x, y, width, height,
    	        new AtlasRegion(graphics_textures.findRegion(Integer.toString(tileType))));
    	this.tileType = tileType;
	}

    public void setTileType(int tileType) {
    	this.tileType = tileType;
    }

    public int getTileType() {
    	return this.tileType;
    }

    @Override
    public void drawMe() {
        getSprite().setPosition(getX(), getY());
        getSprite().draw(ChessGame.batch);
    }

}
