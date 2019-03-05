package cn.alibaba.yimai.service;

import cn.alibaba.yimai.domain.Brand;
import cn.alibaba.yimai.query.BrandQuery;
import cn.alibaba.yimai.util.PageList;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author hy333
 * @since 2019-02-27
 */
public interface IBrandService extends IService<Brand> {

    PageList<Brand> queryPage(BrandQuery query);

}
