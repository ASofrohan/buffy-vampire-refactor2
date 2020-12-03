package org.ucm.tp1.Logic.GameObjects;

import org.ucm.tp1.Logic.Game;

public class BankBlood extends GameObject {
	private int cost; 
    private int refound;
	
	public BankBlood(int row, int column, int cost, Game game) {
        this.cost = cost;
        this.refound = (int) (cost*0.10);
        setTotalRefound(getTotalRefound() + refound);
        deploy(row, column, game);
    }
	
	public boolean receiveVampireAttack(int damage) {
		if(this.isAlive()) {
			this.setAlive(false);
			setTotalRefound(getTotalRefound() - refound);
		}
		return true;
	}
	
	public boolean receiveDraculaAttack() {
		if(this.isAlive()) {
			this.setAlive(false);
			setTotalRefound(getTotalRefound() - refound);
		}
		return true;
	}
	
	public void attack() {				
	}
    public boolean push(int nColumns) {
    	return false;
    }
    public boolean move() {
    	return false;
    }  
    public String toString() {
    	return "B[" + this.cost + "]";
    }
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getRefound() {
		return refound;
	}
	public void setRefound(int refound) {
		this.refound = refound;
	}  
}
