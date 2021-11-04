package ca.gbc.comp3095.petclinic.controllers;

import ca.gbc.comp3095.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {
    private final VetService vetService;
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/" , "/index"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
