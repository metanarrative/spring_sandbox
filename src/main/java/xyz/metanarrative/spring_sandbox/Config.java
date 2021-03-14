package xyz.metanarrative.spring_sandbox;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import xyz.metanarrative.spring_sandbox.entities.Album;
import xyz.metanarrative.spring_sandbox.entities.Band;
import xyz.metanarrative.spring_sandbox.entities.Festival;
import xyz.metanarrative.spring_sandbox.entities.Member;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableCaching
public class Config {

    @Autowired
    @Bean
    SessionFactory sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySetting("hibernate.format_sql", "true");
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Album.class);
        metadataSources.addAnnotatedClass(Band.class);
        metadataSources.addAnnotatedClass(Member.class);
        metadataSources.addAnnotatedClass(Festival.class);

        lsfb.setMetadataSources(metadataSources);
        lsfb.setDataSource(dataSource);

        try {
            lsfb.afterPropertiesSet();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lsfb.getObject();
    }

    @Primary
    @Bean
    @Autowired
    EntityManagerFactory entityManagerFactory(SessionFactory sessionFactory){
        return sessionFactory;
    }

}
