/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.big.tuwien.ewa.picasa;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.ILink;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.data.photos.UserFeed;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PicasaConnectorImpl implements PicasaConnector {
    
    protected PicasawebService service;
    protected String userName;
    
    public PicasaConnectorImpl(String username) throws Exception
    {
        service = new PicasawebService("BIG-MAEDN");
        userName = username;
        
        
    }
    
    @Override
    public List<Avatar> getPhotoURLs() throws Exception {
        
        List<Avatar> list = new ArrayList<Avatar>();
        
        UserFeed myUserFeed = service.getFeed(new URL("https://picasaweb.google.com/data/feed/api/user/" 
                + userName + "?kind=album"), UserFeed.class);

        List<AlbumEntry> albums = myUserFeed.getAlbumEntries();
        
        if(albums.isEmpty())
            throw new Exception("User has no albums!");
        
        AlbumEntry album = albums.get(0);
        
        if(album == null)
            throw new Exception("not found");

        AlbumFeed feed = album.getFeed();
        List<PhotoEntry> plist = feed.getPhotoEntries();
        
        for(PhotoEntry photoe : plist) {
            
            Avatar a = new Avatar();
            a.setDescription(photoe.getDescription().getPlainText());
            a.setUrl(photoe.getMediaContents().get(0).getUrl());
            list.add(a);
        }
        /*
        Avatar a = new Avatar();
        a.setDescription("lol");
                a.setUrl("lol");
                list.add(a);*/
        
        return list;
        
    }
    
}
