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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByIdTicket", query = "SELECT t FROM Ticket t WHERE t.idTicket = :idTicket")
    , @NamedQuery(name = "Ticket.findByPrecioTicket", query = "SELECT t FROM Ticket t WHERE t.precioTicket = :precioTicket")
    , @NamedQuery(name = "Ticket.findByEstadoTicket", query = "SELECT t FROM Ticket t WHERE t.estadoTicket = :estadoTicket")
    , @NamedQuery(name = "Ticket.findByIdBoucher", query = "SELECT t FROM Ticket t WHERE t.idBoucher = :idBoucher")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ticket")
    private Integer idTicket;
    @Basic(optional = false)
    @Column(name = "precio_ticket")
    private int precioTicket;
    @Basic(optional = false)
    @Column(name = "estado_ticket")
    private int estadoTicket;
    @Basic(optional = false)
    @Column(name = "id_boucher")
    private int idBoucher;
    @JoinColumn(name = "id_estacionamiento", referencedColumnName = "id_estacionamiento")
    @ManyToOne(optional = false)
    private Estacionamiento estacionamiento;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(Integer idTicket, int precioTicket, int estadoTicket, int idBoucher) {
        this.idTicket = idTicket;
        this.precioTicket = precioTicket;
        this.estadoTicket = estadoTicket;
        this.idBoucher = idBoucher;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public int getPrecioTicket() {
        return precioTicket;
    }

    public void setPrecioTicket(int precioTicket) {
        this.precioTicket = precioTicket;
    }

    public int getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(int estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public int getIdBoucher() {
        return idBoucher;
    }

    public void setIdBoucher(int idBoucher) {
        this.idBoucher = idBoucher;
    }

    public Estacionamiento getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(Estacionamiento estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
