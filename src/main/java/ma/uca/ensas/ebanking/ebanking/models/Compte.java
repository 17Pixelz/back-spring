package ma.uca.ensas.ebanking.ebanking.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Compte implements Serializable {

    @Id
    private Long        id;
    private String      type;
    private String      etat;
    private Date        creation;
    private Float       solde;



    @OneToOne
    @JoinColumn(name = "id_client")
    private Client       client;

    @OneToOne
    @JoinColumn(name = "id_agent")
    private Agent       agent;

    @OneToMany(mappedBy="compte", cascade = CascadeType.ALL)
    private List<Virement> virements;


    public Compte() {}

    public Compte(Long id, String type, String etat, Date creation, Float solde, Client client, Agent agent) {
        this.id = id;
        this.type = type;
        this.etat = etat;
        this.creation = creation;
        this.solde = solde;
        this.client = client;
        this.agent = agent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }


}
