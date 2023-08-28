package com.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/message")
public class Help {  // sadece müsteri hizmetleri mesajını verecek

    //http://localhost:8080/MyShoppingCart/message + GET
    @GetMapping
    public ModelAndView forHelp(){
        ModelAndView mav= new ModelAndView();
        mav.addObject("message","Hi;");
        String messagebody="Welcome to Your Shopping Home Customer Service.\n" +
                "It's good to see you among us. Thank you for supporting us as a newly developed application.  " +
                "You can quickly take care of most things here, or connect with us when needed. We wish you pleasant shopping.";
        mav.addObject("messagebody",messagebody);
        mav.setViewName("help");
        return mav;
    }
}
