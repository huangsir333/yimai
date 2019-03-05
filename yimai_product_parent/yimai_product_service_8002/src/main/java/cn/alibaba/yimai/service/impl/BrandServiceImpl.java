package cn.alibaba.yimai.service.impl;

import cn.alibaba.yimai.domain.Brand;
import cn.alibaba.yimai.mapper.BrandMapper;
import cn.alibaba.yimai.query.BrandQuery;
import cn.alibaba.yimai.service.IBrandService;
import cn.alibaba.yimai.util.PageList;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author hy333
 * @since 2019-02-27
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
    @Autowired
    BrandMapper brandMapper;

    public PageList<Brand> queryPage(BrandQuery query) {
        PageList<Brand> pageList = new PageList<Brand>();
        //查询总条数
        long totalCount=brandMapper.queryCount(query);
        pageList.setTotal(totalCount);
        //查询总数据
        List<Brand> brands= brandMapper.queryPage(query);
        pageList.setRows(brands);
        return pageList;
    }
}
