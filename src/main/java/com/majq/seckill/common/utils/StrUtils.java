package com.majq.seckill.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 工具类
 */
public class StrUtils {

    private static Logger logger = LoggerFactory.getLogger(StrUtils.class);

    /**
     * 将原始字符串转换为驼峰规则的字符串
     *
     * @param originalStr 原始字符串
     * @return bean 驼峰规则的字符串
     */
    public static String generatorCamelName(String originalStr) {
        if (StringUtils.isEmpty(originalStr)) {
            logger.error("originalStr can not be null!");
            return null;
        }
        String camelStr = StringUtils.capitalize(originalStr);
        if (originalStr.contains("_")) {
            String[] tempStrs = originalStr.split("_");
            StringBuffer strBuffer = new StringBuffer();
            if (null != tempStrs && tempStrs.length > 0) {
                for (int i = 0; i < tempStrs.length; i++) {
                    String tempStr = tempStrs[i];
                    strBuffer.append(StringUtils.capitalize(tempStr));
                }
                camelStr = strBuffer.toString();
            }
        }
        return camelStr;
    }
}
