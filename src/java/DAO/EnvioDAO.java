/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Envio;
import Entidades.Pago;
import Util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LC1300XXXX
 */
public class EnvioDAO {
    Session sesion = null;

    public EnvioDAO() {
    }
    
    public List<Envio> listarEnvio(){
        List<Envio> envios = null;
        
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Envio.findAll");
            envios = q.list();
        } catch (Exception ex) {
            Logger.getLogger(EnvioDAO.class.getName()).error(ex.getMessage());
        }finally{
            this.sesion.close();
        }
        
        return envios;
    }
    
    public Envio findByIdEnvio(int id){
        Envio envio = null;
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            
            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Envio.findByIdEnvio");
            q.setInteger("idEnvio", id);
            envio = (Envio) q.list().get(0);
            
        } catch (Exception ex) {
            
            Logger.getLogger(EnvioDAO.class.getName()).error(ex.getMessage());
            
        }finally{
            this.sesion.close();
        }
        return envio;
    }
    
}
