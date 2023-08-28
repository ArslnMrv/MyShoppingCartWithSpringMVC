package com.tpe.controller;

import com.tpe.domain.Product;
import com.tpe.domain.TodaysDeals;
import com.tpe.service.DealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/todaysdeals")
public class TodaysDealsController {  //sadece fırsat urunlerini listeleyecek..
    @Autowired
    private DealsService dealsService;

    //http://localhost:8080/MyShoppingCart/todaysdeals + GET
    @GetMapping
    public ModelAndView mav() {
        dealsService.saveDeals();
        List<TodaysDeals> allDeals= dealsService.getAllDeals();

        ModelAndView mav= new ModelAndView();
        mav.addObject("dealsList",allDeals);
        mav.setViewName("todaysdeals");
        return mav;
    }
}
