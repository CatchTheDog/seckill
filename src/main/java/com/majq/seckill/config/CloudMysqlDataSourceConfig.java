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

import static com.majq.seckill.config.CloudMysqlDataSourceConfig.*;

@Configuration
@PropertySource(value = DB_PROPERTIES_PATH)
@MapperScan(basePackages = CLOUD_BASE_PACKAGES, sqlSessionTemplateRef = CLOUD_SQLSESSION_TEMPLATEREF)
public class CloudMysqlDataSourceConfig {
	public static final String CLOUD_BASE_PACKAGES = "com.majq.seckill.dao.cloud";
	public static final String CLOUD_SQLSESSION_TEMPLATEREF = "cloud_sqlsession_templateref";
	public static final String DB_PROPERTIES_PATH = "classpath:config/db.properties";
	private final String CLOUD_MYSQL_DATASOUCE = "cloud_mysql_datasouce";
	private final String CLOUD_MYSQL_SQLSESSIONFACTORY = "cloud_mysql_sqlsessionfactory";
	private final String CLOUD_PROPERTIES_PREFIX = "spring.datasource.cloud";
	private final String CLOUD_MAPPER_LOCATIONS = "classpath*:com/majq/seckill/mapper/cloud/*.xml";
	private final String CLOUD_TRANSACTION_MANAGER = "cloud_transaction_manager";

	@Bean(name = CLOUD_MYSQL_DATASOUCE)
	@Primary
	@ConfigurationProperties(prefix = CLOUD_PROPERTIES_PREFIX)
	public DataSource CLOUDDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = CLOUD_TRANSACTION_MANAGER)
	@Primary
	public DataSourceTransactionManager setTransactionManager(@Qualifier(CLOUD_MYSQL_DATASOUCE) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = CLOUD_MYSQL_SQLSESSIONFACTORY)
	@Primary
	public SqlSessionFactory CLOUDSqlSessionFactory(@Qualifier(CLOUD_MYSQL_DATASOUCE) DataSource CLOUDDataSouce) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(CLOUDDataSouce);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources(CLOUD_MAPPER_LOCATIONS));
		return bean.getObject();
	}

	@Bean(name = CLOUD_SQLSESSION_TEMPLATEREF)
	@Primary
	public SqlSessionTemplate CLOUDSqlSessionTemplate(@Qualifier(CLOUD_MYSQL_SQLSESSIONFACTORY) SqlSessionFactory CLOUDFactory) {
		return new SqlSessionTemplate(CLOUDFactory);
	}
}
