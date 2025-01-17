/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandro
 */
@Entity
@Table(name = "temperatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temperatura.findAll", query = "SELECT t FROM Temperatura t")
    , @NamedQuery(name = "Temperatura.findByCodTemperatura", query = "SELECT t FROM Temperatura t WHERE t.codTemperatura = :codTemperatura")
    , @NamedQuery(name = "Temperatura.findByValorTemperatura", query = "SELECT t FROM Temperatura t WHERE t.valorTemperatura = :valorTemperatura")})
public class Temperatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_temperatura")
    private Integer codTemperatura;
    @Basic(optional = false)
    @Column(name = "valor_temperatura")
    private int valorTemperatura;

    public Temperatura() {
    }

    public Temperatura(Integer codTemperatura) {
        this.codTemperatura = codTemperatura;
    }

    public Temperatura(Integer codTemperatura, int valorTemperatura) {
        this.codTemperatura = codTemperatura;
        this.valorTemperatura = valorTemperatura;
    }

    public Integer getCodTemperatura() {
        return codTemperatura;
    }

    public void setCodTemperatura(Integer codTemperatura) {
        this.codTemperatura = codTemperatura;
    }

    public int getValorTemperatura() {
        return valorTemperatura;
    }

    public void setValorTemperatura(int valorTemperatura) {
        this.valorTemperatura = valorTemperatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTemperatura != null ? codTemperatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temperatura)) {
            return false;
        }
        Temperatura other = (Temperatura) object;
        if ((this.codTemperatura == null && other.codTemperatura != null) || (this.codTemperatura != null && !this.codTemperatura.equals(other.codTemperatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Temperatura[ codTemperatura=" + codTemperatura + " ]";
    }
    
}
