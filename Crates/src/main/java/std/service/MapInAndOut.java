package std.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import std.dao.DemoTDao;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Philip
 */
@Component
public class MapInAndOut {
    private static final Logger log = LoggerFactory.getLogger(MapInAndOut.class);

    @Resource
    private DemoTDao demoTDao;

    public void queryIndefiniteTable(String columnStr, String tableName) {
        if (!StringUtils.hasText(columnStr)) {
            log.error("Invalid param: columnStr is empty.");
            return;
        }
        List<String> columnList = Arrays.asList(columnStr.split(","));
        List<Map<String, Object>> resultList;
        resultList = demoTDao.selectIndefiniteTable(columnList, tableName);
        log.info("query result: {}", resultList);
    }

    public static void main(String[] args) {
        String column = "name,age,organization";
        String table = "demo_t";
        MapInAndOut obj = new MapInAndOut();
        obj.queryIndefiniteTable(column, table);
    }

}
