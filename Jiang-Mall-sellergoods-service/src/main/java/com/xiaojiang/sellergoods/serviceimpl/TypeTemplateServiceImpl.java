package com.xiaojiang.sellergoods.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaojiang.dao.TbTypeTemplateMapper;
import com.xiaojiang.pojo.TbTypeTemplate;
import com.xiaojiang.sellergoods.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @创建人:小江
 * @创建时间:2019/6/12 0012
 * @描述:模板管理
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TbTypeTemplateMapper tbTypeTemplateMapper;

    @Override
    public List<TbTypeTemplate> findTemplate() {
        return tbTypeTemplateMapper.selectByExample(null);
    }
}
