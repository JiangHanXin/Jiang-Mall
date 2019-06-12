package com.xiaojiang.pojo;

import java.io.Serializable;

/**
 * @创建人:小江
 * @创建时间:2019/6/10 0010
 * @描述:规格 and 规格属性
 */
public class SpecificationNum implements Serializable {

    private TbSpecification tbSpecification;
    private TbSpecificationOption tbSpecificationOption;
    
    public TbSpecification getTbSpecification() {
        return tbSpecification;
    }

    public void setTbSpecification(TbSpecification tbSpecification) {
        this.tbSpecification = tbSpecification;
    }

    public TbSpecificationOption getTbSpecificationOption() {
        return tbSpecificationOption;
    }

    public void setTbSpecificationOption(TbSpecificationOption tbSpecificationOption) {
        this.tbSpecificationOption = tbSpecificationOption;
    }
}
