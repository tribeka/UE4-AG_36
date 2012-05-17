
package publishservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the publishservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HighScoreRequest_QNAME = new QName("http://big.tuwien.ac.at/we/highscore/data", "HighScoreRequest");
    private final static QName _HighScoreResponse_QNAME = new QName("http://big.tuwien.ac.at/we/highscore/data", "HighScoreResponse");
    private final static QName _UserKey_QNAME = new QName("http://big.tuwien.ac.at/we/highscore/data", "UserKey");
    private final static QName _Failure_QNAME = new QName("http://big.tuwien.ac.at/we/highscore", "Failure");
    private final static QName _DescTypeB_QNAME = new QName("", "b");
    private final static QName _DescTypeI_QNAME = new QName("", "i");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publishservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InfoType.Players }
     * 
     */
    public InfoType.Players createInfoTypePlayers() {
        return new InfoType.Players();
    }

    /**
     * Create an instance of {@link DescType }
     * 
     */
    public DescType createDescType() {
        return new DescType();
    }

    /**
     * Create an instance of {@link MovesType.Roll }
     * 
     */
    public MovesType.Roll createMovesTypeRoll() {
        return new MovesType.Roll();
    }

    /**
     * Create an instance of {@link FailureType }
     * 
     */
    public FailureType createFailureType() {
        return new FailureType();
    }

    /**
     * Create an instance of {@link InfoType.Players.Screenname }
     * 
     */
    public InfoType.Players.Screenname createInfoTypePlayersScreenname() {
        return new InfoType.Players.Screenname();
    }

    /**
     * Create an instance of {@link InfoType.Winner }
     * 
     */
    public InfoType.Winner createInfoTypeWinner() {
        return new InfoType.Winner();
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
    }

    /**
     * Create an instance of {@link InfoType }
     * 
     */
    public InfoType createInfoType() {
        return new InfoType();
    }

    /**
     * Create an instance of {@link MovesType.Piece }
     * 
     */
    public MovesType.Piece createMovesTypePiece() {
        return new MovesType.Piece();
    }

    /**
     * Create an instance of {@link HighScoreRequestType }
     * 
     */
    public HighScoreRequestType createHighScoreRequestType() {
        return new HighScoreRequestType();
    }

    /**
     * Create an instance of {@link MovesType }
     * 
     */
    public MovesType createMovesType() {
        return new MovesType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HighScoreRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://big.tuwien.ac.at/we/highscore/data", name = "HighScoreRequest")
    public JAXBElement<HighScoreRequestType> createHighScoreRequest(HighScoreRequestType value) {
        return new JAXBElement<HighScoreRequestType>(_HighScoreRequest_QNAME, HighScoreRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://big.tuwien.ac.at/we/highscore/data", name = "HighScoreResponse")
    public JAXBElement<String> createHighScoreResponse(String value) {
        return new JAXBElement<String>(_HighScoreResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://big.tuwien.ac.at/we/highscore/data", name = "UserKey")
    public JAXBElement<String> createUserKey(String value) {
        return new JAXBElement<String>(_UserKey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FailureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://big.tuwien.ac.at/we/highscore", name = "Failure")
    public JAXBElement<FailureType> createFailure(FailureType value) {
        return new JAXBElement<FailureType>(_Failure_QNAME, FailureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DescType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "b", scope = DescType.class)
    public JAXBElement<DescType> createDescTypeB(DescType value) {
        return new JAXBElement<DescType>(_DescTypeB_QNAME, DescType.class, DescType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DescType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "i", scope = DescType.class)
    public JAXBElement<DescType> createDescTypeI(DescType value) {
        return new JAXBElement<DescType>(_DescTypeI_QNAME, DescType.class, DescType.class, value);
    }

}
