package com.ilp3.system.entity;

import java.util.Date;

public class Achievements {
    private int quality;
    private int deliver;
    private int paymentMethod;
    private int complaint;
    private int service;
    private int achievementsId;
    private int supplierId;
    private int totalcount;
    private int userIdCreate;
    private Date gmtCreate;
    private Date gmtModified;

    @Override
    public String toString() {
        return "Achievements{" +
                "quality=" + quality +
                ", deliver=" + deliver +
                ", paymentMethod=" + paymentMethod +
                ", complaint=" + complaint +
                ", service=" + service +
                ", achievementsId=" + achievementsId +
                ", supplierId=" + supplierId +
                ", totalcount=" + totalcount +
                ", userIdCreate=" + userIdCreate +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getDeliver() {
        return deliver;
    }

    public void setDeliver(int deliver) {
        this.deliver = deliver;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getComplaint() {
        return complaint;
    }

    public void setComplaint(int complaint) {
        this.complaint = complaint;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getAchievementsId() {
        return achievementsId;
    }

    public void setAchievementsId(int achievementsId) {
        this.achievementsId = achievementsId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public int getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(int userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
