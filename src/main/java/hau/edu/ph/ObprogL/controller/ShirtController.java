package hau.edu.ph.ObprogL.controller;

import hau.edu.ph.ObprogL.model.Shirt;
import hau.edu.ph.ObprogL.service.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShirtController {

    @Autowired
    private ShirtService shirtService;

    @GetMapping({"/shirt"})
    public String findAllShirts(Model model) {
        model.addAttribute("shirts", shirtService.findAllShirts());
        return "shirt/index";
    }

    @RequestMapping("/shirt/add")
    public String addShirtForm(Model model) {
        model.addAttribute("newShirt", new Shirt());
        return "add/index";
    }

    @PostMapping("/shirt/save")
    public String addShirt(@ModelAttribute("newShirt") Shirt shirt) {
        shirtService.addShirt(shirt);
        return "redirect:/shirt";
    }

    @RequestMapping("/shirt/edit/{id}")
    public ModelAndView updateShirt(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit/index");
        modelAndView.addObject("shirtById", shirtService.findShirt(id));
        return modelAndView;
    }

    @RequestMapping("/shirt/delete/{id}")
    public String deleteShirt(@PathVariable Integer id) {
        shirtService.deleteShirt(id);
        return "redirect:/shirt";
    }
}
