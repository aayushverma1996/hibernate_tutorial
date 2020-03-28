
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Data_operations {

    SessionFactory factory;
    Transaction tx;

    public void generate_data()
    {
        factory= new Configuration().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session s = factory.openSession();
        Employee[] e = new Employee[21];
        tx=null;
        try {
            tx=s.beginTransaction();

            //creating data for database

            for (int i = 1; i <= 20; i++)
            {

                e[i] = new Employee();
                e[i].setId(i);
                e[i].setName("user"+i);
                double val=Math.random()*100;
                System.out.println(val);
                e[i].setSalary(val);
                s.save(e[i]);

                //-----this is for large/bulk insert operation and 20 here is the batch size
//                if( i % 20 == 0 ) {
//                    s.flush();
//                    s.clear();
//                }

            }

            tx.commit();
        } catch (Exception h) {
            if (tx != null)
                tx.rollback();
            h.printStackTrace();
        } finally {
            System.out.println("successfully saved");
            factory.close();
            s.close();
        }
    }

    public void print_data()
    {
        factory= new Configuration().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session s=factory.openSession();
        tx=null;

        try{

            tx=s.beginTransaction();
            String hql= "FROM Employee ";
            Query q=s.createQuery(hql);
            List result = q.list();

            for(int i=0;i<result.size();i++)
            {
                System.out.println(result.get(i));
            }
        }catch(HibernateException h)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
            h.printStackTrace();
        }
        finally{
            s.close();
        }

    }

    public void update_data_byname(String name,String new_name)
    {
        factory= new Configuration().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session s=factory.openSession();
        tx=null;
        try{

            tx=s.beginTransaction();
            String hql= "UPDATE Employee set name =:newname where name =:oldname";
            Query q=s.createQuery(hql);
            q.setParameter("newname",new_name);
            q.setParameter("oldname",name);
            int res=q.executeUpdate();
            System.out.println(res);

        }catch(HibernateException h)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
            h.printStackTrace();
        }
        finally{
            s.close();
            factory.close();
        }
    }

    public void delete_byname(String old_name)
    {
        factory= new Configuration().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session s=factory.openSession();
        tx=null;
        try{

            tx=s.beginTransaction();
            String hql= "DELETE from Employee where name =:oldname";
            Query q=s.createQuery(hql);
            q.setParameter("oldname",old_name);
            int res=q.executeUpdate();
            System.out.println(res);

        }catch(HibernateException h)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
            h.printStackTrace();
        }
        finally{
            s.close();
            factory.close();
        }
    }



}
