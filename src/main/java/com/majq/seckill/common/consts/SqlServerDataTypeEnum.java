package com.majq.seckill.common.consts;

public enum SqlServerDataTypeEnum {
    IntType("INT"),
    VarcharType("VARCHAR"),
    CharType("CHAR"),
    NcharType("NCHAR"),
    NvarcharType("NVARCHAR"),
    TextType("TEXT"),
    NtextType("NTEXT"),
    TinyIntType("TINYINT"),
    SmallIntType("SMALLINT"),
    BitType("BIT"),
    BigIntType("BITINT"),
    FloatType("FLOAT"),
    DecimalType("DECIMAL"),
    MoneyType("MONEY"),
    SmallMoneyType("SMALLMONEY"),
    NumbericType("NUMBERIC"),
    RealType("REAL"),
    UniqueIdentifierType("UNIQUEIDENTIFIER"),
    SmallDateTimeType("SMALLDATETIME"),
    DateTimeType("DATETIME"),
    TimeStampType("TIMESTAMP"),
    BinaryType("BINARY"),
    VarbinaryType("VARBINARY"),
    ImageType("IMAGE"),
    SqlVariantType("SQL_VARIANT");

    private String dataType;

    SqlServerDataTypeEnum(String dataType) {
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
