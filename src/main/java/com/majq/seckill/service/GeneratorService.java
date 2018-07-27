package com.majq.seckill.service;

import com.majq.seckill.domain.BeanInfo;

public interface GeneratorService {
    /**
     * 根据表名获取表结构信息
     *
     * @param tableName
     * @return
     */
    BeanInfo getBeanInfo(String tableName);

    /**
     * 根据表结构信息生成javabean
     *
     * @param beanInfo
     * @return
     */
    boolean generaterBeanClass(BeanInfo beanInfo);

    /**
     * 根据表结构信息生成mapper
     *
     * @param beanInfo
     * @return
     */
    boolean generateMapperClass(BeanInfo beanInfo);

    /**
     * 根据表结构信息生成XML
     *
     * @param beanInfo
     * @return
     */
    boolean generateMapperXml(BeanInfo beanInfo);

}
