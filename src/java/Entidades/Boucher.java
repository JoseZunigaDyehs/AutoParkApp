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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "boucher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boucher.findAll", query = "SELECT b FROM Boucher b")
    , @NamedQuery(name = "Boucher.findByIdBoucher", query = "SELECT b FROM Boucher b WHERE b.idBoucher = :idBoucher")
    , @NamedQuery(name = "Boucher.findByTotalBoucher", query = "SELECT b FROM Boucher b WHERE b.totalBoucher = :totalBoucher")
    , @NamedQuery(name = "Boucher.findByIdPago", query = "SELECT b FROM Boucher b WHERE b.idPago = :idPago")
    , @NamedQuery(name = "Boucher.findByIdEnvio", query = "SELECT b FROM Boucher b WHERE b.idEnvio = :idEnvio")
    , @NamedQuery(name = "Boucher.findByIdTicket", query = "SELECT b FROM Boucher b WHERE b.idTicket = :idTicket")})
public class Boucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_boucher")
    private Integer idBoucher;
    @Basic(optional = false)
    @Column(name = "total_boucher")
    private String totalBoucher;
    @Basic(optional = false)
    @Column(name = "id_pago")
    private int idPago;
    @Basic(optional = false)
    @Column(name = "id_envio")
    private int idEnvio;
    @Basic(optional = false)
    @Column(name = "id_ticket")
    private int idTicket;

    public Boucher() {
    }

    public Boucher(Integer idBoucher) {
        this.idBoucher = idBoucher;
    }

    public Boucher(Integer idBoucher, String totalBoucher, int idPago, int idEnvio, int idTicket) {
        this.idBoucher = idBoucher;
        this.totalBoucher = totalBoucher;
        this.idPago = idPago;
        this.idEnvio = idEnvio;
        this.idTicket = idTicket;
    }

    public Integer getIdBoucher() {
        return idBoucher;
    }

    public void setIdBoucher(Integer idBoucher) {
        this.idBoucher = idBoucher;
    }

    public String getTotalBoucher() {
        return totalBoucher;
    }

    public void setTotalBoucher(String totalBoucher) {
        this.totalBoucher = totalBoucher;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoucher != null ? idBoucher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boucher)) {
            return false;
        }
        Boucher other = (Boucher) object;
        if ((this.idBoucher == null && other.idBoucher != null) || (this.idBoucher != null && !this.idBoucher.equals(other.idBoucher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Boucher[ idBoucher=" + idBoucher + " ]";
    }
    
}
