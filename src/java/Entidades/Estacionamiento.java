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
@Table(name = "estacionamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estacionamiento.findAll", query = "SELECT e FROM Estacionamiento e")
    , @NamedQuery(name = "Estacionamiento.findByIdEstacionamiento", query = "SELECT e FROM Estacionamiento e WHERE e.idEstacionamiento = :idEstacionamiento")
    , @NamedQuery(name = "Estacionamiento.findByNombreEstacionamiento", query = "SELECT e FROM Estacionamiento e WHERE e.nombreEstacionamiento = :nombreEstacionamiento")
    , @NamedQuery(name = "Estacionamiento.findByLongitudEstacionamiento", query = "SELECT e FROM Estacionamiento e WHERE e.longitudEstacionamiento = :longitudEstacionamiento")
    , @NamedQuery(name = "Estacionamiento.findByLatitudEstacionamiento", query = "SELECT e FROM Estacionamiento e WHERE e.latitudEstacionamiento = :latitudEstacionamiento")})
public class Estacionamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estacionamiento")
    private Integer idEstacionamiento;
    @Basic(optional = false)
    @Column(name = "nombre_estacionamiento")
    private String nombreEstacionamiento;
    @Basic(optional = false)
    @Column(name = "longitud_estacionamiento")
    private String longitudEstacionamiento;
    @Basic(optional = false)
    @Column(name = "latitud_estacionamiento")
    private String latitudEstacionamiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacionamiento")
    private Collection<Ticket> ticketCollection;

    public Estacionamiento() {
    }

    public Estacionamiento(Integer idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public Estacionamiento(Integer idEstacionamiento, String nombreEstacionamiento, String longitudEstacionamiento, String latitudEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
        this.nombreEstacionamiento = nombreEstacionamiento;
        this.longitudEstacionamiento = longitudEstacionamiento;
        this.latitudEstacionamiento = latitudEstacionamiento;
    }

    public Integer getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(Integer idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public String getNombreEstacionamiento() {
        return nombreEstacionamiento;
    }

    public void setNombreEstacionamiento(String nombreEstacionamiento) {
        this.nombreEstacionamiento = nombreEstacionamiento;
    }

    public String getLongitudEstacionamiento() {
        return longitudEstacionamiento;
    }

    public void setLongitudEstacionamiento(String longitudEstacionamiento) {
        this.longitudEstacionamiento = longitudEstacionamiento;
    }

    public String getLatitudEstacionamiento() {
        return latitudEstacionamiento;
    }

    public void setLatitudEstacionamiento(String latitudEstacionamiento) {
        this.latitudEstacionamiento = latitudEstacionamiento;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstacionamiento != null ? idEstacionamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacionamiento)) {
            return false;
        }
        Estacionamiento other = (Estacionamiento) object;
        if ((this.idEstacionamiento == null && other.idEstacionamiento != null) || (this.idEstacionamiento != null && !this.idEstacionamiento.equals(other.idEstacionamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estacionamiento[ idEstacionamiento=" + idEstacionamiento + " ]";
    }
    
}
