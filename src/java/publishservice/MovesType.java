
package publishservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for movesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="movesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="roll">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://dbai.tuwien.ac.at/ssd>number1to6">
 *                 &lt;attribute name="player" type="{http://dbai.tuwien.ac.at/ssd}number1to4" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="piece">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="nr" type="{http://dbai.tuwien.ac.at/ssd}number1to16" />
 *                 &lt;attribute name="player" type="{http://dbai.tuwien.ac.at/ssd}number1to4" />
 *                 &lt;attribute name="field" type="{http://dbai.tuwien.ac.at/ssd}number1to72" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movesType", propOrder = {
    "rollOrPiece"
})
public class MovesType {

    @XmlElements({
        @XmlElement(name = "piece", type = MovesType.Piece.class),
        @XmlElement(name = "roll", type = MovesType.Roll.class)
    })
    protected List<Object> rollOrPiece;

    /**
     * Gets the value of the rollOrPiece property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rollOrPiece property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRollOrPiece().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MovesType.Piece }
     * {@link MovesType.Roll }
     * 
     * 
     */
    public List<Object> getRollOrPiece() {
        if (rollOrPiece == null) {
            rollOrPiece = new ArrayList<Object>();
        }
        return this.rollOrPiece;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="nr" type="{http://dbai.tuwien.ac.at/ssd}number1to16" />
     *       &lt;attribute name="player" type="{http://dbai.tuwien.ac.at/ssd}number1to4" />
     *       &lt;attribute name="field" type="{http://dbai.tuwien.ac.at/ssd}number1to72" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Piece {

        @XmlAttribute
        protected Integer nr;
        @XmlAttribute
        protected Integer player;
        @XmlAttribute
        protected Integer field;

        /**
         * Gets the value of the nr property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getNr() {
            return nr;
        }

        /**
         * Sets the value of the nr property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setNr(Integer value) {
            this.nr = value;
        }

        /**
         * Gets the value of the player property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getPlayer() {
            return player;
        }

        /**
         * Sets the value of the player property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setPlayer(Integer value) {
            this.player = value;
        }

        /**
         * Gets the value of the field property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getField() {
            return field;
        }

        /**
         * Sets the value of the field property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setField(Integer value) {
            this.field = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://dbai.tuwien.ac.at/ssd>number1to6">
     *       &lt;attribute name="player" type="{http://dbai.tuwien.ac.at/ssd}number1to4" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Roll {

        @XmlValue
        protected int value;
        @XmlAttribute
        protected Integer player;

        /**
         * Gets the value of the value property.
         * 
         */
        public int getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * Gets the value of the player property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getPlayer() {
            return player;
        }

        /**
         * Sets the value of the player property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setPlayer(Integer value) {
            this.player = value;
        }

    }

}
