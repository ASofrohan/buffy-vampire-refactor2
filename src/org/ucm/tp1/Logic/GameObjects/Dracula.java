package org.ucm.tp1.Logic.GameObjects;
import org.ucm.tp1.Logic.Game;

public class Dracula extends Vampire{
	public Dracula(int row, int column, Game game) {
		super(row, column, game);
		System.out.print("DRACULA IS ALIVE!\n");
	}
	public void attack() {
		IAttack other = game.getAttackableInPosition(this.row, this.column-1);
		if(other != null) other.receiveDraculaAttack();
	}
	
	public String toString() {
    	return "D[" + super.getHealth() + "]";
    }
}
