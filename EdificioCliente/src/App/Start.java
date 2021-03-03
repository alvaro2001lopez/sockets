package App;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.net.ssl.SSLSocketFactory;

import Modelo.Edificio;

public class Start {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		

		int iRespuesta = 0;
		do {
			System.out.println("Seleccione una opción: ");
			System.out.println("1. Registrar");
			System.out.println("2. Borrar edificio:");
			System.out.println("3. Comprobar estado de los edificios:");
			System.out.println("4. Salir.");
			iRespuesta = sc.nextInt();
			switch (iRespuesta) {

			case 1:
				System.out.println("Introduce Nombre de edificio para registro: ");
				
				String sNombre = sc.next();

				System.out.println("Introduce la ciudad para registro: ");
				String sCiudad = sc.next();
				System.out.println("Introduce la direccion para registro: ");
				String sDireccion= sc.next();

				Controlador.crtEdificio.addEdificio(sNombre, sCiudad, sDireccion);

				break;
			case 2:
				try {
				
				System.out.println("Introduce id de edificio para borrar: ");
				
				int sID = Integer.parseInt(sc.next());
				
				Controlador.crtEdificio.deleteEdificio(sID);
				} catch (Exception e) {
					System.err.println("Error: el ID introducido del edificio no es correcto.");
				

				}

				break;
			case 3:
					Edificio Edificio;
					try {
						
						SSLSocketFactory clientFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
						Socket scSocket = clientFactory.createSocket("192.168.30.124", 8888);
						ObjectInputStream inputStream = new ObjectInputStream(scSocket.getInputStream());
						DataOutputStream outputStream= new DataOutputStream(scSocket.getOutputStream());
						String sMensaje ="PREGUNTANDO AL SERVIDOR";
						outputStream.writeUTF(sMensaje);
						Edificio = (Edificio)inputStream.readObject();
						
						System.out.println(Edificio);

						scSocket.close();
						
						
					} catch (Exception e) {
						
					}
					break;
				}
				
			
			} while (iRespuesta != 4);
	}

}
