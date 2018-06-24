1.多数据源配置  结束
    需要使用 @SpringBootApplication(exclude = DataSourceAutoConfiguration.class) 排除默认数据源配置才可
2.日志配置
    logback 日志level，appender多会发生继承（从rootlogger中继承），如果继承时多次配置同一个logger,日志会重复打印，需要加入additivity="false"
3.页面配置
    使用thymeleaf，版本配置合理，使用一般配置即可；如果使用@RestController，需要使用ModelAndView;在controller方法上使用异步线程注解会导致controller无法访问到。
4.线程池配置  druid配置结束
5.连接池配置
