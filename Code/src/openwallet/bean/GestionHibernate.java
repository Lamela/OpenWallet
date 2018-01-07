package openwallet.bean;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class GestionHibernate {
    private SessionFactory sf;
    public GestionHibernate() {
			sf = new Configuration().configure().buildSessionFactory();
    }

    public void saveHib(Object object,Class<?> cl){
			Session mySession = sf.openSession();
			Transaction myTransaction = null;
			try{
			    myTransaction = mySession.beginTransaction();
			    mySession.save(cl.cast(object));
			    mySession.getTransaction().commit();
			}catch(RuntimeException e) {
			    if (myTransaction != null) {
				myTransaction.rollback();
			    }
			    e.printStackTrace();

			}finally{
			    mySession.close();
			}
    }
    public void updateHib(Object object, Class<?> cl) {
			Transaction myTransaction = null;
			Session mySession = sf.openSession();
			try {
			    myTransaction = mySession.beginTransaction();
			    mySession.update(cl.cast(object));
			    mySession.getTransaction().commit();
			} catch (RuntimeException e) {
			    if (myTransaction != null) {
				myTransaction.rollback();
			    }
			    e.printStackTrace();
			} finally {
			    mySession.close();
			}
	}
    public void deleteHib(int myID,Class<?> cl) {
			Transaction myTransaction = null;
			Session mySession = sf.openSession();
			try{
			    myTransaction = mySession.beginTransaction();
			    Object myObjectToDelete = mySession.load(cl,new Integer(myID));
			    mySession.delete(cl.cast(myObjectToDelete));
			    myTransaction.commit();
			} catch(RuntimeException e) {
			    if(myTransaction!=null) {
				myTransaction.rollback();
			    }
			    e.printStackTrace();
			} finally {
			    //mySession.flush();
			    mySession.close();
			}
    }
    @SuppressWarnings("unchecked")
    public List<Object> getAllObjects(Class<?> cl) {
			List<Object> myListObjects = new ArrayList<Object>();
			Transaction myTransaction = null;
			Session mySession = sf.openSession();
			try {
			    myTransaction = mySession.beginTransaction();
			    myListObjects = mySession.createQuery("from "+cl.getName()).list();
			} catch(RuntimeException e) {
			    e.printStackTrace();
			} finally {
			    mySession.close();
			}
			return myListObjects;
    }
    public Object getObjectById(int myID,Class<?> cl) {
			Object obj = null;
			Transaction myTransaction = null;
			Session mySession = sf.openSession();
			try {
			    myTransaction = mySession.beginTransaction();
			    // String queryString = "from "+cl.getName()+" where patientID ="+myID;
			    // Query query = mySession.createQuery(queryString);

          obj = mySession.get(cl,myID);

			} catch (RuntimeException e) {
			    e.printStackTrace();
			} finally {
			    mySession.close();
			}
			return obj;
    }
    @SuppressWarnings("unchecked")
    public List<Object> getAllObjectsByID(int myID,Class<?> cl) {
			List<Object> myListObjects = new ArrayList<Object>();
			Transaction myTransaction = null;
			Session mySession = sf.openSession();
			try {
			    myTransaction = mySession.beginTransaction();
			    myListObjects = mySession.createQuery("from "+cl.getName()+" where id_" + cl.getName().toLowerCase()+ " = "+myID).list();
			} catch(RuntimeException e) {
			    e.printStackTrace();
			} finally {
			    mySession.close();
			}
			return myListObjects;
    }
    @SuppressWarnings("unchecked")
    public List<Object> getObjectsByName(String firstName,String lastName,Class<?> cl) {
			List<Object> myListObjects = new ArrayList<Object>();
			Transaction myTransaction = null;
			Session mySession = sf.openSession();
			try {
			    myTransaction = mySession.beginTransaction();
			    myListObjects = mySession.createQuery("from "+cl.getName()+" where firstName = '"+firstName+"' AND lastName='"+lastName+"'").list();
			} catch(RuntimeException e) {
			    e.printStackTrace();
			} finally {
			    mySession.close();
			}
			return myListObjects;
    }


    public void exitSF() {
			sf.close();
    }
}
