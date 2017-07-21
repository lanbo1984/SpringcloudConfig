package com.coolq.ap.entity;

import java.io.Serializable;
import java.util.Date;

public class WfJobs implements Serializable {
    private String id;

    private String appName;

    private String appPath;

    private Date createdTime;

    private Date endTime;

    private String externalId;

    private String groupName;

    private Date lastModifiedTime;

    private String logToken;

    private String parentId;

    private Integer run;

    private Date startTime;

    private String status;

    private String userName;

    private byte[] conf;

    private byte[] protoActionConf;

    private byte[] slaXml;

    private byte[] wfInstance;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath == null ? null : appPath.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId == null ? null : externalId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getLogToken() {
        return logToken;
    }

    public void setLogToken(String logToken) {
        this.logToken = logToken == null ? null : logToken.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public byte[] getConf() {
        return conf;
    }

    public void setConf(byte[] conf) {
        this.conf = conf;
    }

    public byte[] getProtoActionConf() {
        return protoActionConf;
    }

    public void setProtoActionConf(byte[] protoActionConf) {
        this.protoActionConf = protoActionConf;
    }

    public byte[] getSlaXml() {
        return slaXml;
    }

    public void setSlaXml(byte[] slaXml) {
        this.slaXml = slaXml;
    }

    public byte[] getWfInstance() {
        return wfInstance;
    }

    public void setWfInstance(byte[] wfInstance) {
        this.wfInstance = wfInstance;
    }
}