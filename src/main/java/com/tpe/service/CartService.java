package com.tpe.service;

import com.tpe.domain.Cargo;
import com.tpe.domain.Cart;
import com.tpe.domain.Product;
import com.tpe.domain.TodaysDeals;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private DealsService dealsService;
    public List<Cart> showCart() {
       return cartRepository.showCart();
    }

    public void saveCart(Cart cart) {
        cartRepository.saveCart(cart);
    }

    public Cart findProductById(Long id) {
      Cart cart= cartRepository.findCartById(id).orElseThrow(()->new ResourceNotFoundException("Cart not found by id: "+id) );
      return cart;
    }

    public void deleteProduct(Long id) {
        Cart cart= findProductById(id);
        cartRepository.deleteById(cart.getId());
    }

    public void deleteAll() {
     //  if(showCart().size()>0) {  //sepette urun varsa repoya gidip silecek, aksi halde repoya gitmeycek.. controllerdeki mesajı verecek
           cartRepository.deleteAll();
     //  }
    }

    public void addTodaysDeals(Long id) {
      List<TodaysDeals> dealsList= dealsService.getAllDeals();
        Product addProduct= new Product();
        for(TodaysDeals w:dealsList ) {
            if(w.getId().equals(id)){
                addProduct.setBrand(w.getProduct().getBrand());
                addProduct.setName(w.getProduct().getName());
                addProduct.setColor(w.getProduct().getColor());
                break;
            }
        }
        saveCart(new Cart(0, Cargo.STANDARTDELIVERY,addProduct));
    }
}
