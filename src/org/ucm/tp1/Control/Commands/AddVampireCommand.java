package org.ucm.tp1.Control.Commands;

import org.ucm.tp1.Logic.Game;

public class AddVampireCommand extends Command{
	int posX;
	int posY;
	String vampireType;
	
	public AddVampireCommand() {
		super("vampire", "v", "details", "help");
	}
	
	public AddVampireCommand(int x, int y, String vampireType) {
		super("vampire", "v", "details", "help");
		this.posX = x;
		this.posY = y;
		this.vampireType = vampireType;
	}
	
	@Override
	public boolean execute(Game game) {
	    boolean validCommand = false;
	    if (posX <= 0 || posX >= game.getLevel().getDim_x() || posY <= 0 || posY > game.getLevel().getDim_y()) {		//entra en el tablero
	        System.out.print(incorrectArgsMsg + "\nInvalid position.\n");
	    }
	    else {
	    	switch (vampireType) {
	    	case "d":
	    		if (!game.getGameObjectBoard().addDraculaCommand(posY, posX, game)) {
		            validCommand = false;
		            System.out.println("Could not add Dracula in that position. The position is occupied or you don't have enough coins.");
		        }
		        else validCommand = true;
	    		break;
	    	case "e":
	    		if (!game.getGameObjectBoard().addExpVampireCommand(posY, posX, game)) {
		            validCommand = false;
		            System.out.println("Could not add Explosive Vampire in that position. The position is occupied or you don't have enough coins.");
		        }
		        else validCommand = true;
	    		break;
	    	case " ":
	    		if (!game.getGameObjectBoard().addVampireCommand(posY, posX, game)) {
		            validCommand = false;
		            System.out.println("Could not add Vampire in that position. The position is occupied or you don't have enough coins.");
		        }
		        else validCommand = true;
	    		break;
	    	default:
	    		System.out.println("Unknown vampire type.");	    			    	
	    	}
	    }
	    return validCommand;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords.length == 3) {
		    return new AddVampireCommand(Integer.parseInt(commandWords[1]), Integer.parseInt(commandWords[2]), " ");
		}
		if(commandWords.length == 4) {
		    return new AddVampireCommand(Integer.parseInt(commandWords[2]), Integer.parseInt(commandWords[3]), commandWords[1]);
		}
		return parseNoParamsCommand(commandWords);
	}
}
