package com.ilp3.system.entity;

import java.util.Date;

public class Achievements {
    private int achievements_id;
    private int supplier_id;
    private int quality;
    private int deliver;
    private int payment_method;
    private int complaint;
    private int service;
    private int user_id_create;
    private Date gmt_create;
    private Date gmt_modified;

    public int getAchievements_id() {
        return achievements_id;
    }

    public void setAchievements_id(int achievements_id) {
        this.achievements_id = achievements_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
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

    public int getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(int payment_method) {
        this.payment_method = payment_method;
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

    public int getUser_id_create() {
        return user_id_create;
    }

    public void setUser_id_create(int user_id_create) {
        this.user_id_create = user_id_create;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }
}
