package ma.uca.ensas.ebanking.ebanking.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Compte implements Serializable {

    @Id
    private String        id;
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

    @OneToMany(mappedBy="compte_deb", cascade = CascadeType.ALL)
    private List<Virement> virements_envoyé;

    @OneToMany(mappedBy="compte_cred", cascade = CascadeType.ALL)
    private List<Virement> virements_recus;

    public List<Virement> getVirements_envoyé() {
        return virements_envoyé;
    }

    public void setVirements_envoyé(List<Virement> virements_envoyé) {
        this.virements_envoyé = virements_envoyé;
    }

    public List<Virement> getVirements_recus() {
        return virements_recus;
    }

    public void setVirements_recus(List<Virement> virements_recus) {
        this.virements_recus = virements_recus;
    }

    public Compte() {}

    public Compte(String id, String type, String etat, Date creation, Float solde, Client client, Agent agent) {
        this.id = id;
        this.type = type;
        this.etat = etat;
        this.creation = creation;
        this.solde = solde;
        this.client = client;
        this.agent = agent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
