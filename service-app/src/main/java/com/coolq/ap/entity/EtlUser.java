package com.coolq.ap.entity;

import java.util.Date;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/19
 */
public class EtlUser {

    private Integer id;

    private String userName;

    private String password;

    private String nickname;

    private Integer userLevel;

    private Integer enabled;

    private Integer deleted;

    private Date creDt;

    private Date lastModifyDt;

    private Date delDt;

    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreDt() {
        return creDt;
    }

    public void setCreDt(Date creDt) {
        this.creDt = creDt;
    }

    public Date getLastModifyDt() {
        return lastModifyDt;
    }

    public void setLastModifyDt(Date lastModifyDt) {
        this.lastModifyDt = lastModifyDt;
    }

    public Date getDelDt() {
        return delDt;
    }

    public void setDelDt(Date delDt) {
        this.delDt = delDt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
