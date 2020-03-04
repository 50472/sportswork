package com.sportswork.sportswork.core.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author dengwei
 * @date 2019/8/15 15:08
 * @description
 */
@Data
@Accessors(chain = true)
public class PageDTO<T> {
    private List<T> rows;
    private long total;
    private int page;
    private int size;

    public PageDTO rows(List<T> rows){
        this.rows=rows;
        return this;
    }
    public PageDTO total(long total){
        this.total=total;
        return this;
    }

    public PageDTO page(int page){
        this.page=page;
        return this;
    }

    public PageDTO size(int size){
        this.size=size;
        return this;
    }

    public PageDTO toPageDTO(List<T> pages){
        List<T> rows = pages;
        long total = pages.size();
        int page = 0;
        int size = 10;
        return this.rows(rows)
                .total(total)
                .page(page)
                .size(size);
    }


}
