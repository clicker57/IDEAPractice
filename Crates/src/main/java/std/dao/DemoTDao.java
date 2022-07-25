package std.dao;

import org.springframework.stereotype.Repository;
import std.dto.DemoT;

@Repository
public interface DemoTDao {
    int deleteByPrimaryKey(Long id);

    int insert(DemoT data);

    int insertSelective(DemoT data);

    DemoT selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemoT data);

    int updateByPrimaryKey(DemoT data);
}