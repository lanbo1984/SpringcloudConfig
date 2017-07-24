package com.coolq.ap.common.page;

import com.github.pagehelper.PageInfo;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/24
 */
public class PageConverts {

    public static PageRsp convert(PageInfo pageInfo) {

        if (pageInfo == null || pageInfo.getTotal() == 0) {
            return null;
        }

        PageRsp rsp = new PageRsp();
        rsp.setFirstPage(pageInfo.isIsFirstPage());
        rsp.setLastPage(pageInfo.isIsLastPage());
        rsp.setList(pageInfo.getList());
        rsp.setPages(pageInfo.getPages());
        rsp.setPageNum(pageInfo.getPageNum());
        rsp.setPageSize(pageInfo.getPageSize());
        rsp.setTotal(pageInfo.getTotal());

        return rsp;

    }
}
