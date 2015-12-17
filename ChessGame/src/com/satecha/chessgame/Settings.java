package com.satecha.chessgame;

import com.badlogic.gdx.Gdx;

/**
 * This static class holds various game settings such as:
 * - Screen width/height
 * - Maximum single tile width/height (For 8x8 grid)
 */
public class Settings {
	private static Settings settings = new Settings();
	
    /** Screen size. */
    public static int screenWidth;
    public static int screenHeight;

    private Settings() {
        screenWidth  = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
    }
    
    public static int getScreenWidth() {
        return screenWidth;
    }
    public static int getScreenHeight() {
        return screenHeight;
    }
    public static int getMaxTileWidth() {
        return screenWidth / 8;
    }
    public static int getMaxTileHeight() {
        return screenHeight / 8;
    }

}