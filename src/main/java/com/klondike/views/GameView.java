package com.klondike.views;

import com.klondike.models.Game;
import com.klondike.utils.IO;

public class GameView {
	
	private DeckView deckView;
	
	private WasteView wasteView;
	
	private TableauView tableauView;
	
	private FoundationView foundationView;
	
	private Game game;
	
	public GameView(Game game)
	{
		this.game = game;
		this.deckView = new DeckView();
		this.wasteView = new WasteView();
		this.tableauView = new TableauView();
		this.foundationView = new FoundationView();
	}
	
	public void render()
	{
		IO.instance().writeln("Baraja: " + deckView.render(game.getGameDeck()));
		IO.instance().writeln("Descarte: " + wasteView.render(game.getGameWaste()));
		IO.instance().writeln("Palo oros: " + foundationView.render(game.getCoinsFoundation()));
		IO.instance().writeln("Palo copas: "+foundationView.render(game.getCupsFoundation()));
		IO.instance().writeln("Palo espadas: "+foundationView.render(game.getSwordsFoundation()));
		IO.instance().writeln("Palo bastos: "+foundationView.render(game.getBatonsFoundation()));
		IO.instance().writeln("Escalera 1: "+tableauView.render(game.getTableau(1)));
		IO.instance().writeln("Escalera 2: "+tableauView.render(game.getTableau(2)));
		IO.instance().writeln("Escalera 3: "+tableauView.render(game.getTableau(3)));
		IO.instance().writeln("Escalera 4: "+tableauView.render(game.getTableau(4)));
		IO.instance().writeln("Escalera 5: "+tableauView.render(game.getTableau(5)));
		IO.instance().writeln("Escalera 6: "+tableauView.render(game.getTableau(6)));
		IO.instance().writeln("Escalera 7: "+tableauView.render(game.getTableau(7)));
	}

}
