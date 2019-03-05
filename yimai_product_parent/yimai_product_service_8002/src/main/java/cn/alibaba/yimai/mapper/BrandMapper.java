package cn.alibaba.yimai.mapper;

import cn.alibaba.yimai.domain.Brand;
import cn.alibaba.yimai.query.BrandQuery;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author hy333
 * @since 2019-02-27
 */
public interface BrandMapper extends BaseMapper<Brand> {
    //查询总条数
    long queryCount(BrandQuery query);

    //查询总数据
    List<Brand> queryPage(BrandQuery query);

    Brand all(long id);
}
