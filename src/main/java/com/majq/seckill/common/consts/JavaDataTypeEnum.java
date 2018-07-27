package com.majq.seckill.common.consts;

public enum JavaDataTypeEnum {
    LongType(" Long "),
    ByteArrayType(" byte [] "),
    BooleanType(" Boolean "),
    StringType(" String "),
    DateType(" Date "),
    BigDecimalType(" BigDecimal "),
    DoubleType(" Double "),
    IntegerType(" Integer "),
    ObjectType(" Object "),
    FloatType(" Float "),
    TimeType(" Time "),
    TimeStampType(" TimeStamp "),
    BigInteger(" BigInteger ");

    private String dataType;

    JavaDataTypeEnum(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JavaDataTypeEnum{");
        sb.append("dataType='").append(dataType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
