package com.ilp3.system.entity;

import java.util.Date;

public class TResult {
    private String regLocation;
    private String regCapital;
    private Date estiblishTime;
    private String orgNumber;
    private String staffNumRange;

    public String getRegLocation() {
        return regLocation;
    }

    public void setRegLocation(String regLocation) {
        this.regLocation = regLocation;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public Date getEstiblishTime() {
        return estiblishTime;
    }

    public void setEstiblishTime(Date estiblishTime) {
        this.estiblishTime = estiblishTime;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public String getStaffNumRange() {
        return staffNumRange;
    }

    public void setStaffNumRange(String staffNumRange) {
        this.staffNumRange = staffNumRange;
    }
}

