package ma.uca.ensas.ebanking.ebanking.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Virement implements Serializable {

    @Id
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

    public Virement(Long id, Date virement, Float montant, Compte id_deb, Compte id_cre) {
        this.id = id;
        this.virement = virement;
        this.montant = montant;
        this.compte_deb = id_deb;
        this.compte_cred = id_cre;
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

    public Compte getCompte_deb() {
        return compte_deb;
    }

    public Compte getCompte_cred() {
        return compte_cred;
    }




}
