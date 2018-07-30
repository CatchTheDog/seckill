package com.majq.seckill.domain;

import java.util.List;

public class BeanInfo {
    private String beanPackage;
    private String beanName;
    private List<BeanField> fields;

    public String getBeanPackage() {
        return beanPackage;
    }

    public void setBeanPackage(String beanPackage) {
        this.beanPackage = beanPackage;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public List<BeanField> getFields() {
        return fields;
    }

    public void setFields(List<BeanField> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BeanInfo{");
        sb.append("beanPackage='").append(beanPackage).append('\'');
        sb.append(", beanName='").append(beanName).append('\'');
        sb.append(", fields=").append(fields);
        sb.append('}');
        return sb.toString();
    }
}
