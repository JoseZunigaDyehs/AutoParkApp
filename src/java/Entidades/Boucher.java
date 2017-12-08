/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jose
 */
@Entity
@Table(name = "boucher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boucher.findAll", query = "SELECT b FROM Boucher b")
    , @NamedQuery(name = "Boucher.findByIdBoucher", query = "SELECT b FROM Boucher b WHERE b.idBoucher = :idBoucher")
    , @NamedQuery(name = "Boucher.findByTotalBoucher", query = "SELECT b FROM Boucher b WHERE b.totalBoucher = :totalBoucher")})
public class Boucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_boucher")
    private Integer idBoucher;
    @Basic(optional = false)
    @Column(name = "total_boucher")
    private int totalBoucher;
    @JoinColumn(name = "id_envio", referencedColumnName = "id_envio")
    @ManyToOne(optional = false)
    private Envio envio;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
    @ManyToOne(optional = false)
    private Pago pago;
    @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket")
    @ManyToOne(optional = false)
    private Ticket ticket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boucher")
    private Collection<Cliente> clienteCollection;

    public Boucher() {
    }

    public Boucher(Integer idBoucher) {
        this.idBoucher = idBoucher;
    }

    public Boucher(Integer idBoucher, int totalBoucher) {
        this.idBoucher = idBoucher;
        this.totalBoucher = totalBoucher;
    }

    public Integer getIdBoucher() {
        return idBoucher;
    }

    public void setIdBoucher(Integer idBoucher) {
        this.idBoucher = idBoucher;
    }

    public int getTotalBoucher() {
        return totalBoucher;
    }

    public void setTotalBoucher(int totalBoucher) {
        this.totalBoucher = totalBoucher;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
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
