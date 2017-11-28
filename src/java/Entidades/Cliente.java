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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByRutCliente", query = "SELECT c FROM Cliente c WHERE c.rutCliente = :rutCliente")
    , @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Cliente.findByTelefonoCliente", query = "SELECT c FROM Cliente c WHERE c.telefonoCliente = :telefonoCliente")
    , @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente")
    , @NamedQuery(name = "Cliente.findByIdBoucher", query = "SELECT c FROM Cliente c WHERE c.idBoucher = :idBoucher")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rut_cliente")
    private String rutCliente;
    @Basic(optional = false)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "telefono_cliente")
    private String telefonoCliente;
    @Basic(optional = false)
    @Column(name = "email_cliente")
    private String emailCliente;
    @Basic(optional = false)
    @Column(name = "id_boucher")
    private String idBoucher;

    public Cliente() {
    }

    public Cliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Cliente(String rutCliente, String nombreCliente, String telefonoCliente, String emailCliente, String idBoucher) {
        this.rutCliente = rutCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.idBoucher = idBoucher;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getIdBoucher() {
        return idBoucher;
    }

    public void setIdBoucher(String idBoucher) {
        this.idBoucher = idBoucher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutCliente != null ? rutCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rutCliente == null && other.rutCliente != null) || (this.rutCliente != null && !this.rutCliente.equals(other.rutCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cliente[ rutCliente=" + rutCliente + " ]";
    }
    
}
