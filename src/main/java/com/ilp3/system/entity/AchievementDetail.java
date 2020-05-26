package com.ilp3.system.entity;

import java.io.Serializable;
import java.util.Date;

public class AchievementDetail implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.achievements_detail_id
     *
     * @mbg.generated
     */
    private Integer achievementsDetailId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.supplier_id
     *
     * @mbg.generated
     */
    private Integer supplierId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.qualified_batches
     *
     * @mbg.generated
     */
    private Integer qualifiedBatches;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.total_feed_batches
     *
     * @mbg.generated
     */
    private Integer totalFeedBatches;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.material_return
     *
     * @mbg.generated
     */
    private Integer materialReturn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.delivery_on_time
     *
     * @mbg.generated
     */
    private Integer deliveryOnTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.submit_info
     *
     * @mbg.generated
     */
    private Integer submitInfo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.order_reply_info
     *
     * @mbg.generated
     */
    private Integer orderReplyInfo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.price_position
     *
     * @mbg.generated
     */
    private Integer pricePosition;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.knot_score
     *
     * @mbg.generated
     */
    private Integer knotScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.attitude
     *
     * @mbg.generated
     */
    private Integer attitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.ex_reply
     *
     * @mbg.generated
     */
    private Integer exReply;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.ex_done
     *
     * @mbg.generated
     */
    private Integer exDone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.refuse_reply
     *
     * @mbg.generated
     */
    private Integer refuseReply;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achievement_detail.gmt_modified
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table achievement_detail
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    public Integer getAchievementsDetailId() {
        return achievementsDetailId;
    }

    public void setAchievementsDetailId(Integer achievementsDetailId) {
        this.achievementsDetailId = achievementsDetailId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getQualifiedBatches() {
        return qualifiedBatches;
    }

    public void setQualifiedBatches(Integer qualifiedBatches) {
        this.qualifiedBatches = qualifiedBatches;
    }

    public Integer getTotalFeedBatches() {
        return totalFeedBatches;
    }

    public void setTotalFeedBatches(Integer totalFeedBatches) {
        this.totalFeedBatches = totalFeedBatches;
    }

    public Integer getMaterialReturn() {
        return materialReturn;
    }

    public void setMaterialReturn(Integer materialReturn) {
        this.materialReturn = materialReturn;
    }

    public Integer getDeliveryOnTime() {
        return deliveryOnTime;
    }

    public void setDeliveryOnTime(Integer deliveryOnTime) {
        this.deliveryOnTime = deliveryOnTime;
    }

    public Integer getSubmitInfo() {
        return submitInfo;
    }

    public void setSubmitInfo(Integer submitInfo) {
        this.submitInfo = submitInfo;
    }

    public Integer getOrderReplyInfo() {
        return orderReplyInfo;
    }

    public void setOrderReplyInfo(Integer orderReplyInfo) {
        this.orderReplyInfo = orderReplyInfo;
    }

    public Integer getPricePosition() {
        return pricePosition;
    }

    public void setPricePosition(Integer pricePosition) {
        this.pricePosition = pricePosition;
    }

    public Integer getKnotScore() {
        return knotScore;
    }

    public void setKnotScore(Integer knotScore) {
        this.knotScore = knotScore;
    }

    public Integer getAttitude() {
        return attitude;
    }

    public void setAttitude(Integer attitude) {
        this.attitude = attitude;
    }

    public Integer getExReply() {
        return exReply;
    }

    public void setExReply(Integer exReply) {
        this.exReply = exReply;
    }

    public Integer getExDone() {
        return exDone;
    }

    public void setExDone(Integer exDone) {
        this.exDone = exDone;
    }

    public Integer getRefuseReply() {
        return refuseReply;
    }

    public void setRefuseReply(Integer refuseReply) {
        this.refuseReply = refuseReply;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table achievement_detail
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AchievementDetail other = (AchievementDetail) that;
        return (this.getAchievementsDetailId() == null ? other.getAchievementsDetailId() == null : this.getAchievementsDetailId().equals(other.getAchievementsDetailId()))
            && (this.getSupplierId() == null ? other.getSupplierId() == null : this.getSupplierId().equals(other.getSupplierId()))
            && (this.getQualifiedBatches() == null ? other.getQualifiedBatches() == null : this.getQualifiedBatches().equals(other.getQualifiedBatches()))
            && (this.getTotalFeedBatches() == null ? other.getTotalFeedBatches() == null : this.getTotalFeedBatches().equals(other.getTotalFeedBatches()))
            && (this.getMaterialReturn() == null ? other.getMaterialReturn() == null : this.getMaterialReturn().equals(other.getMaterialReturn()))
            && (this.getDeliveryOnTime() == null ? other.getDeliveryOnTime() == null : this.getDeliveryOnTime().equals(other.getDeliveryOnTime()))
            && (this.getSubmitInfo() == null ? other.getSubmitInfo() == null : this.getSubmitInfo().equals(other.getSubmitInfo()))
            && (this.getOrderReplyInfo() == null ? other.getOrderReplyInfo() == null : this.getOrderReplyInfo().equals(other.getOrderReplyInfo()))
            && (this.getPricePosition() == null ? other.getPricePosition() == null : this.getPricePosition().equals(other.getPricePosition()))
            && (this.getKnotScore() == null ? other.getKnotScore() == null : this.getKnotScore().equals(other.getKnotScore()))
            && (this.getAttitude() == null ? other.getAttitude() == null : this.getAttitude().equals(other.getAttitude()))
            && (this.getExReply() == null ? other.getExReply() == null : this.getExReply().equals(other.getExReply()))
            && (this.getExDone() == null ? other.getExDone() == null : this.getExDone().equals(other.getExDone()))
            && (this.getRefuseReply() == null ? other.getRefuseReply() == null : this.getRefuseReply().equals(other.getRefuseReply()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table achievement_detail
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAchievementsDetailId() == null) ? 0 : getAchievementsDetailId().hashCode());
        result = prime * result + ((getSupplierId() == null) ? 0 : getSupplierId().hashCode());
        result = prime * result + ((getQualifiedBatches() == null) ? 0 : getQualifiedBatches().hashCode());
        result = prime * result + ((getTotalFeedBatches() == null) ? 0 : getTotalFeedBatches().hashCode());
        result = prime * result + ((getMaterialReturn() == null) ? 0 : getMaterialReturn().hashCode());
        result = prime * result + ((getDeliveryOnTime() == null) ? 0 : getDeliveryOnTime().hashCode());
        result = prime * result + ((getSubmitInfo() == null) ? 0 : getSubmitInfo().hashCode());
        result = prime * result + ((getOrderReplyInfo() == null) ? 0 : getOrderReplyInfo().hashCode());
        result = prime * result + ((getPricePosition() == null) ? 0 : getPricePosition().hashCode());
        result = prime * result + ((getKnotScore() == null) ? 0 : getKnotScore().hashCode());
        result = prime * result + ((getAttitude() == null) ? 0 : getAttitude().hashCode());
        result = prime * result + ((getExReply() == null) ? 0 : getExReply().hashCode());
        result = prime * result + ((getExDone() == null) ? 0 : getExDone().hashCode());
        result = prime * result + ((getRefuseReply() == null) ? 0 : getRefuseReply().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table achievement_detail
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", achievementsDetailId=").append(achievementsDetailId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", qualifiedBatches=").append(qualifiedBatches);
        sb.append(", totalFeedBatches=").append(totalFeedBatches);
        sb.append(", materialReturn=").append(materialReturn);
        sb.append(", deliveryOnTime=").append(deliveryOnTime);
        sb.append(", submitInfo=").append(submitInfo);
        sb.append(", orderReplyInfo=").append(orderReplyInfo);
        sb.append(", pricePosition=").append(pricePosition);
        sb.append(", knotScore=").append(knotScore);
        sb.append(", attitude=").append(attitude);
        sb.append(", exReply=").append(exReply);
        sb.append(", exDone=").append(exDone);
        sb.append(", refuseReply=").append(refuseReply);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}