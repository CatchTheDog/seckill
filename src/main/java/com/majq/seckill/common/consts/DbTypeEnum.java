package com.majq.seckill.common.consts;

import org.springframework.util.StringUtils;

public enum DbTypeEnum {
    Mysql("mysql"),
    SqlServer("sqlserver"),
    Oracle("oracle");


    private String dbType;

    DbTypeEnum(String dbType) {
        this.dbType = dbType;
    }

    public static DbTypeEnum getEnumByDbType(String dbType) {
        if (!StringUtils.isEmpty(dbType)) {
            DbTypeEnum[] dbTypeEnums = DbTypeEnum.values();
            for (DbTypeEnum dbTypeEnum : dbTypeEnums) {
                if (dbTypeEnum.getDbType().equals(dbType)) {
                    return dbTypeEnum;
                }
            }
        }
        return null;
    }

    public String getDbType() {
        return dbType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DbTypeEnum{");
        sb.append("dbType='").append(dbType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
