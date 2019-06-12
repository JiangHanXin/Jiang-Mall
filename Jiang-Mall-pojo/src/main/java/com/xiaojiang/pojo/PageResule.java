package com.xiaojiang.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @创建人:小江
 * @创建时间:2019/6/3 0003
 * @描述:分页结果类
 */
public class PageResule implements Serializable {
    private int code;
    private String msg;
    private long count;
    private List data;

    public PageResule(int code, String msg, long count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
