package com.xiaojiang.pojo;

import java.io.Serializable;

/**
 * @创建人:小江
 * @创建时间:2019/6/8 0008
 * @描述:商品规格 or 规格属性
 */
public class SpecificationResult implements Serializable {

//     "d_id": "1",
//             "name": "xx",
//             "sex": "male",
//             "d_pid": "0"

    private Long d_id;
    private String name;
    private Long d_pid;

    public Long getD_id() {
        return d_id;
    }

    public void setD_id(Long d_id) {
        this.d_id = d_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getD_pid() {
        return d_pid;
    }

    public void setD_pid(Long d_pid) {
        this.d_pid = d_pid;
    }
}
