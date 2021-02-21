package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("hello")
public class HelloController {

    @GetMapping("goodbye")
    public String goodbye() {
        return "goodbye!";
    }

    // handles request of the form /hello?name=name
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // handles request of the form /hello/name
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Michal");
        names.add("Carlos");
        names.add("Spice");
        names.add("Mr. Softy");
        model.addAttribute("names", names);
        return "hello-list";
    }

//    @GetMapping("form")
////    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String createMessage(@RequestParam String language, @RequestParam String name) {
//        if (language.equals("spanish")) {
//            return "¡Hola, " + name + "!";
//        } else if (language.equals("portuguese")) {
//            return "Olá, " + name + "!";
//        } else if (language.equals("nahuatl")) {
//            return "Panolti, " + name + "!";
//        } else if (language.equals("french")) {
//            return "Bonjour, " + name + "!";
//        } return "Hello, " + name + "!";
//    }
}
