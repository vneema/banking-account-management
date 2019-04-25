package com.accounts.accounts.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accounts.accounts.dao.SecretDAO;
import com.accounts.accounts.model.Secret;

@Repository
public class SecretDAOImpl implements SecretDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session  session;

	@Override
	public boolean addRegister(Secret secret) {
		// TODO Auto-generated method stub
		
		
		session=sessionFactory.openSession();
		Transaction transaction=null;
		try {
			System.out.println("Registraion...");
			transaction =session.getTransaction();
			transaction.begin();
			session.saveOrUpdate(secret);

			transaction.commit();
			return true;
			
		}catch(HibernateException e) {

		if(transaction!=null) {
			System.out.println("Rollback the trasaction");
			transaction.rollback();
			
		}
		e.printStackTrace();
		return false;
		}finally{
			session.close();
		}
		
	}
	
	
	

}
