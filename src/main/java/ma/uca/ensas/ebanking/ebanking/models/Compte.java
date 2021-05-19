package ma.uca.ensas.ebanking.ebanking.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

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


    public Compte() {}

    public Compte(Long id, String type, String etat, Date creation, Float solde, Client id_client, Agent id_agent) {
        this.id = id;
        this.type = type;
        this.etat = etat;
        this.creation = creation;
        this.solde = solde;
        this.client = id_client;
        this.agent = id_agent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    public void setId_client(Client id_client) {
        this.client = id_client;
    }

    public void setId_agent(Agent id_agent) {
        this.agent = id_agent;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getEtat() {
        return etat;
    }

    public Date getCreation() {
        return creation;
    }

    public Float getSolde() {
        return solde;
    }

    public Client getId_client() {
        return client;
    }

    public Agent getId_agent() {
        return agent;
    }
}
