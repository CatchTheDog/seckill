package com.majq.seckill.common.consts;

public enum MysqlDataTypeEnum {
    IntegerType("INTEGER"),
    TinyIntType("TINYINT"),
    UnknownType("UNKNOWN"),
    SmallIntType("SMALLINT"),
    MediumIntType("MEDIUMINT"),
    BigIntType("BIGINT"),
    DoubleType("DOUBLE"),
    FloatType("FLOAT"),
    VarcharType("VARCHAR"),
    CharType("CHAR"),
    DateType("DATE"),
    TimeType("TIME"),
    YearType("YEAR"),
    TimeStampType("TIMESTAMP"),
    DateTimeType("DATETIME"),
    TinyBlobType("TINYBLOB"),
    BlobType("BLOB"),
    MediumBlobType("MEDIUMBLOB"),
    TextType("TEXT"),;

    private String dataType;

    MysqlDataTypeEnum(String dataType) {
        this.dataType = dataType;
    }


    public String getDataType() {
        return dataType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OracleDataTypeEnum{");
        sb.append("dataType='").append(dataType).append('\'');
        sb.append('}');
        return sb.toString();
    }

}

