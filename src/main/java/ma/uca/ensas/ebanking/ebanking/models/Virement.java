package ma.uca.ensas.ebanking.ebanking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Column(nullable=false)
    private Long        id_deb;

    @Column(nullable=false)
    private Long        id_cre;

    public Virement() { }

    public Virement(Long id, Date virement, Float montant, Long id_deb, Long id_cre) {
        this.id = id;
        this.virement = virement;
        this.montant = montant;
        this.id_deb = id_deb;
        this.id_cre = id_cre;
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

    public void setId_deb(Long id_deb) {
        this.id_deb = id_deb;
    }

    public void setId_cre(Long id_cre) {
        this.id_cre = id_cre;
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

    public Long getId_deb() {
        return id_deb;
    }

    public Long getId_cre() {
        return id_cre;
    }
}
