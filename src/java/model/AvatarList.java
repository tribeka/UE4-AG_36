/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import at.ac.big.tuwien.ewa.picasa.Avatar;
import at.ac.big.tuwien.ewa.picasa.PicasaConnector;
import at.ac.big.tuwien.ewa.picasa.PicasaConnectorImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Bruno Bajtela
 */
@ManagedBean(name = "avatarprovider")
@ApplicationScoped
public class AvatarList implements Serializable {
    
    protected PicasaConnector connector;
    
    protected List<Avatar> avatars;
    
    public AvatarList() throws Exception
    {      
        connector = new PicasaConnectorImpl("111420671758947023853");
    }
    
    public List<Avatar> getAvatars() throws Exception
    {
        if(avatars == null) avatars = connector.getPhotoURLs();
        
        return avatars;
    }
    
    public Avatar getAvatarByDesc(String desc) throws Exception
    {
        List<Avatar> avatars = this.getAvatars();
        
        for(Avatar a : avatars)
        {
            if(a.getDescription().equals(desc))
                return a;
        }
        return null;
    }
    
}
