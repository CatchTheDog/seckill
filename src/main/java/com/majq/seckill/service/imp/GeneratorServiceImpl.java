package com.majq.seckill.service.imp;

import com.majq.seckill.dao.local.GeneratorDao;
import com.majq.seckill.domain.Generator;
import com.majq.seckill.service.GeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratorServiceImpl implements GeneratorService {
	private static Logger logger = LoggerFactory.getLogger(GeneratorServiceImpl.class);
	@Resource
	private GeneratorDao generatorDao;

	public static void main(String[] args) {
		String filedStr = "\tprivate %s %s;\n";
		String getStr = "public %s get%s() {\n" +
				"\t\treturn %s;\n" +
				"\t}";
		String setStr = "public void set%s(%s %s) {\n" +
				"\t\tthis.%s = %s;\n" +
				"\t}";

		String name = "Id";
		System.out.println(String.format(filedStr, name, name));
		System.out.println(String.format(getStr, name, name, name));
		System.out.println(String.format(setStr, name, name, name, name, name));
	}
	//使用字符串格式化设置各个文件模板，然后依据表结构自动生成模板填充内容
	//生成文件内容字符串后，直接将字符串写入到本地文件中；

	@Override
	public void generateMapperCode(String tableName) {
		if (StringUtils.isEmpty(tableName)) {
			logger.error("the table name can not null!");
			return;
		}
		List<Generator> generator = generatorDao.getTableStructure(tableName);
		if (null == generator) {
			logger.error("the table :{} not exist!", tableName);
		}
		StringBuffer beanClassName = new StringBuffer(generatorCamelName(tableName));
		StringBuffer daoClassName = beanClassName.append("Dao");
		//生成java文件 bean,dao
		//生成xml文件
	}

	/**
	 * 依据数据库表结构生成javabean
	 *
	 * @param beanClassName beanClass名称
	 * @param generators    数据库表结构bean
	 * @return 生成文件是否成功 true:成功，false:失败
	 */
	private boolean generatorBean(String beanClassName, List<Generator> generators) {
		if (StringUtils.isEmpty(beanClassName) || CollectionUtils.isEmpty(generators)) {
			logger.error("beanClassName:{},generator{} can not be null!", beanClassName, generators);
			return false;
		}
		List<String> filedNames = new ArrayList<>();
		String filedStr = "\tprivate %s %s;\n";
		String getStr = "public %s get%s() {\n" +
				"\t\treturn %s;\n" +
				"\t}";
		String setStr = "public void set%s(%s %s) {\n" +
				"\t\tthis.%s = %s;\n" +
				"\t}";
		String toStringstr = "";
		String commentStr = "";
		for (Generator generator : generators) {
			String columnName = generator.getColumnName(); //列名
			String columnType = generator.getColumnType();
			String dataType = generator.getDataType();
			String characterMaximumLength = generator.getCharacterMaximumLength();
			String isNullable = generator.getIsNullable();
			String columnDefault = generator.getColumnDefault();
			String columnComment = generator.getColumnComment();

			String filedName = generatorCamelName(columnName);
		}
		return false;
	}

	/**
	 * 将原始字符串转换为驼峰规则的字符串
	 *
	 * @param originalStr 原始字符串
	 * @return bean 驼峰规则的字符串
	 */
	private String generatorCamelName(String originalStr) {
		if (StringUtils.isEmpty(originalStr)) {
			logger.error("originalStr can not be null!");
			return null;
		}
		String finalStr = StringUtils.capitalize(originalStr);
		boolean isContainUnderline = originalStr.contains("_");
		if (isContainUnderline) {
			String[] tempStrs = originalStr.split("_");
			StringBuffer strBuffer = new StringBuffer();
			if (null != tempStrs && tempStrs.length > 0) {
				for (int i = 0; i < tempStrs.length; i++) {
					String tempStr = tempStrs[i];
					strBuffer.append(StringUtils.capitalize(tempStr));
				}
				finalStr = strBuffer.toString();
			}
		}
		return finalStr;
	}


	/**
	 * 依据数据库表生成dao
	 *
	 * @param generator 数据库表结构
	 * @return 生成DAO是否成功 true:成功 false:失败
	 */
	private boolean generatorDao(List<Generator> generator) {
		return false;
	}

	/**
	 * 依据数据库表结构生成XML文件
	 *
	 * @param generator 数据库表结构bean
	 * @return 生成XML文件是否成功 true:成功 false:失败
	 */
	private boolean generatorXML(List<Generator> generator) {
		return false;
	}

	/**
	 * 将生成的文件写入到本地文件中
	 *
	 * @param path    需要写入的文件路径
	 * @param content 需要写入的内容
	 * @return 写入是否成功 true:成功  false:失败
	 */
	private boolean writeFile(String path, String fileName, String content) {
		return false;
	}
}
