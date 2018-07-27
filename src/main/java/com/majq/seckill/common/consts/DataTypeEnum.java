package com.majq.seckill.common.consts;

import org.springframework.util.StringUtils;

public enum DataTypeEnum {
    MysqlInt(DbTypeEnum.Mysql, MysqlDataTypeEnum.IntegerType.getDataType(), JavaDataTypeEnum.LongType, "mysql int <--> java long"),
    MysqlTinyInt(DbTypeEnum.Mysql, MysqlDataTypeEnum.TinyIntType.getDataType(), JavaDataTypeEnum.IntegerType, "mysql tiny int <--> java integer"),
    MysqlSmallInt(DbTypeEnum.Mysql, MysqlDataTypeEnum.SmallIntType.getDataType(), JavaDataTypeEnum.IntegerType, "mysql smallint <--> java integer"),
    MysqlMediumInt(DbTypeEnum.Mysql, MysqlDataTypeEnum.MediumIntType.getDataType(), JavaDataTypeEnum.IntegerType, "mysql medium int <--> java integer"),
    MysqlBigInt(DbTypeEnum.Mysql, MysqlDataTypeEnum.BigIntType.getDataType(), JavaDataTypeEnum.BigInteger, "mysql big int <--> java big integer"),
    MysqlDouble(DbTypeEnum.Mysql, MysqlDataTypeEnum.DoubleType.getDataType(), JavaDataTypeEnum.DoubleType, "mysql double <--> java double"),
    MysqlFloat(DbTypeEnum.Mysql, MysqlDataTypeEnum.FloatType.getDataType(), JavaDataTypeEnum.FloatType, "mysql float <--> java float"),
    MysqlVarchar(DbTypeEnum.Mysql, MysqlDataTypeEnum.VarcharType.getDataType(), JavaDataTypeEnum.StringType, "mysql varchar <--> java String"),
    MysqlChar(DbTypeEnum.Mysql, MysqlDataTypeEnum.CharType.getDataType(), JavaDataTypeEnum.StringType, "mysql char <--> java String"),
    MysqlDate(DbTypeEnum.Mysql, MysqlDataTypeEnum.DateType.getDataType(), JavaDataTypeEnum.DateType, "mysql date <--> java date"),
    MysqlTime(DbTypeEnum.Mysql, MysqlDataTypeEnum.TimeType.getDataType(), JavaDataTypeEnum.TimeType, "mysql time <--> java time"),
    MysqlYear(DbTypeEnum.Mysql, MysqlDataTypeEnum.YearType.getDataType(), JavaDataTypeEnum.DateType, "mysql year <--> java date"),
    MysqlTimeStamp(DbTypeEnum.Mysql, MysqlDataTypeEnum.TimeStampType.getDataType(), JavaDataTypeEnum.TimeStampType, "mysql integer <--> java integer"),
    MysqlDateTime(DbTypeEnum.Mysql, MysqlDataTypeEnum.DateTimeType.getDataType(), JavaDataTypeEnum.TimeStampType, "mysql datetime <--> java timestamp"),
    MysqlBlob(DbTypeEnum.Mysql, MysqlDataTypeEnum.BlobType.getDataType(), JavaDataTypeEnum.ByteArrayType, "mysql blob <--> java byte []");

    /**
     * 数据库类型
     */
    private DbTypeEnum dbType;
    /**
     * 数据库数据类型
     */
    private String dbDataType;
    /**
     * java数据类型
     */
    private JavaDataTypeEnum javaDataType;
    /**
     * 描述
     */
    private String description;

    DataTypeEnum(DbTypeEnum dbType, String dbDataType, JavaDataTypeEnum javaDataType, String description) {
        this.dbType = dbType;
        this.dbDataType = dbDataType;
        this.javaDataType = javaDataType;
        this.description = description;
    }

    /**
     * 根据数据库类型和数据库字段类型获取对应的java类型
     *
     * @param dbType
     * @param dbDataType
     * @return
     */
    public static String getDataTypeByDbAndType(DbTypeEnum dbType, String dbDataType) {
        if (null != dbType && !StringUtils.isEmpty(dbDataType)) {
            DataTypeEnum[] enums = DataTypeEnum.values();
            for (DataTypeEnum dataTypeEnum : enums) {
                if (dataTypeEnum.getDbType().equals(dbType) && dataTypeEnum.getDbDataType().equals(dbDataType)) {
                    return dataTypeEnum.getJavaDataType().getDataType();
                }
            }
        }
        return "";
    }

    public DbTypeEnum getDbType() {
        return dbType;
    }

    public String getDbDataType() {
        return dbDataType;
    }

    public JavaDataTypeEnum getJavaDataType() {
        return javaDataType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DataTypeEnum{");
        sb.append("dbType=").append(dbType);
        sb.append(", dbDataType='").append(dbDataType).append('\'');
        sb.append(", javaDataType=").append(javaDataType);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
