package com.kxj.hrserver.bean;

import java.util.List;

/**
 * @ClassName RespPageBean
 * @Description TODO
 * @Author kxj
 * @Date 2020/1/11 23:19
 * @Version 1.0
 **/
public class RespPageBean {

    private Long total;

    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
