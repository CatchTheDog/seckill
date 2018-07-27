package com.majq.seckill.common.consts;

public enum OracleDataTypeEnum {
    NumberType("NUMBER"),
    RawType("RAW"),
    BitType("BIT"),
    BlobType("BLOB"),
    CharType("CHAR"),
    ClobType("CLOB"),
    DateType("DATE"),
    DoublePrecisionType("DOUBLE PRECISION"),
    FloatType("FLOAT"),
    IntegerType("INTEGER"),
    JavaObjectType("JAVA_OBJECT"),
    LongRawType("LONG RAW"),
    LongType("LONG"),
    OtherType("OTHER"),
    RealType("REAL"),
    SmallIntType("SMALLINT"),
    TinyIntType("TINYINT"),
    VarcharType("VARCHAR");

    private String dataType;

    OracleDataTypeEnum(String dataType) {
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

