package Controlador;

import Modelo.Edificio;

public class ContrEdificio {

	public static String ctrFuego() {
		
		String sMensaje = "ESTA BIEN.";
		Edificio edificio;
		double temp = Logic.LogicEdificio.TemperaturaRandom();
		if (temp >= 50) {
			sMensaje = "ESTA ARDIENDO \n LLAMANDO A LOS BOMBEROS A LA DIRECCION DE LA CIUDAD INDICADA "
					+ "\n ACTIVANDO ROCIADORES DE AGUA.";
			if (Logic.LogicEdificio.PersRamdon()) {
				sMensaje = sMensaje + "\n"
						+ "MANTENIENDO PUERTAS ABIERTAS PARA LA EVACUACION DE LAS PERSONAS \n LLAMANDO A LA AMBULANCIA.";
			} else {
				sMensaje = sMensaje + "\n" + "BLOQUEANDO PUERTAS Y VENTANAS PARA EVITAR PROPAGACION DEL FUEGO.";
			}
		}
		return sMensaje; 
	}
	
	
	
}
