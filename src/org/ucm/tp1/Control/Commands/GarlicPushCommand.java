package org.ucm.tp1.Control.Commands;

import org.ucm.tp1.Logic.Game;

public class GarlicPushCommand extends Command{
	public GarlicPushCommand() {
		super("garlic", "g", "details", "help");
	}
	
	@Override
	public boolean execute(Game game) {
		boolean validCommand = false;
		if(!game.getGameObjectBoard().garlicPush(game)) {
			System.out.println("You don't have enough coins.");
		}
		else {
			validCommand = true;
			game.update();
		}
		return validCommand;
	}
	
	@Override
	public Command parse(String[] commandWords) {
		return parseNoParamsCommand(commandWords);
	}
}
