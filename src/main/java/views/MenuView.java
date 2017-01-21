package views;
import utils.*;

public class MenuView{
	private IO io;
	
	public MenuView(){
		io = new IO();
	}
	
	public int readOptionMenu(){
		io.writeln(
				"--------------------------------\n"
				+ "1. Mover de baraja a descarte\n"
				+ "2. Mover de descarte a baraja\n"
				+ "3. Mover de descarte a palo\n"
				+ "4. Mover de descarte a escalera\n"
				+ "5. Mover de escalera a palo\n"
				+ "6. Mover de escalera a escalera\n"
				+ "7. Mover de palo a escalera\n"
				+ "8. Voltear en escalera\n"
				+ "9. Salir"
				);
		
		io.writeln();
		return new LimitedIntDialog("Opción?", 1, 9).read();
	}

}
