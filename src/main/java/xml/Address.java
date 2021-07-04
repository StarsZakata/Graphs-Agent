package xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @XmlAttribute(name="address")
    private String addr;
    @XmlAttribute
    private String port;


    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public Address(String addr, String port) {
        this.addr = addr;
        this.port = port;
    }
    public Address() {
    }
}
