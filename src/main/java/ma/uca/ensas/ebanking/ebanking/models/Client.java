package ma.uca.ensas.ebanking.ebanking.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Long        id;
    private String      nom;
    private String      prenom;
    private String      tele;

    @Column(unique = true)
    private String      email;

    @Column(unique = true)
    private String      login;
    private String      password;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "id_agence")
    public Agence agence;

    @OneToOne(mappedBy = "client")
    private Compte compte;


    public Client() {}

    public Client(String nom, String prenom, String email, String tele, String login, String password ) {
       // this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tele = tele;
        this.login = login;
        this.password = password;
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

    public void setAgence(Agence agence) {
        this.agence = agence;
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

    public Agence getAgence() {
        return agence;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tele='" + tele + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", agence=" + agence +
                ", compte=" + compte +
                '}';
    }
}
