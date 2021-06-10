package ma.uca.ensas.ebanking.ebanking.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id",scope = Agent.class)
public class Agent implements Serializable {

    @Id
    private Long        id;
    private String      nom;
    private String      prenom;
    private String      email;
    private String      tele;
    private String      login;
    private String      password;

    @ManyToOne
    @JoinColumn(name = "id_agence")
    private Agence  agence;

    @OneToMany(mappedBy = "agent")
    private List<Compte> comptes;

    public Agent() {}

    public Agent(Long id, String nom, String prenom, String email, String tele, String login, String password, Agence id_agence) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tele = tele;
        this.login = login;
        this.password = password;
        this.agence = id_agence;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId_agence(Agence id_agence) {
        this.agence = id_agence;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTele() {
        return tele;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Agence getId_agence() {
        return agence;
    }
}
