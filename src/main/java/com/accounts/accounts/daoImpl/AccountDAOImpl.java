package com.accounts.accounts.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accounts.accounts.dao.AccountDAO;
import com.accounts.accounts.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Session  session;
	

	public boolean addAccount(Account account) {
		System.out.println("testing.....");

		session=sessionFactory.openSession();
		Transaction transaction=null;
		try {
			System.out.println("testing");
			transaction =session.getTransaction();
			transaction.begin();
			session.saveOrUpdate(account);
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

	@Override
	public List<Account> getListOfAccount() {
		// TODO Auto-generated method stub
		List<Account> lists=new ArrayList<Account>();
		Session session =sessionFactory.openSession();
		System.out.println("Get Details");
		Transaction transaction=null;
		try {
			transaction =session.getTransaction();
			transaction.begin();
			Query query=session.createQuery(" from Account");
			lists=query.list();
			for(Account lists1:lists) {
			System.out.println("Id"+lists1.getAccountId());
			System.out.println("Name"+lists1.getName());
			System.out.println("Balance"+lists1.getBalance());
}
			
			
		}catch(HibernateException e){
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return lists;
	}


	@Override
	public List<Account> updateAccount(Long account_id, Account account) {
		
		Session session =sessionFactory.openSession();
		System.out.println("Get Updated Details");
		Transaction transaction=null;
	//	Integer UpdatedData=null;
		try {
			transaction =session.getTransaction();
			transaction.begin();
			session.update(account);
			transaction.commit();				
		}catch(HibernateException e){
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
	// TODO Auto-generated method stub
		return null;
	}

	
}
