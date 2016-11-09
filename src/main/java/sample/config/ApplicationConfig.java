package sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Andrii Duplyk
 *
 */
@Configuration
// @EnableJpaRepositories("hello")
@EnableTransactionManagement
public class ApplicationConfig {

	// private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	// private static final String PROPERTY_NAME_DATABASE_PASSWORD =
	// "db.password";
	// private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	// private static final String PROPERTY_NAME_DATABASE_USERNAME =
	// "db.username";
	//
	// @Resource
	// private Environment env;
	//
	// @Bean
	// public DataSource dataSource() {
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	//
	// dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
	// dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
	// dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
	// dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
	//
	// return dataSource;
	// }
	//
	// @Bean
	// public EntityManagerFactory entityManagerFactory() {
	//
	// HibernateJpaVendorAdapter vendorAdapter = new
	// HibernateJpaVendorAdapter();
	// vendorAdapter.setGenerateDdl(true);
	//
	// LocalContainerEntityManagerFactoryBean factory = new
	// LocalContainerEntityManagerFactoryBean();
	// factory.setJpaVendorAdapter(vendorAdapter);
	// factory.setPackagesToScan("hello");
	// factory.setDataSource(dataSource());
	// factory.afterPropertiesSet();
	//
	// return factory.getObject();
	// }
	//
	// @Bean
	// public PlatformTransactionManager transactionManager() {
	//
	// JpaTransactionManager txManager = new JpaTransactionManager();
	// txManager.setEntityManagerFactory(entityManagerFactory());
	// return txManager;
	// }

}
