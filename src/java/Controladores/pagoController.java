/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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
           
        ModelAndView mv = new ModelAndView("pagar");

        return mv;
    }
    
    @RequestMapping(value = "verPagos.htm",method = RequestMethod.GET)
    public ModelAndView verPagosView(HttpServletRequest request){
           
        ModelAndView mv = new ModelAndView("pagos");

        return mv;
    }
    
}
