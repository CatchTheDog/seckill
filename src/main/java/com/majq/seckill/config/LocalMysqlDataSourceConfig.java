package com.majq.seckill.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

import static com.majq.seckill.config.LocalMysqlDataSourceConfig.*;

/**
 * @author Mr.x
 * local mysql datasource config
 */
@Configuration
@PropertySource(value = DB_PROPERTIES_PATH)
@MapperScan(basePackages = LOCAL_BASE_PACKAGES, sqlSessionTemplateRef = LOCAL_SQLSESSION_TEMPLATEREF)
public class LocalMysqlDataSourceConfig {
	public static final String LOCAL_BASE_PACKAGES = "com.majq.seckill.dao.local";
	public static final String LOCAL_SQLSESSION_TEMPLATEREF = "local_sqlsession_templateref";
	public static final String DB_PROPERTIES_PATH = "classpath:config/db.properties";
	private final String LOCAL_MYSQL_DATASOUCE = "local_mysql_datasouce";
	private final String LOCAL_MYSQL_SQLSESSIONFACTORY = "local_mysql_sqlsessionfactory";
	private final String LOCAL_PROPERTIES_PREFIX = "spring.datasource.local";
	private final String LOCAL_MAPPER_LOCATIONS = "classpath*:com/majq/seckill/mapper/local/*.xml";
	private final String LOCAL_TRANSACTION_MANAGER = "local_transaction_manager";

	@Bean(name = LOCAL_MYSQL_DATASOUCE)
	@Primary
	@ConfigurationProperties(prefix = LOCAL_PROPERTIES_PREFIX)
	public DataSource localDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = LOCAL_TRANSACTION_MANAGER)
	@Primary
	public DataSourceTransactionManager setTransactionManager(@Qualifier(LOCAL_MYSQL_DATASOUCE) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = LOCAL_MYSQL_SQLSESSIONFACTORY)
	@Primary
	public SqlSessionFactory localSqlSessionFactory(@Qualifier(LOCAL_MYSQL_DATASOUCE) DataSource localDataSouce) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(localDataSouce);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources(LOCAL_MAPPER_LOCATIONS));
		return bean.getObject();
	}

	@Bean(name = LOCAL_SQLSESSION_TEMPLATEREF)
	@Primary
	public SqlSessionTemplate localSqlSessionTemplate(@Qualifier(LOCAL_MYSQL_SQLSESSIONFACTORY) SqlSessionFactory localFactory) {
		return new SqlSessionTemplate(localFactory);
	}
}
