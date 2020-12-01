package org.ucm.tp1.Logic.GameObjects;
import org.ucm.tp1.Logic.Game;

public class Dracula extends Vampire{
	public Dracula(int row, int column, Game game) {
		super(row, column, game);
		setDraculaAlive(true);
		System.out.print("DRACULA IS ALIVE!\n");
	}
	
	@Override
	public void attack() {
		IAttack other = this.getGame().getAttackableInPosition(this.getRow(), this.getColumn()-1);
		if(other != null) other.receiveDraculaAttack();
	}
	
	@Override
	public boolean receiveSlayerAttack(int damage) {
		if(isAlive()) this.setHealth(this.getHealth()-damage);
		if(this.getHealth() <= 0) {
			setvAliveStatic(getvAliveStatic()-1);
			this.setAlive(false);
			setDraculaAlive(false);
		}
		return true;
	}
	
	public String toString() {
    	return "D[" + super.getHealth() + "]";
    }
}
