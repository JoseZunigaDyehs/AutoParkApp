/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Ticket;
import Util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jose.zuniga
 */
public class TicketDAO {
    
    Session sesion = null;

    public TicketDAO() {
    }
    
    public boolean agregarTicket(Ticket ticket){
        boolean agregado = false;
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sesion.beginTransaction();
            sesion.save(ticket);
            tx.commit();
            agregado = true;
            
        } catch (Exception ex) {
            Logger.getLogger(TicketDAO.class.getName()).error(ex.getMessage());
        } finally {
            this.sesion.close();
        }
        Logger.getLogger(TicketDAO.class.getName()).info("Se agrego correctamente el Ticket");
        return agregado;
    }
    
    public boolean modificarTicket(Ticket ticket){
        boolean modificado = false;
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sesion.beginTransaction();
            sesion.update(ticket);
            tx.commit();
            modificado = true;
            
        } catch (Exception ex) {
            Logger.getLogger(TicketDAO.class.getName()).error(ex.getMessage());
        } finally {
            this.sesion.close();
        }
        Logger.getLogger(TicketDAO.class.getName()).info("Se modifico correctamente el Ticket");
        return modificado;
    }
    public List<Ticket> listarTicket(){
        List<Ticket> tickets = null;
        
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Ticket.findAll");
            tickets = q.list();
        } catch (Exception ex) {
            Logger.getLogger(TicketDAO.class.getName()).error(ex.getMessage());
        }finally{
            this.sesion.close();
        }
        
        return tickets;
    }
    
    public List<Ticket> listarTicketPorEstado(int estadoTicket){
        List<Ticket> tickets = null;
        
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Ticket.findByEstadoTicket");
            q.setInteger("estadoTicket", estadoTicket);
            tickets = q.list();
        } catch (Exception ex) {
            Logger.getLogger(TicketDAO.class.getName()).error(ex.getMessage());
        }finally{
            this.sesion.close();
        }
        
        return tickets;
    }
    
    public boolean eliminarTicket(Ticket ticket){
        boolean eliminado = false;
        
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sesion.beginTransaction();
            sesion.delete(ticket);
            tx.commit();
            eliminado = true;
            
        } catch (Exception ex) {
            Logger.getLogger(TicketDAO.class.getName()).error(ex.getMessage());
        }finally{
            this.sesion.close();
        }
        Logger.getLogger(TicketDAO.class.getName()).info("Se eliminó correctamente el ticket");
        return eliminado;
    }
    
    public Ticket buscarTicket(int id){
        Ticket ticket = null;
        
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Ticket.findByIdTicket");
            q.setInteger("idTicket", id);
            ticket = (Ticket) q.list().get(0);
        } catch (Exception ex) {
            Logger.getLogger(TicketDAO.class.getName()).error(ex.getMessage());
        }finally{
            this.sesion.close();
        }
        
        return ticket;
    }
}   
