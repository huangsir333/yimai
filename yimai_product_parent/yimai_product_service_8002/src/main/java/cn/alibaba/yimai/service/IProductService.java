package cn.alibaba.yimai.service;

import cn.alibaba.yimai.domain.Product;
import cn.alibaba.yimai.query.ProductQuery;
import cn.alibaba.yimai.util.PageList;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author hy333
 * @since 2019-02-27
 */
public interface IProductService extends IService<Product> {

    PageList<Product> queryPage(ProductQuery query);
}
