import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Tallentaja {
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private FileInputStream fi;
	private ObjectInputStream oi;
	
	public Tallentaja(String txtfile) throws IOException {
		this.fos = new FileOutputStream(new File(txtfile));
		this.oos = new ObjectOutputStream(fos);
		this.fi = new FileInputStream(new File(txtfile));
		this.oi = new ObjectInputStream(fi);
	}
	
	public void tallennaPeli(Lauta lauta) throws IOException {
		oos.writeObject(lauta);
	}
	
	public Lauta luePeli() throws ClassNotFoundException, IOException {
		
		return (Lauta)oi.readObject();
	}
}
