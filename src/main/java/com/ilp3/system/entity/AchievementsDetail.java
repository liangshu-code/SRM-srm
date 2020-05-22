package com.ilp3.system.entity;

public class AchievementsDetail {
    private int supplierId;
    private int achievements_detailId;
    private int qualifiedBatches;
    private int totalFeedBatches;
    private int materialReturn;
    private int deliveryOnTime;
    private int    submitInfo;
    private int orderReplyInfo;
    private int     pricePosition;
    private int knotScore;
    private int attitude;
    private int exReply;
    private int   exDone;
    private int refuseReply;

    @Override
    public String toString() {
        return "AchievementsDetail{" +
                "supplierId=" + supplierId +
                ", achievements_detailId=" + achievements_detailId +
                ", qualifiedBatches=" + qualifiedBatches +
                ", totalFeedBatches=" + totalFeedBatches +
                ", materialReturn=" + materialReturn +
                ", deliveryOnTime=" + deliveryOnTime +
                ", submitInfo=" + submitInfo +
                ", orderReplyInfo=" + orderReplyInfo +
                ", pricePosition=" + pricePosition +
                ", knotScore=" + knotScore +
                ", attitude=" + attitude +
                ", exReply=" + exReply +
                ", exDone=" + exDone +
                ", refuseReply=" + refuseReply +
                '}';
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getAchievements_detailId() {
        return achievements_detailId;
    }

    public void setAchievements_detailId(int achievements_detailId) {
        this.achievements_detailId = achievements_detailId;
    }

    public int getQualifiedBatches() {
        return qualifiedBatches;
    }

    public void setQualifiedBatches(int qualifiedBatches) {
        this.qualifiedBatches = qualifiedBatches;
    }

    public int getTotalFeedBatches() {
        return totalFeedBatches;
    }

    public void setTotalFeedBatches(int totalFeedBatches) {
        this.totalFeedBatches = totalFeedBatches;
    }

    public int getMaterialReturn() {
        return materialReturn;
    }

    public void setMaterialReturn(int materialReturn) {
        this.materialReturn = materialReturn;
    }

    public int getDeliveryOnTime() {
        return deliveryOnTime;
    }

    public void setDeliveryOnTime(int deliveryOnTime) {
        this.deliveryOnTime = deliveryOnTime;
    }

    public int getSubmitInfo() {
        return submitInfo;
    }

    public void setSubmitInfo(int submitInfo) {
        this.submitInfo = submitInfo;
    }

    public int getOrderReplyInfo() {
        return orderReplyInfo;
    }

    public void setOrderReplyInfo(int orderReplyInfo) {
        this.orderReplyInfo = orderReplyInfo;
    }

    public int getPricePosition() {
        return pricePosition;
    }

    public void setPricePosition(int pricePosition) {
        this.pricePosition = pricePosition;
    }

    public int getKnotScore() {
        return knotScore;
    }

    public void setKnotScore(int knotScore) {
        this.knotScore = knotScore;
    }

    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitud) {
        this.attitude= attitud;
    }

    public int getExReply() {
        return exReply;
    }

    public void setExReply(int exReply) {
        this.exReply = exReply;
    }

    public int getExDone() {
        return exDone;
    }

    public void setExDone(int exDone) {
        this.exDone = exDone;
    }

    public int getRefuseReply() {
        return refuseReply;
    }

    public void setRefuseReply(int refuseReply) {
        this.refuseReply = refuseReply;
    }

}
