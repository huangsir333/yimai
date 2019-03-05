package cn.alibaba.yimai.mapper;

import cn.alibaba.yimai.domain.Product;
import cn.alibaba.yimai.query.ProductQuery;
import cn.alibaba.yimai.util.PageList;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品 Mapper 接口
 * </p>
 *
 * @author hy333
 * @since 2019-02-27
 */
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> queryPage(ProductQuery query);

    long queryCount(ProductQuery query);
}
