package cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t02.n01.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorWeb {

    @Autowired
    JuegoDadosController juegoDadosController;

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView mav=new ModelAndView();
        mav.setViewName("index");
        return mav;

    }

    @RequestMapping(value = "/registro")
    public ModelAndView registro() {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("registro");
        return mav;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("inicioSesion");
        return mav;
    }
}
