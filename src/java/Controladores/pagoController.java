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
        mv.addObject("bouchers", null);
        return mv;
        
    }
    
    @RequestMapping(value = "verPagos.htm",method = RequestMethod.POST)
    public ModelAndView buscarPagos(HttpServletRequest request){
        
        ModelAndView mv = new ModelAndView("pagos");
        String rut = request.getParameter("txtRut");
        if(rut==null){
            mv.addObject("error", "Debe ingresar un rut");
            return mv;
        }else if(rut.equals("")){
            mv.addObject("error", "Debe ingresar un rut");
            return mv;
        }
        int rutCliente = Integer.parseInt(rut);
        BoucherDAO boucherDAO = new BoucherDAO();
        List<Boucher> bouchers = boucherDAO.listarPorIdCliente(rutCliente);
        if(bouchers.size()==0){
            mv.addObject("error", "No se han encontrado pagos");
            return mv;
        }
        mv.addObject("bouchers", bouchers);
        TicketDAO ticketDAO = new TicketDAO();
        mv.addObject("tickets", ticketDAO.listarTicket());
        return mv;
        
    }
    
    @RequestMapping(value = "pagar.htm",method = RequestMethod.POST)
    public ModelAndView formularioPago(HttpServletRequest request){
        //ModelAndView mv = null;
        String boton = request.getParameter("boton");
        ModelAndView mv = new ModelAndView("pagar");
        
        //BUSCAR
        if(boton.equals("buscar")){
            ClienteDAO clienteDAOBusqueda = new ClienteDAO();
            int rutBuscar = Integer.parseInt(request.getParameter("txtRut"));
            Cliente clienteEncontrado = clienteDAOBusqueda.findByRutCliente(rutBuscar);
            if(clienteEncontrado==null){
                mv.addObject("error","No se encuentra rut");
                PagoDAO pagoDAO = new PagoDAO();
                mv.addObject("pagos", pagoDAO.ListarPago());
                EnvioDAO envioDAO = new EnvioDAO();
                mv.addObject("envios", envioDAO.listarEnvio());
                EstacionamientoDAO estacionamientoDAO = new EstacionamientoDAO();
                mv.addObject("estacionamientos", estacionamientoDAO.listarEstacionamientos());
                return mv;
            }else{
                mv.addObject("cliente", clienteEncontrado);
                PagoDAO pagoDAO = new PagoDAO();
                mv.addObject("pagos", pagoDAO.ListarPago());
                EnvioDAO envioDAO = new EnvioDAO();
                mv.addObject("envios", envioDAO.listarEnvio());
                EstacionamientoDAO estacionamientoDAO = new EstacionamientoDAO();
                mv.addObject("estacionamientos", estacionamientoDAO.listarEstacionamientos());
                return mv;
            }
        }

        int rut = Integer.parseInt(request.getParameter("txtRut"));
        //CLIENTE
        Cliente cliente = crearCliente(request);
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
        
        //ESTACIONAMIENTOS
        EstacionamientoDAO estacionamientoDAO = new EstacionamientoDAO();
        mv.addObject("estacionamientos", estacionamientoDAO.listarEstacionamientos());
        int estadoTicket = Integer.parseInt(rut+"0");//EL CERO ES ESTADO GUARDADO
        TicketDAO ticketDAO = new TicketDAO();
        List<Ticket> listaEstacionamientosAgregados = ticketDAO.listarTicketPorEstado(estadoTicket);
        mv.addObject("estacionamientosTicket", listaEstacionamientosAgregados);
        
        switch (boton) {
            case "agregar":
                Estacionamiento estacionamiento = new Estacionamiento();
                int idEstacionamiento = Integer.parseInt(request.getParameter("slcEstacionamiento"));
                estacionamiento.setIdEstacionamiento(idEstacionamiento);
                //AGREGAR TICKET
                int precio = Integer.parseInt(request.getParameter("txtMonto"));
                Ticket ticket = new Ticket();
                ticket.setPrecioTicket(precio);
                ticket.setEstadoTicket(estadoTicket);
                ticket.setEstacionamiento(estacionamiento);
                
                if(!validarEstacionamiento(listaEstacionamientosAgregados,idEstacionamiento)){
                    mv.addObject("error", "Ya existe el estacionamiento agregado");
                    return mv;
                } 
                
                if(!ticketDAO.agregarTicket(ticket)){
                    mv.addObject("error","No se ha podido agregar el estacionamiento");
                }else{
                    mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(estadoTicket));
                    //CALCULAR TOTAL
                    int total = calcularTotal(ticketDAO.listarTicketPorEstado(estadoTicket));
                    mv.addObject("precioTotal", total);
                    mv.addObject("exito", "Se ha agregado el estacionamiento");
                }   break;
            case "eliminar":
                int idEstac = Integer.parseInt(request.getParameter("estacionamientoEliminar"));
                ticket = ticketDAO.buscarTicket(idEstac);
                String rutEliminar = request.getParameter("rutEliminar");
                if(ticketDAO.eliminarTicket(ticket)){
                    mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(Integer.parseInt(rutEliminar)));
                    //CALCULAR TOTAL
                    int total = calcularTotal(ticketDAO.listarTicketPorEstado(estadoTicket));
                    mv.addObject("precioTotal", total);
                    mv.addObject("exito", "Se ha eliminado el estacionamiento");
                }else{
                    mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(Integer.parseInt(rutEliminar)));
                    mv.addObject("error", "No se ha eliminado el estacionamiento");
                }   break;

            default:
                //CALCULAR TOTAL
                int total = calcularTotal(listaEstacionamientosAgregados);
                mv.addObject("precioTotal", total);


                //VALIDAR SI CLIENTE EXISTE Y WEAS
                ClienteDAO clienteDAO = new ClienteDAO();
                if(clienteDAO.findByRutCliente(cliente.getRutCliente())==null){
                    if(!clienteDAO.AgregarCliente(cliente)){
                        mv.addObject("error","No se ha podido agregar el cliente");
                        return mv;
                    }else{
                        mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(estadoTicket));
                        mv.addObject("exito", "Se ha agregado el cliente");
                        //mv.setViewName("pagos.htm");
                    };
                }

                //BOUCHER
                Boucher boucher = new Boucher();
                boucher.setEnvio(envio);
                boucher.setPago(pago);
                boucher.setTotalBoucher(total);
                boucher.setCliente(cliente);
                BoucherDAO boucherDAO = new BoucherDAO();
                if(!boucherDAO.agregarBoucher(boucher)){
                    mv.addObject("error","No se ha podido agregar el boucher");
                }else{
                    mv.addObject("estacionamientosTicket", ticketDAO.listarTicketPorEstado(estadoTicket));
                    mv.addObject("exito", "Se ha agregado el boucher");
                }
                //Modifica idBoucher y estadoTicket de los ticket agregados
                modificarListaAgregada(listaEstacionamientosAgregados,ticketDAO,boucher.getIdBoucher());
                
                mv = verBoucher(request,boucher,cliente);
                
        }


        return mv;


    }

    public ModelAndView verBoucher(HttpServletRequest request,Boucher boucher, Cliente cliente){

        ModelAndView mv = new ModelAndView("boucher");
        
        TicketDAO ticketDAO = new TicketDAO();
        List<Ticket> tickets = ticketDAO.listarTicketPorBoucher(boucher.getIdBoucher());
        EnvioDAO envioDAO = new EnvioDAO();
        Envio envio = envioDAO.findByIdEnvio(boucher.getEnvio().getIdEnvio());
        boucher.setEnvio(envio);
        mv.addObject("tickets",tickets);
        mv.addObject("boucher", boucher);
        return mv;
        
    }
    
    private int calcularTotal(List<Ticket> listaEstacionamientosAgregados) {
        int precioTotal = 0;
        for (Ticket listaEstacionamientosAgregado : listaEstacionamientosAgregados) {
            precioTotal += listaEstacionamientosAgregado.getPrecioTicket();
        }
        return precioTotal;
    }

    private boolean validarEstacionamiento(List<Ticket> listaTickets, int idEstacionamiento) {
        boolean valido = true;
        for (Ticket listaTicket : listaTickets) {
            if(listaTicket.getEstacionamiento().getIdEstacionamiento()==idEstacionamiento)
                valido = false;
        }
        return valido;
    }
    

    private Cliente crearCliente(HttpServletRequest request) {
        Cliente cliente = new Cliente();
        int rut = Integer.parseInt(request.getParameter("txtRut"));
        String nombre = request.getParameter("txtNombre");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        cliente.setEmailCliente(email);
        cliente.setNombreCliente(nombre);
        cliente.setRutCliente(rut);
        cliente.setTelefonoCliente(telefono);
        return cliente;
    }

    private void modificarListaAgregada(List<Ticket> listaEstacionamientosAgregados,TicketDAO ticketDAO, int idBoucher) {
        for (Ticket listaEstacionamientosAgregado : listaEstacionamientosAgregados) {
            listaEstacionamientosAgregado.setEstadoTicket(1);
            listaEstacionamientosAgregado.setIdBoucher(idBoucher);
            ticketDAO.modificarTicket(listaEstacionamientosAgregado);
        }
    }

}
