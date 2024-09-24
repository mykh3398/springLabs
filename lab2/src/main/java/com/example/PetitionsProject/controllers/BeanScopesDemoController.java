package com.example.PetitionsProject.controllers;

import com.example.PetitionsProject.beans.PrototypeBean;
import com.example.PetitionsProject.beans.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeanScopesDemoController {
    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private PrototypeBean prototypeBean;

    @GetMapping("/bean-scopes-demo")
    public String showBeanScopesDemo(Model model) {
        model.addAttribute("singletonBeanHashCode", singletonBean.hashCode());
        model.addAttribute("prototypeBeanHashCode", prototypeBean.hashCode());
        return "bean-scopes-demo";
    }
}
