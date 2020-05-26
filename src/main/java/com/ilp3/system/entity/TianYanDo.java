package com.ilp3.system.entity;


import java.util.Date;

public class TianYanDo {
    private int id;
    private String  supplier_Id;
    private String  name;
    private int     error_code;
    private String   reason;
    private TResult  tResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplier_Id() {
        return supplier_Id;
    }

    public void setSupplier_Id(String supplier_Id) {
        this.supplier_Id = supplier_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public TResult gettResult() {
        return tResult;
    }

    public void settResult(TResult tResult) {
        this.tResult = tResult;
    }







}
