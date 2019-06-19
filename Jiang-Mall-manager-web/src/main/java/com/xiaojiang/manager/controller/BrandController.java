package com.xiaojiang.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaojiang.pojo.AjaxResult;
import com.xiaojiang.pojo.PageResule;
import com.xiaojiang.pojo.TbBrand;
import com.xiaojiang.sellergoods.service.BrandService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @创建人:小江
 * @创建时间:2019/5/26 0026
 * @描述:品牌查询
 */

@Controller
@ResponseBody
@RequestMapping(value = "/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

   /**
    * 获取所有品牌
    *
    * */
   @RequestMapping(value = "/findAll")
    public Map<String, Object> getAllBrand(){
       Map<String, Object> map = new HashMap<String, Object>();
       List<TbBrand> BrandData = brandService.findAll();
       map.put("code",0);
       map.put("msg","");
       map.put("count",BrandData.size());
       map.put("data",BrandData);
       return map;
   }

   /**
    * 品牌分页
    */
   @RequestMapping(value = "/findPage")
   @ResponseBody
    public PageResule findPage(Integer page,Integer limit,String brandName){
       Map<Object,Object> map = new HashMap<>();
       map.put("brandName",brandName);
       return brandService.findPage(page,limit,map);
    }

    /***
     * 增加品牌
     */
    @RequestMapping(value = "/addBrand",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult addBrand(TbBrand brand){
        AjaxResult result = new AjaxResult();
        try{
            brandService.insertBrand(brand);
            result.setSuccess(true);
        }catch(Exception e){
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量删除品牌
     * */
    @RequestMapping(value = "/batDelete" ,method = RequestMethod.GET)
    public AjaxResult batDelete(Integer[] ids){
        AjaxResult result = new AjaxResult();
        try{
            brandService.batDelete(ids);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/delete")
    public AjaxResult delete(Long id){
        AjaxResult result = new AjaxResult();
        try{
            brandService.delete(id);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改品牌
     * */
    @RequestMapping(value = "/updateBrand")
    public AjaxResult editBrand(TbBrand brand){
        AjaxResult result = new AjaxResult();
        try{
            brandService.updateBrand(brand);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

}
