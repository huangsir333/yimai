import cn.alibaba.yimai.ProductApplication_8002;
import cn.alibaba.yimai.domain.Brand;
import cn.alibaba.yimai.mapper.BrandMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication_8002.class)
public class testall {
    @Autowired
    BrandMapper brandMapper;
    @Test
     public void test()throws Exception{
        Brand all = brandMapper.all(1L);
        System.out.println(all);
    }

}
