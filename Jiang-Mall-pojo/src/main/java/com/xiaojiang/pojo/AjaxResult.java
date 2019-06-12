package com.xiaojiang.pojo;

import java.io.Serializable;

/**
 * @创建人:小江
 * @创建时间:2019/6/4 0004
 * @描述:ajax请求结果
 */
public class AjaxResult implements Serializable {

    private boolean success;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
