package com.majq.seckill.common.consts;

public enum BeanCodeEnum {
    PackageStr(CommonConst.PACKAGE_STR, "包声明语句"),
    ImportStr(CommonConst.IMPORT_STR, "类导入语句"),
    ClassStr(CommonConst.CLASS_CODE_STR, "类声明语句"),
    FieldStr(CommonConst.FIELD_STR, "字段声明语句"),
    GetterStr(CommonConst.GETTER_STR, "getter方法语句"),
    SetterStr(CommonConst.SETTER_STR, "setter方法语句"),
    ToStringStr(CommonConst.TOSTRING_STR, "toString方法语句"),
    IntegerAppender(CommonConst.APPENDERINTERGER_STR, "toString方法中integer字段appender"),
    OTHERAppender(CommonConst.APPENDEROTHER_STR, "toString方法中其他类型字段appender"),;

    /**
     * 代码字符串
     */
    private String codeStr;
    /**
     * 代码描述
     */
    private String description;

    BeanCodeEnum(String codeStr, String description) {
        this.codeStr = codeStr;
        this.description = description;
    }

    public String getCodeStr() {
        return codeStr;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CodeEnum{");
        sb.append("codeStr='").append(codeStr).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
