package at.ac.big.tuwien.ewa.picasa;

/**
 * Used to represent an avator in the BIG game
 * @author pl
 *
 */
public class Avatar {
	
	
	private String url;
	private String description;
	
	
	public Avatar() {
		
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Avatar [url=" + url + ", description=" + description + "]";
	}
	
	
	

}
