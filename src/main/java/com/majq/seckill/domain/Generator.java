package com.majq.seckill.domain;

/**
 * 代码自动生成器模型
 */
public class Generator {
	/**
	 * 列名
	 */
	private String columnName;
	/**
	 * 列数据类型
	 */
	private String columnType;
	/**
	 * 字段类型
	 */
	private String dataType;
	/**
	 * 字段长度
	 */
	private String characterMaximumLength;
	/**
	 * 是否为空
	 */
	private String isNullable;
	/**
	 * 默认值
	 */
	private String columnDefault;
	/**
	 * 备注
	 */
	private String columnComment;


	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getCharacterMaximumLength() {
		return characterMaximumLength;
	}

	public void setCharacterMaximumLength(String characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}

	public String getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	public String getColumnDefault() {
		return columnDefault;
	}

	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	@Override
	public String toString() {
		return "Generator{" +
				"columnName='" + columnName + '\'' +
				", columnType='" + columnType + '\'' +
				", dataType='" + dataType + '\'' +
				", characterMaximumLength='" + characterMaximumLength + '\'' +
				", isNullable='" + isNullable + '\'' +
				", columnDefault='" + columnDefault + '\'' +
				", columnComment='" + columnComment + '\'' +
				'}';
	}
}
