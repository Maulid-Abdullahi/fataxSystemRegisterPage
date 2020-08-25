package register;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.Properties;
//
//public class DBConnection {
//    public static Connection createConnection()
//    {
//        Connection con = null;
//        String url = "jdbc:mysql://localhost:3306/customers"; //MySQL URL followed by the database name
//        String username = "root"; //MySQL username
//        String password = "root123"; //MySQL password
//        System.out.println("In DBConnection.java class ");
//
//        try
//        {
//            try
//            {
//                Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers
//            }
//            catch (ClassNotFoundException e)
//            {
//                e.printStackTrace();
//            }
//            con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
//            System.out.println("Printing connection object "+con);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return con;
//    }

public class DBConnection {
    private static SessionFactory sessionFactory;

    private static SessionFactory createSessionFactory(){


        Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/tracom?useSSL=false&serverTimezone=UTC");
            properties.setProperty(Environment.USER, "root");
            properties.setProperty(Environment.PASS, "");
            properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            properties.setProperty(Environment.SHOW_SQL, "true");
            properties.setProperty(Environment.HBM2DDL_AUTO, "update");
            properties.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            configuration.setProperties(properties);

            configuration.addAnnotatedClass(RegisterBean.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;

        }

        public static SessionFactory getSessionFactory(){
            if (sessionFactory == null)
                sessionFactory = createSessionFactory();

            return sessionFactory;
        }
    }


