package ma.uca.ensas.ebanking.ebanking.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Agence implements Serializable {

    @Id
    private Long    id;
    private String    nom;
    private String    Adresse;

    @OneToMany(mappedBy = "agence")
    private List<Client>    clients;


    @OneToMany(mappedBy = "agence")
    private List<Agent> agents;

    public Agence() { }

    public Agence( String nom, String adresse) {

        this.nom = nom;
        Adresse = adresse;
    }

    public Agence(Long id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        Adresse = adresse;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }


    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return Adresse;
    }

}
