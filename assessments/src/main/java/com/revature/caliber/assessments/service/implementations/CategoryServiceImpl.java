package com.revature.caliber.assessments.service.implementations;

import com.revature.caliber.assessments.beans.Category;
import com.revature.caliber.assessments.data.Facade;
import com.revature.caliber.assessments.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * The type Category service.
 */
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

    private Facade facade;

    /**
     * Sets facade.
     *
     * @param facade the facade
     */
    @Autowired
    public void setFacade(Facade facade) {
        this.facade = facade;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @SuppressWarnings("unchecked")
    public Set<Category> getAll() {
        return facade.getAllCategories();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Category getById(int id) {
        return facade.getCategoryById(id);
    }

}
