package com.tpe.repository;

import com.tpe.domain.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CartRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Cart> showCart() {
      Session session= sessionFactory.openSession();
      List<Cart> cart =session.createQuery("From Cart",Cart.class).getResultList();

      session.close();
      return cart;
    }

    public void saveCart(Cart cart) {  //kaydet veya guncelle
       Session session= sessionFactory.openSession();
       Transaction tx= session.beginTransaction();
       session.saveOrUpdate(cart);

       tx.commit();
       session.close();
    }

    public Optional<Cart> findCartById(Long id) {
        Session session= sessionFactory.openSession();
        Cart foundCart= session.get(Cart.class,id);
        Optional<Cart> foundOpt= Optional.ofNullable(foundCart);
        return foundOpt;
    }

    public void deleteById(Long id) {
      Session session= sessionFactory.openSession();
      Transaction tx= session.beginTransaction();
      session.delete(session.get(Cart.class,id));

      tx.commit();
      session.close();
    }

    public void deleteAll() {
       Session session= sessionFactory.openSession();
       Transaction tx= session.beginTransaction();
       session.createQuery("DELETE FROM Cart").executeUpdate();

       tx.commit();
       session.close();
    }
}
