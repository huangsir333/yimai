package cn.alibaba.yimai.service.impl;

import cn.alibaba.yimai.domain.Product;
import cn.alibaba.yimai.domain.ProductExt;
import cn.alibaba.yimai.mapper.ProductExtMapper;
import cn.alibaba.yimai.mapper.ProductMapper;
import cn.alibaba.yimai.query.ProductQuery;
import cn.alibaba.yimai.service.IProductService;
import cn.alibaba.yimai.util.PageList;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author hy333
 * @since 2019-02-27
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    ProductExtMapper productExtMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public boolean insert(Product entity) {
       boolean b= super.insert(entity);

        ProductExt productExt = entity.getProductExt();
//        设置productExt的productId
        productExt.setProductId(entity.getId());
        productExtMapper.insert(productExt);

        return b;
    }

    @Override
    public PageList<Product> queryPage(ProductQuery query) {
        PageList<Product> productPageList = new PageList<>();
        long total= productMapper.queryCount(query);
        if (total > 0) {
            productPageList.setTotal(total);
            //2:设置当前分页数据:
            // Mapper.xml中查询的是分页的数据:rows
            List<Product> products = productMapper.queryPage(query);
            productPageList.setRows(products);
        }


        return productPageList;
    }

}
