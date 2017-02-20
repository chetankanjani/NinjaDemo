/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import ninja.Result;
import ninja.Results;

import java.util.List;

import entity.Admin;
import entity.Book;
import entity.RentBooks;
import entity.User;
import javax.persistence.EntityManager;
import com.google.inject.*;

@Singleton
public class ApplicationController {
	
	@Inject
	Provider<EntityManager> entitiyManagerProvider;

    public Result index() {

        return Results.html();

    }
    
    public Result home() {

        return Results.html();

    }
    
    public Result helloWorldJson() {
        
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.content = "Hello World! Hello Json!";

        return Results.json().render(simplePojo);

    }
    
  public Result sample() {
        
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.content = "Hello chetan";

        return Results.json().render(simplePojo);

    }
    
    public static class SimplePojo {

        public String content;
        
    }
//    public Book getBookById(int id){
//		List<Book> l=getHibernateTemplate().find("from Book where id="+id);	
//		return l.get(0);
//	}
//	public void newBook(Book b) {
////		console.log(b);
////		getHibernateTemplate().save(b);
//		return Results.json().render(b);
//	}
//
//	public void deleteBook(Book b) {
//		getHibernateTemplate().delete(b);
//	}
//	

	public Result viewBooks() {
	    EntityManager entityManager = entitiyManagerProvider.get();
		List<Book> l=entityManager.createQuery("from Book").getResultList();		
		return Results.json().render(l);
	}
//
//	public void issueBook(RentBooks r) {
//		// TODO Auto-generated method stub
//	}
//
//	public void returnBook(RentBooks r) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void newUser(User b) {
//		getHibernateTemplate().save(b);
//	}
//
//	public void removeUser(User b) {
//		getHibernateTemplate().delete(b);
//	}
//
//	public boolean loginUser(User b) {
//		SessionFactory factory=getHibernateTemplate().getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx= session.beginTransaction();
//		Query query = session .createQuery("from User where name= :name and pass= :pass"); 
//		query.setParameter("name", b.getName());
//		query.setParameter("pass", b.getPass());
//		List<User> list = (List<User>) query.list();
//		tx.commit(); session.close(); factory.close();
//		if(list.size()>0)
//			return true;
//		return false;
//		
//	}
//
//	public boolean loginAdmin(Admin b) {
//		SessionFactory factory=getHibernateTemplate().getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		Query query = session .createQuery("from Admin where id= :id and pass= :pass"); 
//		query.setParameter("id", b.getId());
//		query.setParameter("pass", b.getPass());
//		List<User> list = (List<User>) query.list();
//		tx.commit(); session.close(); factory.close();
//		if(list.size()>0)
//			return true;
//		return false;
//	}
//
//	public void updateBookCategory(Book b, String category) {
//		SessionFactory factory=getHibernateTemplate().getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		Query query = session .createQuery("update Book set category= :cat where id= :id"); 
//		query.setParameter("cat", category);
//		query.setParameter("id", b.getId());
//		query.executeUpdate();
//		tx.commit(); session.close(); factory.close();
//		
//	}
//
//	public List<Book> viewBooksByCategory(String cat) {
//		List<Book> l=getHibernateTemplate().find("from Book where category='"+cat+"'");				
//		return l;
//	}
//
//	public List<Book> viewBooksByName(String name) {
//		List<Book> l=getHibernateTemplate().find("from Book where name='"+name+"'");				
//		return l;
//	}
//
//	public List<Book> viewBooksByAuthor(String author) {
//		List<Book> l=getHibernateTemplate().find("from Book where author='"+author+"'");				
//		return l;		
//	}
//
//	public List<User> viewUsers() {
//		List<User> l=getHibernateTemplate().find("from User");				
//		return l;
//	}
//
//	public void UpdateQuantity(Book b, int n) {
//		SessionFactory factory=getHibernateTemplate().getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		Query query = session .createQuery("update Book set qty= :n where id= :id"); 
//		query.setParameter("n", n);
//		query.setParameter("id", b.getId());
//		query.executeUpdate();
//		tx.commit(); session.close(); factory.close();
//	}
//
//	public boolean CheckBookAvailability(Book b) {
//		SessionFactory factory=getHibernateTemplate().getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		Query query = session .createQuery("from Book where id= :id"); 
//		query.setParameter("id", b.getId());
//		List<Book> list = (List<Book>) query.list();
//		int avail=list.get(0).getAvailable(); 
//		tx.commit(); session.close(); factory.close();
//		if(avail==1)
//			return true;
//		return false;
//	}
//
//	public void ChangeAvailability(Book b, int n) {
//		SessionFactory factory=getHibernateTemplate().getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		Query query = session .createQuery("update Book set availability= :n where id= :id"); 
//		query.setParameter("n", n);
//		query.setParameter("id", b.getId());
//		query.executeUpdate();
//		tx.commit(); session.close(); factory.close();
//	}

}
