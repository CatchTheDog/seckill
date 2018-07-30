package com.majq.seckill.common.consts;

/**
 * Dao 代码枚举类
 */
public enum DaoCodeEnum {
    InterfaceCodeStr(CommonConst.INTERFACE_STR, "接口声明语句"),
    PackageCodeStr(CommonConst.PACKAGE_STR, "包声明语句"),
    ImportCodeStr(CommonConst.IMPORT_STR, "包导入语句");

    private String codeStr;
    private String description;

    DaoCodeEnum(String codeStr, String description) {
        this.codeStr = codeStr;
        this.description = description;
    }

    public String getCodeStr() {
        return codeStr;
    }

    public void setCodeStr(String codeStr) {
        this.codeStr = codeStr;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DaoCodeEnum{");
        sb.append("codeStr='").append(codeStr).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
