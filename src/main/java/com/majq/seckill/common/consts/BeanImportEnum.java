package com.majq.seckill.common.consts;

public enum BeanImportEnum {
    JavaUtil(CommonConst.IMPORT_JAVA_UTIL, "java.util.*导入"),
    JavaSql(CommonConst.IMPORT_JAVA_SQL, "java.sql.*导入");

    private String importContent;
    private String description;

    BeanImportEnum(String importContent, String description) {
        this.importContent = importContent;
        this.description = description;
    }

    public String getImportContent() {
        return importContent;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ImportEnum{");
        sb.append("importContent='").append(importContent).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
