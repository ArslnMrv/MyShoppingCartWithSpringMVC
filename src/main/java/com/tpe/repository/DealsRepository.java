package com.tpe.repository;

import com.tpe.domain.Product;
import com.tpe.domain.TodaysDeals;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DealsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<TodaysDeals> getAllDeals() {
        Session session= sessionFactory.openSession();
        List<TodaysDeals> dealsList=session.createQuery("FROM TodaysDeals",TodaysDeals.class).getResultList();

        session.close();
        return dealsList;
    }

    public void saveAll(TodaysDeals[] dealsList) {
       Session session= sessionFactory.openSession();
       if(getAllDeals().isEmpty()) {
          Transaction tx = session.beginTransaction();
          for (TodaysDeals w : dealsList) {
              session.saveOrUpdate(w);
          }
          tx.commit();
       }
        session.close();
    }
}
