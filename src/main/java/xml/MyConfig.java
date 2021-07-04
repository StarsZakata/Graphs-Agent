package xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="config")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyConfig {
    @XmlElement
    private String path;
    @XmlElement
    private double quantity;
    @XmlElementWrapper(name = "addresses")
    @XmlElement(name = "item")
    private List<Address> addresses;


    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public List<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
