package com.tpe.service;

import com.tpe.domain.Product;
import com.tpe.domain.TodaysDeals;
import com.tpe.repository.DealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.List;

@Service
public class DealsService {

    @Autowired
    private DealsRepository dealsRepository;
    public List<TodaysDeals> getAllDeals() {
        return dealsRepository.getAllDeals();
    }

    public void saveDeals(){
        Product product1= new Product("Mouse","Logitech","Pink");
        Product product2= new Product("Mouse","GamingMouse","Black");
        Product product3= new Product("Headset","Logitech","Black");
        Product product4= new Product("Headset","Beats","Gray");
        Product product5= new Product("Keyboard","Logitech","Gray");
        Product product6= new Product("Keyboard","Razer","Gray");

        TodaysDeals[] dealsList= new TodaysDeals[]{
        new TodaysDeals(product1),
        new TodaysDeals(product2),
        new TodaysDeals(product3),
        new TodaysDeals(product4),
        new TodaysDeals(product5),
        new TodaysDeals(product6)};
        dealsRepository.saveAll(dealsList);
    }

}
