package com.coolq.ap.dto;

import com.coolq.ap.common.page.PageReq;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/21
 */
public class UserReq extends PageReq {
    private String userName;
    private int userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
