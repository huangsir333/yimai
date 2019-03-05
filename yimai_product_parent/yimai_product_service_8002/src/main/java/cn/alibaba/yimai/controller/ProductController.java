package cn.alibaba.yimai.controller;

import cn.alibaba.yimai.domain.ProductExt;
import cn.alibaba.yimai.domain.Specification;
import cn.alibaba.yimai.query.ProductQuery;
import cn.alibaba.yimai.service.IProductExtService;
import cn.alibaba.yimai.service.IProductService;
import cn.alibaba.yimai.domain.Product;
import cn.alibaba.yimai.service.ISpecificationService;
import cn.alibaba.yimai.util.AjaxResult;
import cn.alibaba.yimai.util.PageList;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ISpecificationService specificationService;

    @Autowired
    private IProductExtService productExtService;

    /**
    * 保存和修改公用的
    * @param product  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Product product){
        try {
            if(product.getId()!=null){
                productService.updateById(product);
            }else{
                productService.insert(product);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            productService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMsg("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product get(@PathVariable("id")Long id)
    {
        return productService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Product> list(){

        return productService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Product> json(@RequestBody ProductQuery query) {
        /*Page<Product> page = new Page<Product>(query.getPage(),query.getRows());
            page = productService.selectPage(page);
            return new PageList<Product>(page.getTotal(),page.getRecords());*/

        PageList<Product> productPageList = productService.queryPage(query);
        return productPageList;
    }

    @RequestMapping(value = "/viewProperties/{productTypeId}/{productId}",method = RequestMethod.GET)
    public List<Specification> viewProperties(@PathVariable("productTypeId") Long productTypeId,@PathVariable("productId")Long productId) {

        //通过前台传来的productTypeId去查出对应的productExt对象
        EntityWrapper<ProductExt> wrapper1 = new EntityWrapper<>();
        Wrapper<ProductExt> wrapper2 = wrapper1.eq("productId", productId);

        ProductExt productExt = productExtService.selectOne(wrapper2);

        if(productExt!=null&&!productExt.getViewProperties().isEmpty()){
            String viewProperties = productExt.getViewProperties();
            List<Specification> list = JSONArray.parseArray(viewProperties,Specification.class );

            return list;
        }else{
            //相当于表单没有数据就执行查询出表单的标题用于显示。
            EntityWrapper<Specification> wrapper = new EntityWrapper<>();
            wrapper.eq("product_type_id",productTypeId );
            List<Specification> list = specificationService.selectList(wrapper);
            return list;
        }

    }

    @RequestMapping(value = "/viewProperties",method = RequestMethod.POST)
    public AjaxResult saveViewProperties(@RequestBody Map<String,Object> map) {

        try {
            Object productId = map.get("productId");
            List<Specification> viewProperties = (List<Specification>) map.get("viewProperties");

            String string = JSONArray.toJSONString(viewProperties);

            ProductExt productExt = new ProductExt();
            productExt.setViewProperties(string);
            Wrapper<ProductExt> wrapper = new EntityWrapper<ProductExt>().eq("productId", productId);
            productExtService.update(productExt,wrapper );
            return  AjaxResult.me().setMsg("显示属性保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  AjaxResult.me().setMsg("显示属性保存失败"+e.getMessage()).setSuccess(false);
        }

    }

}
