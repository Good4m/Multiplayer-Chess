package com.satecha.chessgame;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import pieces.*;

/**
 * Main class where all the magic happens.
 */
public class ChessGame implements ApplicationListener {

	/** Board map */
    public static ConcurrentHashMap<String, Tile> tiles  = new ConcurrentHashMap<String, Tile>();
    
    /** Pieces map */
    public static ConcurrentHashMap<Vector2, Piece> pieces  = new ConcurrentHashMap<Vector2, Piece>();

    /**  Camera */
	private OrthographicCamera camera;

	/**  Sprite batch */
    public static SpriteBatch batch;
    
    /** Current tile selection tile - Gets drawn where user clicks */
    Tile currentSelectionTile_Down;
    Tile currentSelectionTile_Up;
    

    /**
     * This is basically the constructor.
     */
	@Override
	public void create() {
	    //Instantiate camera
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Instantiate sprite batch
		batch  = new SpriteBatch();

		//Set up input processor
		Input inputProcessor = new Input();
        Gdx.input.setInputProcessor(inputProcessor);
        Gdx.input.setCatchMenuKey(true);

        //Load graphics from texture atlas
        Drawable.loadGraphics();
        
        //Set current selection tile graphics
        //This is initially set to tile 8x8 because it is out of the play area.
        //We want to hide it initially
        currentSelectionTile_Down = new Tile(8 * Settings.getMaxTileWidth(), 8 * Settings.getMaxTileHeight(),
                Settings.getMaxTileWidth(), Settings.getMaxTileHeight(), 2);
        currentSelectionTile_Up = new Tile(8 * Settings.getMaxTileWidth(), 8 * Settings.getMaxTileHeight(),
                Settings.getMaxTileWidth(), Settings.getMaxTileHeight(), 3);
        
        //Create gameboard tiles
		createTiles();

		//Create game pieces
		createGamePieces();
	}


	/**
	 * Fills the pieces array with initial sets of game pieces.
	 */
	private void createGamePieces() {
	  //Pawns white
        pieces.put(new Vector2(0,1), new Pawn(0,1, PieceType.PAWN, Piece.WHITE));
        pieces.put(new Vector2(1,1), new Pawn(1,1, PieceType.PAWN, Piece.WHITE));
        pieces.put(new Vector2(2,1), new Pawn(2,1, PieceType.PAWN, Piece.WHITE));
        pieces.put(new Vector2(3,1), new Pawn(3,1, PieceType.PAWN, Piece.WHITE));
        pieces.put(new Vector2(4,1), new Pawn(4,1, PieceType.PAWN, Piece.WHITE));
        pieces.put(new Vector2(5,1), new Pawn(5,1, PieceType.PAWN, Piece.WHITE));
        pieces.put(new Vector2(6,1), new Pawn(6,1, PieceType.PAWN, Piece.WHITE));
        pieces.put(new Vector2(7,1), new Pawn(7,1, PieceType.PAWN, Piece.WHITE));
        //Pawns black
        pieces.put(new Vector2(0,6), new Pawn(0,6, PieceType.PAWN, Piece.BLACK));
        pieces.put(new Vector2(1,6), new Pawn(1,6, PieceType.PAWN, Piece.BLACK));
        pieces.put(new Vector2(2,6), new Pawn(2,6, PieceType.PAWN, Piece.BLACK));
        pieces.put(new Vector2(3,6), new Pawn(3,6, PieceType.PAWN, Piece.BLACK));
        pieces.put(new Vector2(4,6), new Pawn(4,6, PieceType.PAWN, Piece.BLACK));
        pieces.put(new Vector2(5,6), new Pawn(5,6, PieceType.PAWN, Piece.BLACK));
        pieces.put(new Vector2(6,6), new Pawn(6,6, PieceType.PAWN, Piece.BLACK));
        pieces.put(new Vector2(7,6), new Pawn(7,6, PieceType.PAWN, Piece.BLACK));
        
        //Rooks white
        pieces.put(new Vector2(0,0), new Rook(0,0, PieceType.ROOK, Piece.WHITE));
        pieces.put(new Vector2(7,0), new Rook(7,0, PieceType.ROOK, Piece.WHITE));
        //Rooks black
        pieces.put(new Vector2(0,7), new Rook(0,7, PieceType.ROOK, Piece.BLACK));
        pieces.put(new Vector2(7,7), new Rook(7,7, PieceType.ROOK, Piece.BLACK));
        
        //Knights white
        pieces.put(new Vector2(1,0), new Knight(1,0, PieceType.KNIGHT, Piece.WHITE));
        pieces.put(new Vector2(6,0), new Knight(6,0, PieceType.KNIGHT, Piece.WHITE));
        //Knights black
        pieces.put(new Vector2(1,7), new Knight(1,7, PieceType.KNIGHT, Piece.BLACK));
        pieces.put(new Vector2(6,7), new Knight(6,7, PieceType.KNIGHT, Piece.BLACK));
        
        //Bishops white
        pieces.put(new Vector2(2,0), new Bishop(2,0, PieceType.BISHOP, Piece.WHITE));
        pieces.put(new Vector2(5,0), new Bishop(5,0, PieceType.BISHOP, Piece.WHITE));
        //Bishops black
        pieces.put(new Vector2(2,7), new Bishop(2,7, PieceType.BISHOP, Piece.BLACK));
        pieces.put(new Vector2(5,7), new Bishop(5,7, PieceType.BISHOP, Piece.BLACK));
        
        //King white
        pieces.put(new Vector2(3,0), new King(3,0, PieceType.KING, Piece.WHITE));
        //King black
        pieces.put(new Vector2(3,7), new King(3,7, PieceType.KING, Piece.BLACK));
        
        //Queen white
        pieces.put(new Vector2(4,0), new Queen(4,0, PieceType.QUEEN, Piece.WHITE));
        //Queen black
        pieces.put(new Vector2(4,7), new Queen(4,7, PieceType.QUEEN, Piece.BLACK));
	}


	/**
	 * Populate the tiles map with an initial 8x8 grid.
	 */
	public void createTiles() {
        for(int x = 0; x < Settings.getMaxTileWidth(); x++) {
        	for(int y = 0; y < Settings.getMaxTileHeight(); y++) {
        		if(x % 2 == 0) {
        			if(y % 2 == 0)
        				tiles.put(String.valueOf(x + ":" + y), new Tile(x * Settings.getMaxTileWidth(), y * Settings.getMaxTileHeight(),
        						Settings.getMaxTileWidth(), Settings.getMaxTileHeight(), Tile.WHITE));
        			if(y % 2 != 0)
        				tiles.put(String.valueOf(x + ":" + y), new Tile(x * Settings.getMaxTileWidth(), y * Settings.getMaxTileHeight(),
        						Settings.getMaxTileWidth(), Settings.getMaxTileHeight(), Tile.BLACK));
        		}
        		if(x % 2 != 0) {
        			if(y % 2 == 0)
        				tiles.put(String.valueOf(x + ":" + y), new Tile(x * Settings.getMaxTileWidth(), y * Settings.getMaxTileHeight(),
        						Settings.getMaxTileWidth(), Settings.getMaxTileHeight(), Tile.BLACK));
        			if(y % 2 != 0)
        				tiles.put(String.valueOf(x + ":" + y), new Tile(x * Settings.getMaxTileWidth(), y * Settings.getMaxTileHeight(),
        						Settings.getMaxTileWidth(), Settings.getMaxTileHeight(), Tile.WHITE));
        		}
        	}
        }
    }


    /**
     * Draws a group of objects if their coords are within the game window
     * eg. drawGroup(tiles);
     * The group must extend Drawable.
     */
    public static <E, T extends Drawable> void drawGroup(ConcurrentHashMap<E, T> group) {
        for (Entry<E, T> entry : group.entrySet()) {
            T obj = entry.getValue();
            obj.drawMe();
        }
    }


    /**
     * Render loop. Call everything to draw.
     */
    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
            drawGroup(tiles);
            currentSelectionTile_Down.setLocation(Input.touchDownTileX * Settings.getMaxTileWidth(), Input.touchDownTileY * Settings.getMaxTileHeight());
            currentSelectionTile_Down.drawMe();
            if(!Input.touchDown) {
                currentSelectionTile_Up.setLocation(Input.touchUpTileX * Settings.getMaxTileWidth(), Input.touchUpTileY * Settings.getMaxTileHeight());
                currentSelectionTile_Up.drawMe();
            }
            drawGroup(pieces);
        batch.end();
    }


	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
