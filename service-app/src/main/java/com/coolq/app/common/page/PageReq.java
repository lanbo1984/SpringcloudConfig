package com.coolq.app.common.page;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/24
 */
public class PageReq {

    private static final int DEFAULT_ROWS = 10;
    private Integer page;
    private Integer rows;


    public Integer getPage() {
        if (page == null || page <= 0) {
            page = 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        if (rows == null || rows <= 0) {
            rows = DEFAULT_ROWS;
        }
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
