package LR3;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ConfigLR3")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgentCfg {

    @XmlElementWrapper(name = "neighbour")
    @XmlElement(name = "neighbours")
    private List<Neighbour> neighbours;
    @XmlElement(name = "startpoint")
    private boolean startpoint;
    @XmlElement(name = "endpoint")
    private boolean endpoint;

    public boolean isStartpoint() {
        return startpoint;
    }

    public void setStartpoint(boolean startpoint) {
        this.startpoint = startpoint;
    }

    public boolean isEndpoint() {
        return endpoint;
    }

    public void setEndpoint(boolean endpoint) {
        this.endpoint = endpoint;
    }

    public List<Neighbour> getNeighbours() {
        return neighbours;
    }
    public void setNeighbours(List<Neighbour> neighbours) {
        this.neighbours = neighbours;
    }
}


