package com.xiaojiang.sellergoods.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaojiang.dao.TbSpecificationMapper;
import com.xiaojiang.dao.TbSpecificationOptionMapper;
import com.xiaojiang.pojo.TbSpecification;
import com.xiaojiang.pojo.TbSpecificationOption;
import com.xiaojiang.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建人:小江
 * @创建时间:2019/6/8 0008
 * @描述:XXX
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;

    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    /***
     *查询所有规格
     */
    @Override
    public List<TbSpecification> getAllGuige() {
        return tbSpecificationMapper.selectByExample(null);
    }

    /**
     *查询规格属性
     */
    @Override
    public List<TbSpecificationOption> getAllGuigeOption() {
        return tbSpecificationOptionMapper.selectByExample(null);
    }

    /***
     * 增加规格
     */
    @Override
    public void insertSpec(TbSpecification tbSpecification,String[] attSpecofocation) {
        tbSpecificationMapper.insert(tbSpecification);

        for(int i=0;i<attSpecofocation.length;i++){
            TbSpecificationOption SpecData = new TbSpecificationOption();
            SpecData.setSpecId(tbSpecification.getId());
            SpecData.setOptionName(attSpecofocation[i]);
            SpecData.setOrders(i+1);
            tbSpecificationOptionMapper.insert(SpecData);
        }

    }

    @Override
    public void deleteByid(Long id) {
        //删除规格
        tbSpecificationMapper.deleteByPrimaryKey(id);
        //删除规格属性
        tbSpecificationOptionMapper.deleteBySpecKey(id);
    }

    @Override
    public void deleteAttribute(Long id) {
        tbSpecificationOptionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateSpec(TbSpecification tbSpecification, String[] attSpecofocation) {
        //修改规格
        tbSpecificationMapper.updateByPrimaryKey(tbSpecification);
        //修规属性
        for(int i=0;i<attSpecofocation.length;i++){
            TbSpecificationOption option = new TbSpecificationOption();
        }
    }

    @Override
    public void updateSpecAndAtt(TbSpecification tbSpecification,String[] attSpecofocation,Integer count) {

        //修改规格
        tbSpecificationMapper.updateByPrimaryKey(tbSpecification);

        //新增属性 -1去掉最后逗号
        int number = attSpecofocation.length;
         for(int i=0;i<number;i++){
             TbSpecificationOption option = new TbSpecificationOption();
             if(attSpecofocation[i] != "" && attSpecofocation[i] != null){
                 option.setSpecId(tbSpecification.getId());
                 option.setOptionName(attSpecofocation[i]);
                 option.setOrders(count+(i+1));
                 if(count == 1){
                     tbSpecificationOptionMapper.updateBySpecKey(option);
                 }else{
                     tbSpecificationOptionMapper.insert(option);
                 }

             }
         }
    }


}
