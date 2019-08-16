package cn.zsk.statistics.mapper;

import cn.zsk.statistics.entity.timeseries.DataPoint;
import cn.zsk.statistics.entity.timeseries.DataPointId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2019-08-16 09:58
 */
@Repository
public interface DataPointMapper extends CrudRepository<DataPoint, DataPointId> {

    List<DataPoint> findByIdAccount(String account);
}
