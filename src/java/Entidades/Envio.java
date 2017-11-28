/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose.zuniga
 */
@Entity
@Table(name = "envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envio.findAll", query = "SELECT e FROM Envio e")
    , @NamedQuery(name = "Envio.findByIdEnvio", query = "SELECT e FROM Envio e WHERE e.idEnvio = :idEnvio")
    , @NamedQuery(name = "Envio.findByNombreEnvio", query = "SELECT e FROM Envio e WHERE e.nombreEnvio = :nombreEnvio")})
public class Envio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_envio")
    private Integer idEnvio;
    @Basic(optional = false)
    @Column(name = "nombre_envio")
    private String nombreEnvio;

    public Envio() {
    }

    public Envio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Envio(Integer idEnvio, String nombreEnvio) {
        this.idEnvio = idEnvio;
        this.nombreEnvio = nombreEnvio;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getNombreEnvio() {
        return nombreEnvio;
    }

    public void setNombreEnvio(String nombreEnvio) {
        this.nombreEnvio = nombreEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnvio != null ? idEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envio)) {
            return false;
        }
        Envio other = (Envio) object;
        if ((this.idEnvio == null && other.idEnvio != null) || (this.idEnvio != null && !this.idEnvio.equals(other.idEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Envio[ idEnvio=" + idEnvio + " ]";
    }
    
}
