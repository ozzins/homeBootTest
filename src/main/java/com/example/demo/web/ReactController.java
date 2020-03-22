package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
 
@Controller
@Slf4j
public class ReactController {
 
    @GetMapping("/test.do")
    public ModelAndView main(Model model) {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("pageName", "main");
        log.debug("this is test.do!!!");
        return mav;
    }
 
    @GetMapping("/{name}.do")
    public String page(@PathVariable String name, Model model) {
        model.addAttribute("pageName", name);
        return "page";
    }
}