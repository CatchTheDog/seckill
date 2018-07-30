package com.majq.seckill.service.imp;

import com.majq.seckill.common.consts.*;
import com.majq.seckill.common.utils.FileUtils;
import com.majq.seckill.common.utils.StrUtils;
import com.majq.seckill.dao.local.GeneratorDao;
import com.majq.seckill.domain.BeanField;
import com.majq.seckill.domain.BeanInfo;
import com.majq.seckill.domain.Generator;
import com.majq.seckill.service.GeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratorServiceImpl implements GeneratorService {
    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(GeneratorServiceImpl.class);
    @Resource
    private GeneratorDao generatorDao;

    /**
     * 根据表名获取表结构信息
     *
     * @param tableName
     * @return
     */
    @Override
    public BeanInfo getBeanInfo(String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            logger.info("tableName can't be null!");
            return null;
        }
        List<Generator> generators = getTableInfo(tableName);
        if (!CollectionUtils.isEmpty(generators)) {
            return assembleBeanInfo(tableName, generators);
        }
        return null;
    }

    /**
     * 根据表名获取数据库表结构信息
     *
     * @param tableName
     * @return
     */
    private List<Generator> getTableInfo(String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            logger.error("the table name can not null!");
            return null;
        }
        List<Generator> generators = generatorDao.getTableStructure(tableName);
        if (CollectionUtils.isEmpty(generators)) {
            logger.error("the table :{} not exist!", tableName);
        }
        return generators;
    }

    /**
     * 通过数据库表结构信息组装BeanInfo
     *
     * @param tableName
     * @param generators
     * @return
     */
    private BeanInfo assembleBeanInfo(String tableName, List<Generator> generators) {
        if (StringUtils.isEmpty(tableName) || CollectionUtils.isEmpty(generators)) {
            logger.error("beanClassName:{},generator{} can not be null!", tableName, generators);
            return null;
        }
        BeanInfo beanInfo = new BeanInfo();
        //表名——>bean名称
        beanInfo.setBeanName(StrUtils.generatorCamelName(tableName));
        //beanInfo.setBeanPackage(getPackageDeclareStr(CommonConst.BEAN_PACKAGE_PATH));
        List<BeanField> beanFields = new ArrayList<>();
        for (Generator generator : generators) {
            BeanField beanField = new BeanField();
            beanField.setFieldName(StrUtils.generatorCamelName(generator.getColumnName())); //列名
            beanField.setFieldType(StrUtils.generatorCamelName(generator.getColumnType()));
            beanField.setDataType(StrUtils.generatorCamelName(generator.getDataType()));
            beanField.setMaxLength(StrUtils.generatorCamelName(generator.getCharacterMaximumLength()));
            beanField.setIsNullable(StrUtils.generatorCamelName(generator.getIsNullable()));
            beanField.setDefaultValue(StrUtils.generatorCamelName(generator.getColumnDefault()));
            beanField.setDescription(StrUtils.generatorCamelName(generator.getColumnComment()));
            beanFields.add(beanField);
        }
        beanInfo.setFields(beanFields);
        return beanInfo;
    }


    /**
     * 根据表结构信息生成javabean
     *
     * @param beanInfo
     * @return
     */
    @Override
    public boolean generaterBeanClass(BeanInfo beanInfo) {
        if (null == beanInfo) {
            logger.error("beanInfo cannot be null !");
            return false;
        }
        String classStr = getBeanClassCodeStr(beanInfo);
        //生成文件
        return FileUtils.writeContentToFile(getPathByBeanInfo(beanInfo), classStr);
    }

    /**
     * 根据beanInfo获取类文件存储路径
     *
     * @param beanInfo
     * @return
     */
    private String getPathByBeanInfo(BeanInfo beanInfo) {
        StringBuffer path = new StringBuffer();
        if (null != beanInfo && StringUtils.isEmpty(beanInfo.getBeanName()) && StringUtils.isEmpty(beanInfo.getBeanPackage())) {
            path.append(beanInfo.getBeanPackage()).append(".").append(beanInfo.getBeanName());
        }
        return convertPackageToPath(path.toString());
    }

    /**
     * 将包路径转换为磁盘路径
     *
     * @param packagePath
     * @return
     */
    private String convertPackageToPath(String packagePath) {
        if (!StringUtils.isEmpty(packagePath)) {
            return packagePath.replaceAll("\\.", File.separator);
        }
        return "";
    }

    /**
     * 获取bean类代码
     *
     * @param beanInfo
     * @return
     */
    private String getBeanClassCodeStr(BeanInfo beanInfo) {
        if (null == beanInfo) {
            logger.error("beanInfo cannot be null !");
            return "";
        }
        //包声明
        String packageStr = getPackageDeclareStr(CommonConst.BEAN_PACKAGE_PATH, BeanCodeEnum.PackageStr.getCodeStr());
        //import 语句
        String importStr = getImportStr(BeanImportEnum.class);
        //字段声明，getset,toString
        String otherStr = getBeanOtherStr(beanInfo);
        //类
        return String.format(BeanCodeEnum.ClassStr.getCodeStr(), packageStr, importStr, otherStr);
    }

    /**
     * 生成包声明语句
     *
     * @param packagePath
     * @return
     */
    private String getPackageDeclareStr(String packagePath, String packageStr) {
        if (StringUtils.isEmpty(packagePath) || StringUtils.isEmpty(packageStr)) {
            logger.error("packagePath can not be null!");
            return "";
        }
        return String.format(packageStr, packagePath) + CommonConst.NEW_LINE;
    }

    /**
     * 生成import语句
     *
     * @param enumClass 对应导入枚举类
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private <T> String getImportStr(Class<T> enumClass) {
        if (null == enumClass) {
            logger.error("enumClass can not be null!");
            return "";
        }
        StringBuffer codeStr = new StringBuffer();
        try {
            T[] importEnums = enumClass.getEnumConstants();
            Method getImportContent = enumClass.getMethod("getImportContent");
            for (T importEnum : importEnums) {
                codeStr.append(String.format(BeanCodeEnum.ImportStr.getCodeStr(), getImportContent.invoke(importEnum))).append(CommonConst.NEW_LINE);
            }
        } catch (Exception e) {
            logger.error("generate import code str error:{}!", e.getCause());
        }
        return codeStr.toString();
    }

    /**
     * 获取其他信息代码
     *
     * @param beanInfo
     * @return
     */
    private String getBeanOtherStr(BeanInfo beanInfo) {
        if (null == beanInfo) {
            logger.error("beanInfo can not be null!");
            return "";
        }
        StringBuffer fieldStr = new StringBuffer();
        StringBuffer gsetterStr = new StringBuffer();
        StringBuffer toStringSubStr = new StringBuffer();
        List<BeanField> beanFields = beanInfo.getFields();
        String beanName = beanInfo.getBeanName();
        String dbType = "";
        if (!CollectionUtils.isEmpty(beanFields)) {
            for (BeanField beanField : beanFields) {
                if (null != beanField) {
                    String fieldName = StrUtils.generatorCamelName(beanField.getFieldName());
                    String fieldDataType = DataTypeEnum.getDataTypeByDbAndType(DbTypeEnum.getEnumByDbType(dbType), beanField.getDataType());
                    String fieldComment = beanField.getDescription();
                    //字段
                    fieldStr.append(getBeanFieldStr(fieldName, fieldDataType, fieldComment));
                    //getset
                    gsetterStr.append(getGsetterStr(fieldName, fieldDataType));
                    //toString
                    toStringSubStr.append(getToStringStr(fieldName, fieldDataType));
                }
            }
        }
        String toStringStr = String.format(BeanCodeEnum.ToStringStr.getCodeStr(), beanName, toStringSubStr) + CommonConst.NEW_LINE;
        return fieldStr.append(gsetterStr).append(toStringStr).toString();
    }

    /**
     * 获取字段
     *
     * @param fieldName
     * @param fieldDataType
     * @param fieldComment
     * @return
     */
    private String getBeanFieldStr(String fieldName, String fieldDataType, String fieldComment) {
        if (!StringUtils.isEmpty(fieldName) && StringUtils.isEmpty(fieldDataType)) {
            return String.format(BeanCodeEnum.FieldStr.getCodeStr(), fieldComment, fieldDataType, fieldName) + CommonConst.NEW_LINE;
        }
        return "";
    }


    /**
     * 获取get set 方法
     *
     * @param fieldName
     * @param fieldDataType
     * @return
     */
    private String getGsetterStr(String fieldName, String fieldDataType) {
        if (!StringUtils.isEmpty(fieldName) && StringUtils.isEmpty(fieldDataType)) {
            StringBuffer gsetterStr = new StringBuffer();
            String getterName = "get" + StringUtils.capitalize(fieldName);
            String setterName = "set" + StringUtils.capitalize(fieldName);
            gsetterStr.append(String.format(BeanCodeEnum.GetterStr.getCodeStr(), fieldDataType, getterName, fieldName)).append(CommonConst.NEW_LINE);
            gsetterStr.append(String.format(BeanCodeEnum.SetterStr.getCodeStr(), setterName, fieldDataType, fieldName, fieldName, fieldName)).append(CommonConst.NEW_LINE);
            return gsetterStr.toString();
        }
        return "";
    }

    /**
     * 生成toString方法代码
     *
     * @param fieldName
     * @param fieldDataType
     * @return
     */
    private String getToStringStr(String fieldName, String fieldDataType) {
        if (!StringUtils.isEmpty(fieldName) && StringUtils.isEmpty(fieldDataType)) {
            if (fieldDataType.equals(JavaDataTypeEnum.IntegerType.getDataType()))
                return String.format(BeanCodeEnum.IntegerAppender.getCodeStr(), fieldName, fieldName);
            else return String.format(BeanCodeEnum.OTHERAppender.getCodeStr(), fieldName, fieldName);
        }
        return "";
    }

    /**
     * 根据表结构信息生成mapper
     *
     * @param beanInfo
     * @return
     */
    @Override
    public boolean generateMapperClass(BeanInfo beanInfo) {
        if (null != beanInfo) {
            String daoClassStr = getMapperClassStr(beanInfo);
            return FileUtils.writeContentToFile(getPathByBeanInfo(beanInfo), daoClassStr);
        }
        return false;
    }

    /**
     * 获取Mapper 类代码
     *
     * @param beanInfo
     * @return
     */
    private String getMapperClassStr(BeanInfo beanInfo) {
        if (null != beanInfo) {
            String packageStr = getPackageDeclareStr(CommonConst.DAO_PACKAGE_PATH, DaoCodeEnum.PackageCodeStr.getCodeStr());
            String importStr = getImportStr(DaoImportEnum.class);
            String methodStr = getMethodStr();
            return String.format(DaoCodeEnum.InterfaceCodeStr.getCodeStr(), packageStr, importStr, methodStr);
        }
        return "";
    }

    /**
     * 获取方法声明
     *
     * @return
     */
    private String getMethodStr() {
        return "";
    }

    /**
     * 根据表结构信息生成XML
     *
     * @param beanInfo
     * @return
     */
    @Override
    public boolean generateMapperXml(BeanInfo beanInfo) {
        return false;
    }
}
