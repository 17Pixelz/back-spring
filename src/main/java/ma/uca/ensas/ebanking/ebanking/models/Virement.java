package ma.uca.ensas.ebanking.ebanking.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ma.uca.ensas.ebanking.ebanking.repositories.CompteRepo;
import ma.uca.ensas.ebanking.ebanking.services.CompteService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id",scope = Virement.class)
public class Virement implements Serializable {

    @Id
    @GeneratedValue
    private Long        id;

    @Column(nullable=false)
    private Date        virement;

    @Column(nullable=false)
    private Float       montant;

    @ManyToOne
    @JoinColumn(name = "id_compte_deb")
    private Compte      compte_deb;

    @ManyToOne
    @JoinColumn(name = "id_compte_cred",referencedColumnName = "id")
    private Compte compte_cred;

    @ManyToOne
    @JoinColumn(name = "id_agent")
    private Agent agent;
    
    public Virement() { }

    public Virement(Long id, Date virement, Float montant, Compte id_compte_deb, Compte id_compte_cred) {
        this.id = id;
        this.virement = virement;
        this.montant = montant;
        this.compte_deb = id_compte_deb;
        this.compte_cred = id_compte_cred;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVirement(Date virement) {
        this.virement = virement;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public void setCompte_deb(Compte compte_deb) {
        this.compte_deb = compte_deb;
    }

    public void setCompte_cred(Compte compte_cred) {
        this.compte_cred = compte_cred;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Long getId() {
        return id;
    }

    public Date getVirement() {
        return virement;
    }

    public Float getMontant() {
        return montant;
    }

    public Compte getCompte_deb() { return compte_deb; }

    public Compte getCompte_cred() {
        return compte_cred;
    }




}
