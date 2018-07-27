package com.majq.seckill.common.consts;

/**
 * 常量类
 */
public class CommonConst {

    public static final String PACKAGE_STR = "package %s;";
    public static final String IMPORT_STR = "import %s;";
    public static final String CLASS_CODE_STR = "%s\n" +
            "\n" +
            "%s\n" +
            "\n" +
            "/**\n" +
            " * Auto generated\n" +
            " */\n" +
            "public class s% {\n" +
            "%s\n" +
            "}";
    public static final String FIELD_STR = "\t/**\n" +
            "\t * %s\n" +
            "\t */\n" +
            "\tprivate %s %s;";
    public static final String GETTER_STR = "public %s %s() {\n" +
            "\t\treturn %s;\n" +
            "\t}";
    public static final String SETTER_STR = "public void %s(%s %s) {\n" +
            "\t\tthis.%s = %s;\n" +
            "\t}";
    public static final String TOSTRING_STR = "@Override\n" +
            "\tpublic String toString() {\n" +
            "\t\tfinal StringBuilder sb = new StringBuilder(\"%s{\");\n" +
            "\t\t%s\n" +
            "\t\tsb.append('}');\n" +
            "\t\treturn sb.toString();\n" +
            "\t}";
    public static final String APPENDERINTERGER_STR = "\t\tsb.append(\", %s=\").append(%s);";
    public static final String APPENDEROTHER_STR = "\t\tsb.append(\", %s='\").append(%s).append('\\'');";
    public static final String BEAN_PACKAGE_PATH = "com.majq.seckill.domain";
    public static final String IMPORT_JAVA_UTIL = "java.util.*";
    public static final String IMPORT_JAVA_SQL = "java.sql.*";
    public static String NEW_LINE = System.getProperty("line.separator");
}
