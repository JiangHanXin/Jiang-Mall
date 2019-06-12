package com.xiaojiang.dao;

import com.xiaojiang.pojo.TbSpecificationOption;
import com.xiaojiang.pojo.TbSpecificationOptionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSpecificationOptionMapper {
    long countByExample(TbSpecificationOptionExample example);

    int deleteByExample(TbSpecificationOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSpecificationOption record);

    int insertSelective(TbSpecificationOption record);

    List<TbSpecificationOption> selectByExample(TbSpecificationOptionExample example);

    TbSpecificationOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSpecificationOption record, @Param("example") TbSpecificationOptionExample example);

    int updateByExample(@Param("record") TbSpecificationOption record, @Param("example") TbSpecificationOptionExample example);

    int updateByPrimaryKeySelective(TbSpecificationOption record);

    int updateByPrimaryKey(TbSpecificationOption record);

    int deleteBySpecKey(Long id);

    int updateBySpecKey(TbSpecificationOption id);
}