package com.klondike.views;
import com.klondike.utils.IO;

public class MenuView {
	
	public MenuView()
	{
		
	}
	
	public void render()
	{
		IO.instance().writeln("---------------------------");
		IO.instance().writeln("1. Mover de baraja a descarte");
		IO.instance().writeln("2. Mover de descarte a baraja");
		IO.instance().writeln("3. Mover de descarte a palo");
		IO.instance().writeln("4. Mover de descarte a escalera");
		IO.instance().writeln("5. Mover de escalera a palo");
		IO.instance().writeln("6. Mover de escalera a escalera");
		IO.instance().writeln("7. Mover de palo a escalera");
		IO.instance().writeln("8. Voltear en escalera");
		IO.instance().writeln("9. Salir");
	}

}
