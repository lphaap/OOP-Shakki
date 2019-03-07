import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Tallentaja {

	private String file;
	
	public Tallentaja(String txtfile) throws IOException {
		this.file = txtfile;
	}
	
	public void tallennaPeli(Lauta lauta) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(this.file));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(lauta);
		oos.close();
	}
	
	public Lauta luePeli() throws ClassNotFoundException, IOException {
		FileInputStream fi = new FileInputStream(new File(this.file));
		ObjectInputStream oi = new ObjectInputStream(fi);
		Lauta lauta = (Lauta)oi.readObject();
		oi.close();
		return lauta;
	}
	
}
