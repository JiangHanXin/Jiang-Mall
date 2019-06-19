package com.xiaojiang.sellergoods.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaojiang.dao.TbSellerMapper;
import com.xiaojiang.pojo.TbSeller;
import com.xiaojiang.sellergoods.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @创建人:小江
 * @创建时间:2019/6/19 0019
 * @描述:商家入驻
 */

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private TbSellerMapper sellerMapper;

    @Override
    public void insert(TbSeller seller) {
        seller.setStatus("0");
        seller.setCreateTime(new Date());
        sellerMapper.insert(seller);
    }
}
