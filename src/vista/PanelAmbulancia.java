package vista;

import java.util.Observable;
import java.util.Observer;

import personas.Ambulancia;


public class PanelAmbulancia  implements Observer {
private Ambulancia ambulancia;


	@Override
	public void update(Observable o, Object arg) {
		Ambulancia ambulancia =(Ambulancia) o;
		if(this.ambulancia==o) {
			System.out.println("La ambulancia esta "+arg);//ver que va aca
		}
		else
			throw new IllegalArgumentException();
	}

	
}
