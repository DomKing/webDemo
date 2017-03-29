package org.prcode.configuation.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.prcode.utility.util.StringUtil;
import org.prcode.utility.util.exception.DESException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

/**
 * @ClassName: BusinessDatabaseConfig
 * @Date: 2017-03-29 16:12
 * @Auther: kangduo
 * @Description: (数据库连接配置, 主业务数据库)
 */
@Configuration
@MapperScan("org.prcode.basedomain.*.dao")
public class BusinessDatabaseConfig {

    private final String MAPPERXML_LOCATION = "classpath:mybatis/mapper/*.xml";

    @Autowired
    private DbConfigProperties dbConfigProperties;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() throws SQLException, DESException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dbConfigProperties.getDriveClass());
        druidDataSource.setUrl(dbConfigProperties.getBusinessUrl());
        druidDataSource.setUsername(dbConfigProperties.getBusinessUsername());
        druidDataSource.setPassword(dbConfigProperties.getBusinessPassword());
        druidDataSource.setInitialSize(dbConfigProperties.getInitialSize());
        druidDataSource.setMinIdle(dbConfigProperties.getMinIdle());
        druidDataSource.setMaxActive(dbConfigProperties.getMaxActive());
        druidDataSource.setMaxWait(dbConfigProperties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(dbConfigProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(dbConfigProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(dbConfigProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(dbConfigProperties.getTestWhileIdle());
        druidDataSource.setTestOnBorrow(dbConfigProperties.getTestOnBorrow());
        druidDataSource.setTestOnReturn(dbConfigProperties.getTestOnReturn());
        druidDataSource.setPoolPreparedStatements(dbConfigProperties.getPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(dbConfigProperties.getMaxPoolPreparedStatementPerConnectionSize());
        druidDataSource.setFilters(dbConfigProperties.getFilters());
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        //mybatis分页
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        props.setProperty("dialect", "mysql");
        props.setProperty("reasonable", "true");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("returnPageInfo", "check");
        props.setProperty("params", "count=countSql");
        pageHelper.setProperties(props);
        //添加插件
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPERXML_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

}
