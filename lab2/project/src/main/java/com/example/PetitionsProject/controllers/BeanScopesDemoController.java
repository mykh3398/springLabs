package com.example.PetitionsProject.controllers;

import com.example.PetitionsProject.beans.PrototypeBean;
import com.example.PetitionsProject.beans.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeanScopesDemoController {
    @Autowired     // Ін’єкція напряму у поле
    private SingletonBean singletonBean1;
    @Autowired
    private SingletonBean singletonBean2;
    @Autowired
    private PrototypeBean prototypeBean1;
    @Autowired
    private PrototypeBean prototypeBean2;
    @GetMapping("/bean-scopes-demo")
    public String showBeanScopesDemo(Model model) {
        model.addAttribute("singletonBeanHashCode1", singletonBean1.hashCode());
        model.addAttribute("singletonBeanHashCode2", singletonBean2.hashCode());
        model.addAttribute("prototypeBeanHashCode1", prototypeBean1.hashCode());
        model.addAttribute("prototypeBeanHashCode2", prototypeBean2.hashCode());
        return "bean-scopes-demo";
    }
}

