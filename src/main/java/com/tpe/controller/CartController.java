package com.tpe.controller;

import com.tpe.domain.Cart;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {  //sepet işlemlerini yönetecek.
    @Autowired
    private CartService cartService;

    //http://localhost:8080/MyShoppingCart/cart + GET
    @GetMapping    //direk sepet listesi gösterilecek
    public ModelAndView showCart(){
        List<Cart> cartList= cartService.showCart();

        ModelAndView mav= new ModelAndView();
        mav.addObject("cart",cartList);
        mav.setViewName("cart");

        return mav;
    }

    //http://localhost:8080/MyShoppingCart/cart/new + GET
    @GetMapping("/new")   //form gösterilecek.
    public String sendForm(@ModelAttribute("cart") Cart cart){
        return "cartForm";
    }

    @PostMapping("saveCart")
    public String saveCart(@Valid @ModelAttribute Cart cart, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "cartForm";
        }
        cartService.saveCart(cart);
        return "redirect:/cart";    //http://localhost:8080/MyShoppingCart/cart
    }

    //http://localhost:8080/MyShoppingCart/cart/update/1   +GET
    @GetMapping("/update/{id}")
    public ModelAndView showForm(@PathVariable Long id){
        Cart foundCart= cartService.findProductById(id);

        ModelAndView mav= new ModelAndView();
        mav.addObject("cart",foundCart);
        mav.setViewName("cartForm");
        return mav;
    }
    @PostMapping("/update/saveCart")
    public String updatedSaveCart(@Valid @ModelAttribute Cart cart, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "cartForm";
        }
        cartService.saveCart(cart);
        return "redirect:/cart";    //http://localhost:8080/MyShoppingCart/cart
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleNotFoundException(Exception e){
        ModelAndView mav= new ModelAndView();
        mav.addObject("message",e.getMessage());
        mav.setViewName("notFound");
        return mav;
    }

    //http://localhost:8080/MyShoppingCart/cart/delete/4
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        cartService.deleteProduct(id);
        return "redirect:/cart";
    }

    @GetMapping("/confirm")
    public ModelAndView forConfirm(){
        cartService.deleteAll();
        ModelAndView mav= new ModelAndView();
        mav.addObject("messagebody","Your basket has been approved. " +
                "Price notification has been sent to your account via e-mail. " +
                "Your cart has been deleted so you can create a new cart. We wish you a nice day");
        mav.setViewName("confirm");
        return mav;
    }


   // http://localhost:8080/MyShoppingCart/cart/add/todaysdealsid  +GET
    @GetMapping("/add/{todaysdealsid}")
    public String addTodaysDeals(@PathVariable("todaysdealsid") Long id){
        cartService.addTodaysDeals(id);
        return "redirect:/cart";
    }



}
