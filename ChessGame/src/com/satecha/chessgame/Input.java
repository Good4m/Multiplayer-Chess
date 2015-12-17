package com.satecha.chessgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * This class is for receiving input from the user.
 */
public class Input implements InputProcessor {

    /** Keyup/down variables. */
    public static boolean touchDown  = false;

    public static int touchX         = 0; //absolute x location
    public static int touchY         = 0; //absolute y location

    public static int touchDownTileX = 0; //tile x coord location (0-7)
    public static int touchDownTileY = 0; //tile y coord location (0-7)

    public static int touchUpTileX   = 0; //tile x coord location (0-7)
    public static int touchUpTileY   = 0; //tile y coord location (0-7)

    public static double touchAngle  = 0;

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.ESCAPE) {
            Gdx.app.exit();
        }
        return false;
    }

    @Override
    public boolean keyTyped (char character) {
       return false;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
       touchDown = true;
       touchX    = x;
       touchY    = y;

       touchDownTileX = x / Settings.getMaxTileWidth();
       touchDownTileY = y / Settings.getMaxTileHeight();

       System.out.println("Mousedown on tile: " + touchDownTileX + "x" + touchDownTileY);

       return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
       touchDown = false;

       touchUpTileX = x / Settings.getMaxTileWidth();
       touchUpTileY = y / Settings.getMaxTileHeight();

       System.out.println("Mouseup on tile: " + touchUpTileX + "x" + touchUpTileY);

       return false;
    }

    @Override
    public boolean touchDragged (int x, int y, int pointer) {
       touchX = x;
       touchY = y;
       return false;
    }

    @Override
    public boolean scrolled (int amount) {
       return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }
 }
