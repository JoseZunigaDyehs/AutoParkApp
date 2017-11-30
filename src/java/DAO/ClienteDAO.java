/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;
import Util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author acer
 */
public class ClienteDAO {

    Session sesion = null;

    public ClienteDAO() {
    }

    public Cliente findByRutCliente(int rut) {
        Cliente cliente = null;
        this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {

            Transaction tx = this.sesion.beginTransaction();
            Query q = this.sesion.getNamedQuery("Cliente.findByRutCliente");
            q.setInteger("rutCliente", rut);
            cliente = (Cliente) q.list().get(0);

        } catch (Exception ex) {

            Logger.getLogger(EnvioDAO.class.getName()).error(ex.getMessage());

        } finally {
            this.sesion.close();
        }
        return cliente;
    }

    public boolean ModificarCliente(Cliente cliente) {

        boolean modificado = false;
        this.sesion = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = sesion.beginTransaction();
            sesion.update(cliente);
            tx.commit();
            modificado = true;

        } catch (Exception ex) {
            Logger.getLogger(EstacionamientoDAO.class.getName()).error(ex.getMessage());
        } finally {
            this.sesion.close();

        }
        Logger.getLogger(EstacionamientoDAO.class.getName()).info("Se modificó correctamente el cliente");
        return modificado;
    }

    public boolean AgregarCliente(Cliente cliente) {

        boolean agregado = false;

        this.sesion = HibernateUtil.getSessionFactory().openSession();
        try {

            Transaction tx = sesion.beginTransaction();
            sesion.save(cliente);
            tx.commit();
            agregado = true;

        } catch (Exception ex) {
            Logger.getLogger(EstacionamientoDAO.class.getName()).error(ex.getMessage());
        } finally {
            this.sesion.close();

        }
        Logger.getLogger(EstacionamientoDAO.class.getName()).info("Se agrego correctamente el cliente");
        return agregado;
    }

}
