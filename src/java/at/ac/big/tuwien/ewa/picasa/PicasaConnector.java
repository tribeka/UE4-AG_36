package at.ac.big.tuwien.ewa.picasa;

import java.util.List;

public interface PicasaConnector {

	
	
	/** Used to retrieve a list of photo URLs form the Picasa album */
	public List<Avatar> getPhotoURLs() throws Exception;
	
	
	
}
