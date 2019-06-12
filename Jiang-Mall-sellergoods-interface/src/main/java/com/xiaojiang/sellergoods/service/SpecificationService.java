package com.xiaojiang.sellergoods.service;

import com.xiaojiang.pojo.SpecificationResult;
import com.xiaojiang.pojo.TbSpecification;
import com.xiaojiang.pojo.TbSpecificationOption;

import java.util.List;

/**
 * @创建人:小江
 * @创建时间:2019/6/8 0008
 * @描述:规格接口
 */
public interface SpecificationService {

    List<TbSpecification> getAllGuige();

    List<TbSpecificationOption> getAllGuigeOption();

    void insertSpec(TbSpecification tbSpecification,String[] attSpecofocation);

    void deleteByid(Long id);

    void deleteAttribute(Long id);

    void updateSpec(TbSpecification tbSpecification, String[] attSpecofocation);

    void updateSpecAndAtt(TbSpecification tbSpecification,String[] attSpecofocation,Integer count);
}
