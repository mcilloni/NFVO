package org.project.openbaton.nfvo.catalogue.nfvo;

import org.project.openbaton.nfvo.catalogue.util.IdGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lto on 20/05/15.
 */
@Entity
public class Network implements Serializable {
    @Id
    private String id = IdGenerator.createUUID();;
    @Version
    private static int version = 0;
    private String name;
    private String extId;
    private Boolean external;
    private Boolean shared;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Subnet> subnets;

    public Network(){
    }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }

    public int getVersion() { return version; }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public String getExtId() {
        return extId;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setSubnets(Iterable<Subnet> subnets) {
        List<Subnet> tmp = new ArrayList<Subnet>();
        for (Subnet subnet : subnets){
            tmp.add(subnet);
        }
        this.subnets = tmp;
    }

    public List<Subnet> getSubnets() {
        return subnets;
    }

    public void addSubnet(Subnet subnet) {
        this.subnets.add(subnet);
    }

    public boolean removeSubnet(Subnet subnet) {
        return subnets.remove(subnet);
    }

    @Override
    public String toString() {
        return "Network{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", extId='" + extId + '\'' +
                ", external=" + external +
                ", shared=" + shared +
                ", subnets=" + subnets +
                '}';
    }
}
