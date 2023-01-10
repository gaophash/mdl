package com.jiasu.mdl.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author gaopeng
 * @since 2021-07-09
 */
@NoArgsConstructor
public class Page implements Serializable {

    @ApiModelProperty("每页显示条数，默认 10, 最大20条")
    protected long limit = 500;

    @ApiModelProperty("当前页")
    protected long page = 1;

    public Page(long limit, long page) {
        this.limit = getPageSize(limit);
        this.page = page;
    }

    public long getPageSize() {
        return limit;
    }

    public void setPageSize(long limit) {
        this.limit = getPageSize(limit);
    }

    private long getPageSize(long pageSize) {
        if (pageSize < 0) {
            pageSize = 10;
        } else if (pageSize > 20) {
            pageSize = 20;
        }
        return pageSize;
    }

    public long getCurrentPage() {
        return page;
    }

    public void setCurrentPage(long page) {
        this.page = page;
    }
}
