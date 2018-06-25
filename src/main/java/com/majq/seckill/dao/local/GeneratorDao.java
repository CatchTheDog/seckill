package com.majq.seckill.dao.local;

import com.majq.seckill.domain.Generator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GeneratorDao {
	List<Generator> getTableStructure(@Param("tableName") String tableName);
}
