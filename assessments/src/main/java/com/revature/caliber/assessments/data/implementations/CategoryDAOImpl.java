package com.revature.caliber.assessments.data.implementations;

import com.revature.caliber.assessments.beans.Category;
import com.revature.caliber.assessments.data.CategoryDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Repository(value = "categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

    private SessionFactory sessionFactory;

    //Spring setter based DI
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public Set<Category> getAll() {
        return new HashSet<>(sessionFactory.getCurrentSession()
                .createCriteria(Category.class).list());
    }

    @Override
    public Category getById(int id) {
        return (Category) sessionFactory.getCurrentSession()
                .get(Category.class, id);
    }

}
