package com.xiaojiang.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaojiang.pojo.TbTypeTemplate;
import com.xiaojiang.sellergoods.service.TypeTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人:小江
 * @创建时间:2019/6/12 0012
 * @描述:模板管理
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService templateService;

    @RequestMapping(value = "/findTemplate")
    public Map getAllTemplate(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<TbTypeTemplate> data =  templateService.findTemplate();
        map.put("code",0);
        map.put("msg","");
        map.put("count",data.size());
        map.put("data",data);
        return map;
    }

}
