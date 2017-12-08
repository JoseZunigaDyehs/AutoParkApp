/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.BoucherDAO;
import DAO.EnvioDAO;
import DAO.TicketDAO;
import Entidades.Boucher;
import Entidades.Envio;
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
public class boucherController {
    
    @RequestMapping(value = "boucher.htm",method = RequestMethod.GET,params = "boucher")
    public ModelAndView pagarView(HttpServletRequest request){
        
        int boucherId = Integer.parseInt(request.getParameter("boucher"));
        ModelAndView mv = new ModelAndView("boucher");
        BoucherDAO boucherDAO = new BoucherDAO();
        Boucher boucher = boucherDAO.findByIdEstacionamiento(boucherId);
        TicketDAO ticketDAO = new TicketDAO();
        List<Ticket> tickets = ticketDAO.listarTicketPorBoucher(boucher.getIdBoucher());
        EnvioDAO envioDAO = new EnvioDAO();
        Envio envio = envioDAO.findByIdEnvio(boucher.getEnvio().getIdEnvio());
        boucher.setEnvio(envio);
        mv.addObject("tickets",tickets);
        mv.addObject("boucher", boucher);
        return mv;
    }
    
}
