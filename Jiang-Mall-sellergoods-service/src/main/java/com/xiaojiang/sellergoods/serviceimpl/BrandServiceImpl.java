package com.xiaojiang.sellergoods.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.container.page.PageHandler;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaojiang.dao.TbBrandMapper;
import com.xiaojiang.pojo.PageResule;
import com.xiaojiang.pojo.TbBrand;
import com.xiaojiang.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @创建人:小江
 * @创建时间:2019/5/26 0026
 * @描述:品牌服务类
 */

//由于我配置文件写的是 接口方式暴露服务 ,就先不用dubbo的Service注解了
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;


    @Override
    public List<TbBrand>  findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public PageResule findPage(Integer page, Integer size, Map<Object,Object> map) {
        PageHelper.startPage(page,size);
        Page<TbBrand> pages = (Page<TbBrand>) brandMapper.selectAllBrand(map);
        return new PageResule(0,"",pages.getTotal(),pages.getResult());
    }

    @Override
    public void insertBrand(TbBrand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void batDelete(Integer[] brandids) {
        brandMapper.batDelete(brandids);
    }

    @Override
    public void delete(Long id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateBrand(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

}

