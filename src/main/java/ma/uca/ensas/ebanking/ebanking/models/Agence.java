package ma.uca.ensas.ebanking.ebanking.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Agence implements Serializable {

    @Id
    private Long    id;
    private Long    nom;
    private Long    Adresse;

    @OneToMany(mappedBy = "agence")
    private List<Client>    clients;


    @OneToMany(mappedBy = "agence")
    private List<Agent> agents;

    public Agence() { }

    public Agence(Long id, Long nom, Long adresse) {
        this.id = id;
        this.nom = nom;
        Adresse = adresse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(Long nom) {
        this.nom = nom;
    }

    public void setAdresse(Long adresse) {
        Adresse = adresse;
    }


    public Long getId() {
        return id;
    }

    public Long getNom() {
        return nom;
    }

    public Long getAdresse() {
        return Adresse;
    }

}
