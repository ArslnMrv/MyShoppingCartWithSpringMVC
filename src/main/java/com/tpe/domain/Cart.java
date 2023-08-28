package com.tpe.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_cart")
public class Cart {
    @Id
    @Column(name="cart_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Please provide quantity")
    private Integer quantity;
    @NotNull(message = "Please provide type of cargo: STANDARTDELIVERY, FASTDELIVERY, BRANCHDELIVERY")
    private Cargo cargo;

    @NotNull
    @Embedded
    private Product product;
    @Autowired
    public Cart(Integer quantity, Cargo cargo, Product product) {
        this.quantity = quantity;
        this.cargo = cargo;
        this.product = product;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
