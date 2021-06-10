package ma.uca.ensas.ebanking.ebanking.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id",scope = Siege.class)
public class Siege implements Serializable {

    @Id
    private Long        id;

    @Column(nullable=false)
    private String      nom;

    @Column(nullable=false)
    private String      ville;

    @OneToOne
    @JoinColumn(name = "id_admin")
    private Admin       admin;


    public Siege() {}

    public Siege(Long id, String nom, String ville, Admin id_admin) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.admin = id_admin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setId_admin(Admin id_admin) {
        this.admin = id_admin;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public Admin getId_admin() {
        return admin;
    }
}
