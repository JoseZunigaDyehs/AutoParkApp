/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ClienteDAO;
import DAO.EnvioDAO;
import DAO.EstacionamientoDAO;
import DAO.PagoDAO;
import DAO.TicketDAO;
import Entidades.Cliente;
import Entidades.Ticket;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jose.zuniga
 */
public class pagoController {
    
    @RequestMapping(value = "pagar.htm",method = RequestMethod.GET)
    public ModelAndView pagarView(HttpServletRequest request){
        
        PagoDAO pagoDAO = new PagoDAO();
        EnvioDAO envioDAO = new EnvioDAO();
        EstacionamientoDAO estacionamientoDAO = new EstacionamientoDAO();

        ModelAndView mv = new ModelAndView("pagar");
        mv.addObject("pagos", pagoDAO.ListarPago());
        mv.addObject("envios", envioDAO.listarEnvio());
        mv.addObject("estacionamientos", estacionamientoDAO.listarEstacionamientos());
        return mv;
        
    }
    
    @RequestMapping(value = "verPagos.htm",method = RequestMethod.GET)
    public ModelAndView verPagosView(HttpServletRequest request){

        ModelAndView mv = new ModelAndView("pagos");
        return mv;
        
    }
    
    @RequestMapping(value = "pagar.htm",method = RequestMethod.POST)
    public ModelAndView formularioPago(HttpServletRequest request){
        ModelAndView mv = null;
        String btn = request.getParameter("btnAgregarEstacionamiento");
        //SI btn == true => ES AGREGAR EL ESTACIONAMIENTO
        if(btn.equals("true")){
            mv = agregarEstacionamiento(request);
        }else{ //ACA SE DEBE AGREGAR EL BOUCHER Y PASAR A LA OTRA VISTA
        
        }
        return mv;
    }
    
    /**
     * Metodo que envía el cliente a la vista y agrega tickets temporalmente
     * @param request
     * @return 
     */
    public ModelAndView agregarEstacionamiento(HttpServletRequest request){

        ModelAndView mv = new ModelAndView("pagar");
        PagoDAO pagoDAO = new PagoDAO();
        mv.addObject("pagos", pagoDAO.ListarPago());
        EnvioDAO envioDAO = new EnvioDAO();
        mv.addObject("envios", envioDAO.listarEnvio());
        EstacionamientoDAO estacionamientoDAO = new EstacionamientoDAO();
        mv.addObject("estacionamientos", estacionamientoDAO.listarEstacionamientos());

        //AGREGAR CLIENTE SIN ID BOUCHER
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        Cliente cliente = new Cliente();
        cliente.setEmailCliente(email);
        cliente.setIdBoucher(null);
        cliente.setNombreCliente(nombre);
        cliente.setRutCliente(rut);
        cliente.setTelefonoCliente(telefono);
        mv.addObject("cliente",cliente);
        //Opciones de pago
        int idOpcionPago = Integer.parseInt(request.getParameter("rbOpcionesPago"));
        
        //AGREGAR TICKET
        int precio = Integer.parseInt(request.getParameter("txtMonto"));
        int idEstacionamiento = Integer.parseInt(request.getParameter("slcEstacionamiento"));
        int estadoTicket = 0;
        Ticket ticket = new Ticket();
        ticket.setPrecioTicket(precio);
        ticket.setEstadoTicket(estadoTicket);
        ticket.setIdEstacionamiento(idEstacionamiento);
        TicketDAO ticketDAO = new TicketDAO();
        
        if(!ticketDAO.agregarTicket(ticket)){
            mv.addObject("mensaje","No se ha podido agregar el estacuionamientyo");
        }else{
            mv.addObject("tickets", ticketDAO.listarTicket());
        }
        
        return mv;
    }
    
    /**
     * Metodo que agregar boucher con tickets y cliente
     * @param request
     * @return 
     */
    public ModelAndView agregarBoucher(HttpServletRequest request){

        ModelAndView mv = new ModelAndView("pagar");
        PagoDAO pagoDAO = new PagoDAO();
        mv.addObject("pagos", pagoDAO.ListarPago());
        EnvioDAO envioDAO = new EnvioDAO();
        mv.addObject("envios", envioDAO.listarEnvio());
        EstacionamientoDAO estacionamientoDAO = new EstacionamientoDAO();
        mv.addObject("estacionamientos", estacionamientoDAO.listarEstacionamientos());

        //AGREGAR CLIENTE SIN ID BOUCHER
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        Cliente cliente = new Cliente();
        cliente.setEmailCliente(email);
        cliente.setIdBoucher(null);
        cliente.setNombreCliente(nombre);
        cliente.setRutCliente(rut);
        cliente.setTelefonoCliente(telefono);
        
        String btn = request.getParameter("btnAgregarEstacionamiento");
        //SI btn == true => ES AGREGAR EL ESTACIONAMIENTO
        if(btn.equals("true")){
            mv.addObject("cliente",cliente);
        }else{ //ACA SE DEBE AGREGAR EL BOUCHER Y PASAR A LA OTRA VISTA
        
        }

        return mv;
    }
}
