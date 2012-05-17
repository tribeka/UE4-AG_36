
package publishservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="info" type="{http://dbai.tuwien.ac.at/ssd}infoType" minOccurs="0"/>
 *         &lt;element name="moves" type="{http://dbai.tuwien.ac.at/ssd}movesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "info",
    "moves"
})
@XmlRootElement(name = "game")
public class Game {

    protected InfoType info;
    protected MovesType moves;

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link InfoType }
     *     
     */
    public InfoType getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoType }
     *     
     */
    public void setInfo(InfoType value) {
        this.info = value;
    }

    /**
     * Gets the value of the moves property.
     * 
     * @return
     *     possible object is
     *     {@link MovesType }
     *     
     */
    public MovesType getMoves() {
        return moves;
    }

    /**
     * Sets the value of the moves property.
     * 
     * @param value
     *     allowed object is
     *     {@link MovesType }
     *     
     */
    public void setMoves(MovesType value) {
        this.moves = value;
    }

}
