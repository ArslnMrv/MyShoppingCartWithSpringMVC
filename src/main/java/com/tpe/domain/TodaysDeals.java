package com.tpe.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;

@Entity
@Table(name="t_todaysdeals")
public class TodaysDeals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="deals_id")
    private Long id;


    private Product product;

    public TodaysDeals(@Qualifier Product product) {
        this.product=product;
    }
    public TodaysDeals() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
