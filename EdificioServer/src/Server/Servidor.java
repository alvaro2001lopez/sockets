package Server;

import java.io.DataInputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import Controlador.PeticionHTTP;
import Modelo.Edificio;

public class Servidor implements Runnable, Serializable {

	private static final long serialVersionUID = 1L;
	private int port;

	public Servidor(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		ServerSocket servidor = null;
		Socket socket = null;
		DataInputStream inputStream;
		ObjectOutputStream outputStream;
		int i = 0;

		try {
			servidor = new ServerSocket(port);
			while (true) {

				String sResString = PeticionHTTP.peticionHttpGET("https://clinicadentaljava.000webhostapp.com/Edificios/ListEdificio.php");

				socket = servidor.accept();

				List<Edificio> lstedificios = PeticionHTTP.jsonToEdificios(sResString);
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				inputStream = new DataInputStream(socket.getInputStream());
				String sMensaje = inputStream.readUTF();
				System.out.println(sMensaje);

				Edificio edificio = lstedificios.get(i);
				outputStream.writeObject(edificio);

				i++;

				if (i == lstedificios.size()) {
					i = 0;
				}
				

				socket.close();

			}

		} catch (IOException e) {
		System.err.println("Error");
		} 

	}

	public static void main(String[] args) {
		Thread mihilo = new Thread(new Servidor(8888));
		mihilo.start();
	}

}
