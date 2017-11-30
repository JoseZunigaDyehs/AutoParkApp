/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Pago;
import Util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LC1300XXXX
 */
public class PagoDAO {

    private Session sesion = null;

    public PagoDAO() {
    }

    /**
     * *
     * Lista Todos los pago (SELECT * )
     *
     * @return
     */
    public List ListarPago() {

        List<Pago> pagos = null;
        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {

            Transaction tx = sesion.beginTransaction();
            Query q = sesion.getNamedQuery("Pago.findAll");

            pagos = q.list();

        } catch (Exception ex) {
            Logger.getLogger(PagoDAO.class.getName()).error(ex.getMessage());
        } finally {
            sesion.close();
        }

        return pagos;
    }

}
