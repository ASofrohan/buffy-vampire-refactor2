package org.ucm.tp1.Logic.GameObjects;
import org.ucm.tp1.Logic.Game;

public abstract class GameObject implements IAttack{
	
	private int column;
	private int row;
	private Game game;
	private static boolean draculaAlive;
	private static int vAliveStatic;
	public abstract int getHealth();
	public abstract boolean move();
	public abstract String toString();
	
	public void deploy(int row, int column, Game game) {
		this.row = row;
		this.column = column;
		this.game = game;
	};
	
    static {
    	vAliveStatic = 0;
    	draculaAlive = false;
    }

    public boolean checkPos(int row, int column) {
    	boolean match = false;
    	if(row == this.row && column == this.column) {
    		match = true;
    	}
    	return match;
    }
	
	public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
	public void moveForward() {
		this.column--;
	}
	public static int getvAliveStatic() {
		return vAliveStatic;
	}
	public static void setvAliveStatic(int vAlive) {
		GameObject.vAliveStatic = vAlive;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public static boolean isDraculaAlive() {
		return draculaAlive;
	}
	public static void setDraculaAlive(boolean draculaAlive) {
		GameObject.draculaAlive = draculaAlive;
	}
};
