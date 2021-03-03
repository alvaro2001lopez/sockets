package Controlador;

import java.io.IOException;
import Logica.PeticionHTTP;

public class crtEdificio {

	public static void addEdificio(String sNombre, String sCiudad, String sDireccion) {

		try {
			PeticionHTTP.peticionHttpGET(
					"https://clinicadentaljava.000webhostapp.com/Edificios/NewEdificio.php?NOMBRE_EDIFICIO="
							+ sNombre+ "&DIRECCION=" + sDireccion.replace(" ", "%20") + "&CIUDAD="
							+ sCiudad);

		} catch (IOException e) {
		}

	}

	public static void deleteEdificio(int iID) {

		try {
			PeticionHTTP.peticionHttpGET(
					"https://clinicadentaljava.000webhostapp.com/Edificios/DeleteEdificio.php?ID_EDIFICIO=" + iID);

		} catch (IOException e) {
			System.err.println("Error, la id introducida no es de ningún edificio.");
		}

	}

	

	

}
