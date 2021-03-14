package xyz.metanarrative.spring_sandbox;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component("transactionManager")
@EnableTransactionManagement
public class TransactionManager extends HibernateTransactionManager {

    TransactionManager(SessionFactory sessionFactory){ //SessionFactory doesn't wish to autowire in any other way than in constructor
        setSessionFactory(sessionFactory);
    }

}
