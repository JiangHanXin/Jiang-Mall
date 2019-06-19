package com.xiaojiang.seller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaojiang.pojo.AjaxResult;
import com.xiaojiang.pojo.TbSeller;
import com.xiaojiang.sellergoods.service.SellerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @创建人:小江
 * @创建时间:2019/6/19 0019
 * @描述:商家入驻
 */

@Controller
@RequestMapping("/seller")
public class SellerController {

    @Reference
    private SellerService sellerService;

    /**
     * 增加 （一定要记得启动服务接口(RPC)，不然调用不到Service）
     * @param seller
     * @return
     */
    @RequestMapping(value = "/insert" ,method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult insert(TbSeller seller){
        AjaxResult result = new AjaxResult();
        try {
            //BCrypt强哈希
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            seller.setPassword(passwordEncoder.encode(seller.getPassword()));
            sellerService.insert(seller);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

}
