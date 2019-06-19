package com.xiaojiang.sellergoods.service;

import com.xiaojiang.pojo.PageResule;
import com.xiaojiang.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**
 * @创建人:小江
 * @创建时间:2019/5/26 0026
 * @描述:品牌接口
 */
public interface BrandService {


    /**
     * 查询所有品牌代码
     * */
    List<TbBrand> findAll();


    /***
     * 查询分页数据
     */
    PageResule findPage(Integer page, Integer size, Map<Object,Object> map);

    void insertBrand(TbBrand brand);

    void batDelete(Integer[] brandids);

    void delete(Long id);

    void updateBrand(TbBrand brand);
}
