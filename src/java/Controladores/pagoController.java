/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.BoucherDAO;
import DAO.ClienteDAO;
import DAO.EnvioDAO;
import DAO.EstacionamientoDAO;
import DAO.PagoDAO;
import DAO.TicketDAO;
import Entidades.Boucher;
import Entidades.Cliente;
import Entidades.Envio;
import Entidades.Estacionamiento;
import Entidades.Pago;
import Entidades.Ticket;
import java.util.List;
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
     * Metodo que envía el cliente a la vista y agrega tickets temporalmente (CON ESTADO RUT+0)
     * @param request
     * @return 
     */
    public ModelAndView agregarEstacionamiento(HttpServletRequest request){

        ModelAndView mv = new ModelAndView("pagar");
        
        //CLIENTE
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        Cliente cliente = new Cliente();
        cliente.setEmailCliente(email);
        cliente.setNombreCliente(nombre);
        cliente.setRutCliente(rut);
        cliente.setTelefonoCliente(telefono);
        mv.addObject("cliente",cliente);

        //OPCIONES DE PAGO
        int idOpcionPago = Integer.parseInt(request.getParameter("rbOpcionesPago"));
        mv.addObject("idOpcionPago",idOpcionPago);
        PagoDAO pagoDAO = new PagoDAO();
        mv.addObject("pagos", pagoDAO.ListarPago());
        
        //ID ENVIO
        int idEnvio = Integer.parseInt(request.getParameter("rbEnvio"));
        mv.addObject("idEnvio",idEnvio);
        EnvioDAO envioDAO = new EnvioDAO();
        mv.addObject("envios", envioDAO.listarEnvio());
        
        //ESTACIONAMIENTO
        Estacionamiento estacionamiento = new Estacionamiento();
        int idEstacionamiento = Integer.parseInt(request.getParameter("slcEstacionamiento"));
        estacionamiento.setIdEstacionamiento(idEstacionamiento);
        EstacionamientoDAO estacionamientoDAO = new EstacionamientoDAO();
        mv.addObject("estacionamientos", estacionamientoDAO.listarEstacionamientos());
        //VALIDAR YA AGREGÓ EL ESTACIONAMIENTO
        int estadoTicket = Integer.parseInt(rut+"0");//EL CERO ES ESTADO GUARDADO
        TicketDAO ticketDAO = new TicketDAO();
        List<Ticket> listaEstacionamientos = ticketDAO.listarTicketPorEstado(estadoTicket);
        if(!validarEstacionamiento(listaEstacionamientos,idEstacionamiento)){
            mv.addObject("estacionamientosTicket", listaEstacionamientos);
            mv.addObject("error", "Ya existe el estacionamiento agregado");
            return mv;
        }
        
        //AGREGAR TICKET
        int precio = Integer.parseInt(request.getParameter("txtMonto"));
        Ticket ticket = new Ticket();
        ticket.setPrecioTicket(precio);
        ticket.setEstadoTicket(estadoTicket);
        ticket.setEstacionamiento(estacionamiento);
        
        if(!ticketDAO.agregarTicket(ticket)){
            mv.addObject("error","No se ha podido agregar el estacionamiento");
        }else{
            mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(estadoTicket));
            mv.addObject("exito", "Se ha agregado el estacionamiento");
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
        
        //CLIENTE
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        Cliente cliente = new Cliente();
        cliente.setEmailCliente(email);
        cliente.setNombreCliente(nombre);
        cliente.setRutCliente(rut);
        cliente.setTelefonoCliente(telefono);
        mv.addObject("cliente",cliente);

        //OPCIONES DE PAGO
        int idOpcionPago = Integer.parseInt(request.getParameter("rbOpcionesPago"));
        mv.addObject("idOpcionPago",idOpcionPago);
        PagoDAO pagoDAO = new PagoDAO();
        mv.addObject("pagos", pagoDAO.ListarPago());
        Pago pago = new Pago(idOpcionPago);
        
        //ID ENVIO
        int idEnvio = Integer.parseInt(request.getParameter("rbEnvio"));
        mv.addObject("idEnvio",idEnvio);
        EnvioDAO envioDAO = new EnvioDAO();
        mv.addObject("envios", envioDAO.listarEnvio());
        Envio envio = new Envio(idEnvio);
        
        //ESTACIONAMIENTO
        Estacionamiento estacionamiento = new Estacionamiento();
        int idEstacionamiento = Integer.parseInt(request.getParameter("slcEstacionamiento"));
        estacionamiento.setIdEstacionamiento(idEstacionamiento);
        EstacionamientoDAO estacionamientoDAO = new EstacionamientoDAO();
        mv.addObject("estacionamientos", estacionamientoDAO.listarEstacionamientos());
        int estadoTicket = Integer.parseInt(rut+"0");//EL CERO ES ESTADO GUARDADO
        TicketDAO ticketDAO = new TicketDAO();
        List<Ticket> listaEstacionamientos = ticketDAO.listarTicketPorEstado(estadoTicket);
        
        //AGREGAR TICKET
        int precio = Integer.parseInt(request.getParameter("txtMonto"));
        Ticket ticket = new Ticket();
        ticket.setPrecioTicket(precio);
        ticket.setEstadoTicket(estadoTicket);
        ticket.setEstacionamiento(estacionamiento);
        
        if(!ticketDAO.agregarTicket(ticket)){
            mv.addObject("error","No se ha podido agregar el estacionamiento");
        }else{
            mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(estadoTicket));
            mv.addObject("exito", "Se ha agregado el estacionamiento");
        }
        
        //BOUCHER
        Boucher boucher = new Boucher();
        boucher.setEnvio(envio);
        boucher.setTicket(ticket);
        boucher.setPago(pago);
        boucher.setTotalBoucher(estadoTicket);
        BoucherDAO boucherDAO = new BoucherDAO();
        
        if(!boucherDAO.agregarBoucher(boucher)){
            mv.addObject("error","No se ha podido agregar el boucher");
        }else{
            mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(estadoTicket));
            mv.addObject("exito", "Se ha agregado el boucher");
            mv.setViewName("pagos.htm");
        }
        
        return mv;
    }

    private boolean validarEstacionamiento(List<Ticket> listaTickets, int idEstacionamiento) {
        boolean valido = true;
        for (Ticket listaTicket : listaTickets) {
            if(listaTicket.getEstacionamiento().getIdEstacionamiento()==idEstacionamiento)
                valido = false;
        }
        return valido;
    }
    
    @RequestMapping(value = "pagar.htm",method = RequestMethod.GET, params = {"eliminar", "rut"})
    public ModelAndView eliminarEstacionamiento(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("pagar");
        int idEstacionamiento = Integer.parseInt(request.getParameter("eliminar"));
        int rut = Integer.parseInt(request.getParameter("rut"));
        
        TicketDAO ticketDAO = new TicketDAO();
        Ticket ticket = ticketDAO.buscarTicket(idEstacionamiento);
        if(ticketDAO.eliminarTicket(ticket)){
            mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(rut));
            mv.addObject("exito", "Se ha eliminado el estacionamiento");
        }else{
            mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(rut));
            mv.addObject("error", "No se ha eliminado el estacionamiento");
        }
        
        return mv;
        
    }

}
