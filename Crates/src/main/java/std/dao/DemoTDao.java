package std.dao;

import org.springframework.stereotype.Repository;
import std.dto.DemoT;

import java.util.List;
import java.util.Map;

@Repository
public interface DemoTDao {
    int deleteByPrimaryKey(Long id);

    int insert(DemoT data);

    int insertSelective(DemoT data);

    DemoT selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemoT data);

    int updateByPrimaryKey(DemoT data);

    List<Map<String, Object>> selectIndefiniteTable(List<String> columnList, String tableName);
}