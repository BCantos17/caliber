package com.revature.caliber.data.implementations;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.caliber.training.beans.Tier;
import com.revature.caliber.training.beans.Trainer;
import com.revature.caliber.training.data.TierDAO;

public class TierDAOImplementationTest {
	private static ApplicationContext context;	
	
    @BeforeClass
    public static void preClass () {
        context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
    }
    
    @Test
    public void createTierTest() {
    	
    	short id = 3;
    	short rank = 3;
    	TierDAO tDao = (TierDAO) context.getBean(TierDAO.class);
        Tier tier = new Tier();
        
        tier.setTierId(id);
        tier.setTier("VP");
        tier.setRanking(rank);
        
        tDao.createTier(tier);
        
        assertNotNull(tier);
       
    }
    
    @Test
    public void getTierByIdTest(){
    	
    	short num = 1;
        TierDAO tDAO = (TierDAO) context.getBean(TierDAO.class);

        Tier tier = tDAO.getTier(num);
        
        assertNotNull(tier);
    }
    
    @Test
    public void getTierByNameTest(){
    	
        TierDAO tDAO = (TierDAO) context.getBean(TierDAO.class);
        Tier tier = tDAO.getTier("VP");
        
        assertNotNull(tier);
    }
    
    @Test
    public void getAllTiers() {
    	TierDAO tDAO = (TierDAO) context.getBean(TierDAO.class);
    	List<Tier> tiers;
    	
    	tiers = tDAO.getAllTiers();
    	
    	assertNotNull(tiers);
    }
    
    @Test
    public void getTrainersInTierTest() {
    	short num = 1;
    	
    	TierDAO tDao = (TierDAO) context.getBean(TierDAO.class);
        List<Trainer> trainers = tDao.getTrainersInTier(num);
        
        assertNotNull(trainers);
        assertNotEquals(0, trainers.size());
    }
    
    @Test
    public void deleteTier() {
    	TierDAO tDAO = (TierDAO) context.getBean(TierDAO.class);
    
    	Tier tier = tDAO.getTier("VP");
    	assertNotNull(tier);
    	
    	short id = tier.getTierId();
    	tDAO.deleteTier(tier);
    	
    	tier = tDAO.getTier(id);
    	assertNull(tier);
    }   
    
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
