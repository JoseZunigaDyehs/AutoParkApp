/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Boucher;
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
public class BoucherDAO {

    Session sesion = null;

    public BoucherDAO() {
    }

    public List<Boucher> listarBoucher() {
        List<Boucher> bouchers = null;

        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Boucher.findAll");
            bouchers = q.list();
        } catch (Exception ex) {
            Logger.getLogger(EnvioDAO.class.getName()).error(ex.getMessage());
        } finally {
            this.sesion.close();
        }

        return bouchers;
    }

    public Boucher findByIdEstacionamiento(int id) {
        Boucher boucher = null;
        this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {

            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Boucher.findByIdBoucher");
            q.setInteger("idBoucher", id);
            boucher = (Boucher) q.list().get(0);

        } catch (Exception ex) {

            Logger.getLogger(EnvioDAO.class.getName()).error(ex.getMessage());

        } finally {
            this.sesion.close();
        }
        return boucher;
    }
}
