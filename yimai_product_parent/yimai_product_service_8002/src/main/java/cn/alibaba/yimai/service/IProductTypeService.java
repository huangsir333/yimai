package cn.alibaba.yimai.service;

import cn.alibaba.yimai.domain.ProductType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author hy333
 * @since 2019-02-27
 */
public interface IProductTypeService extends IService<ProductType> {
    List<ProductType> treeData();
}
