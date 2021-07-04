package LR3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Neighbour {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private double weight;

    public Neighbour() {
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public Neighbour(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

}
