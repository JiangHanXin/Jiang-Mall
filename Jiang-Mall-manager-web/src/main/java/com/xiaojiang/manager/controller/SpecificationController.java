package com.xiaojiang.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaojiang.pojo.*;
import com.xiaojiang.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人:小江
 * @创建时间:2019/6/8 0008
 * @描述:规格管理
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;

    //获取所有规格
    @RequestMapping(value = "/Guige")
    public Map getAllGuige(){
        Map<String,Object> map1 = new HashMap<String,Object>();
        List<TbSpecification> specifications = specificationService.getAllGuige();
        List<TbSpecificationOption> specificationOptions = specificationService.getAllGuigeOption();
        List<SpecificationResult> data = new ArrayList<SpecificationResult>();
        int count = specifications.size() + specificationOptions.size();
        int specCount = specifications.size();
        for(int i=0;i<count;i++){
            //开辟空间太耗时间了，可以考虑让前端去处理，后端直接传string
            //每次执行创建一个内存空间，要不然内存名不变会直接覆盖前面数据
            //规格
            SpecificationResult specificationResult = new SpecificationResult();
            if(i>=specifications.size()){
                //规格属性
                //减去规格数5个，要不然数组越界
                specificationResult.setD_id(specificationOptions.get(i-specCount).getId());
                specificationResult.setName(specificationOptions.get(i-specCount).getOptionName());
                specificationResult.setD_pid(specificationOptions.get(i-specCount).getSpecId());
            }else{
                specificationResult.setD_id(specifications.get(i).getId());
                specificationResult.setName(specifications.get(i).getSpecName());
                specificationResult.setD_pid(0L);
            }

            data.add(i,specificationResult);
        }
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("data",data);
        return map1;
    }

    //增加规格
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult addSpec(String specName,String[] attSpecofocation){
        AjaxResult result = new AjaxResult();
        try{
            TbSpecification tbSpecification = new TbSpecification();
            tbSpecification.setSpecName(specName);
            specificationService.insertSpec(tbSpecification,attSpecofocation);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /***
     *
     * 删除规格
     */
    @RequestMapping(value = "/delete")
    public void delete(@RequestParam("id") Long id){
        specificationService.deleteByid(id);
    }
    /**
     * 删除规格属性
     * */
    @RequestMapping(value = "/deleteAttribute")
    public void deleteAttribute(Long id){
        specificationService.deleteAttribute(id);
    }

    /**
     * 修改规格 and 属性
     */
    @RequestMapping(value = "/update")
    public void update(Long id,String specName,String[] attSpecofocation){
        TbSpecification tbSpecification = new TbSpecification();
        tbSpecification.setId(id);
        tbSpecification.setSpecName(specName);
        specificationService.updateSpec(tbSpecification,attSpecofocation);
    }
    /**
     * 修改规格 and 新增属性
     * */

    @RequestMapping(value = "/updateSpecAndAtt")
    public void updateSpecAndAtt(Long id,String specName,String[] attSpecofocation,Integer count){

        TbSpecification tbSpec = new TbSpecification();
        tbSpec.setId(id);
        tbSpec.setSpecName(specName);
        specificationService.updateSpecAndAtt(tbSpec,attSpecofocation,count);
    }



}
