/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Estacionamiento;
import Util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author acer
 */
public class EstacionamientoDAO {
    
     Session sesion = null;

    public EstacionamientoDAO() {
    }

    public List<Estacionamiento> listarEstacionamientos(){
        List<Estacionamiento> estacionamientos = null;
        
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Estacionamiento.findAll");
            estacionamientos = q.list();
        } catch (Exception ex) {
            Logger.getLogger(EnvioDAO.class.getName()).error(ex.getMessage());
        }finally{
            this.sesion.close();
        }
        
        return estacionamientos;
    }
    
    public Estacionamiento findByIdEstacionamiento(int id){
        Estacionamiento estacionamiento = null;
        this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            
            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Estacionamiento.findByIdEstacionamiento");
            q.setInteger("idEstacionamiento", id);
            estacionamiento = (Estacionamiento) q.list().get(0);
            
        } catch (Exception ex) {
            
            Logger.getLogger(EnvioDAO.class.getName()).error(ex.getMessage());
            
        }finally{
            this.sesion.close();
        }
        return estacionamiento;
    }
    
    public boolean ModificarEstacionamiento(Estacionamiento estacionamiento) {

        boolean modificado = false;
        this.sesion = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = sesion.beginTransaction();
            sesion.update(estacionamiento);
            tx.commit();
            modificado = true;

        } catch (Exception ex) {
            Logger.getLogger(EstacionamientoDAO.class.getName()).error(ex.getMessage());
        } finally {
            this.sesion.close();

        }
        Logger.getLogger(EstacionamientoDAO.class.getName()).info("Se modificó correctamente el estacionamiento");
        return modificado;
    }
    
    public boolean EliminarEstacionamiento(Estacionamiento estacionamiento){
        boolean eliminado = false;
        
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sesion.beginTransaction();
            sesion.delete(estacionamiento);
            tx.commit();
            eliminado = true;
            
        } catch (Exception ex) {
            Logger.getLogger(EstacionamientoDAO.class.getName()).error(ex.getMessage());
        }finally{
            this.sesion.close();
        }
        Logger.getLogger(EstacionamientoDAO.class.getName()).info("Se eliminó correctamente el estacionamiento");
        return eliminado;
    }
}
