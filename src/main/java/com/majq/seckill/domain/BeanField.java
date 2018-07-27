package com.majq.seckill.domain;

/**
 * 字段bean
 */
public class BeanField {
    private String fieldName;
    private String fieldType;
    private String dataType;
    private String maxLength;
    private String isNullable;
    private String defaultValue;
    private String description;


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BeanField{");
        sb.append("fieldName='").append(fieldName).append('\'');
        sb.append(", fieldType='").append(fieldType).append('\'');
        sb.append(", dataType='").append(dataType).append('\'');
        sb.append(", maxLength='").append(maxLength).append('\'');
        sb.append(", isNullable='").append(isNullable).append('\'');
        sb.append(", defaultValue='").append(defaultValue).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
