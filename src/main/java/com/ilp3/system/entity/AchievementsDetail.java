package com.ilp3.system.entity;

public class AchievementsDetail {
    private int supplierId;
    private int achievements_detail_id;
    private int qualified_batches;
    private int total_feed_batches;
    private int material_return;
    private int delivery_on_time;
    private int    submit_info;
    private int order_reply_info;
    private int     price_position;
    private int knot_score;
    private int attitud;
    private int ex_reply;
    private int   ex_done;
    private int refuse_reply;

    @Override
    public String toString() {
        return "AchievementsDetail{" +
                "supplierId=" + supplierId +
                ", achievements_detail_id=" + achievements_detail_id +
                ", qualified_batches=" + qualified_batches +
                ", total_feed_batches=" + total_feed_batches +
                ", material_return=" + material_return +
                ", delivery_on_time=" + delivery_on_time +
                ", submit_info=" + submit_info +
                ", order_reply_info=" + order_reply_info +
                ", price_position=" + price_position +
                ", knot_score=" + knot_score +
                ", attitud=" + attitud +
                ", ex_reply=" + ex_reply +
                ", ex_done=" + ex_done +
                ", refuse_reply=" + refuse_reply +
                '}';
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getAchievements_detail_id() {
        return achievements_detail_id;
    }

    public void setAchievements_detail_id(int achievements_detail_id) {
        this.achievements_detail_id = achievements_detail_id;
    }

    public int getQualified_batches() {
        return qualified_batches;
    }

    public void setQualified_batches(int qualified_batches) {
        this.qualified_batches = qualified_batches;
    }

    public int getTotal_feed_batches() {
        return total_feed_batches;
    }

    public void setTotal_feed_batches(int total_feed_batches) {
        this.total_feed_batches = total_feed_batches;
    }

    public int getMaterial_return() {
        return material_return;
    }

    public void setMaterial_return(int material_return) {
        this.material_return = material_return;
    }

    public int getDelivery_on_time() {
        return delivery_on_time;
    }

    public void setDelivery_on_time(int delivery_on_time) {
        this.delivery_on_time = delivery_on_time;
    }

    public int getSubmit_info() {
        return submit_info;
    }

    public void setSubmit_info(int submit_info) {
        this.submit_info = submit_info;
    }

    public int getOrder_reply_info() {
        return order_reply_info;
    }

    public void setOrder_reply_info(int order_reply_info) {
        this.order_reply_info = order_reply_info;
    }

    public int getPrice_position() {
        return price_position;
    }

    public void setPrice_position(int price_position) {
        this.price_position = price_position;
    }

    public int getKnot_score() {
        return knot_score;
    }

    public void setKnot_score(int knot_score) {
        this.knot_score = knot_score;
    }

    public int getAttitud() {
        return attitud;
    }

    public void setAttitud(int attitud) {
        this.attitud = attitud;
    }

    public int getEx_reply() {
        return ex_reply;
    }

    public void setEx_reply(int ex_reply) {
        this.ex_reply = ex_reply;
    }

    public int getEx_done() {
        return ex_done;
    }

    public void setEx_done(int ex_done) {
        this.ex_done = ex_done;
    }

    public int getRefuse_reply() {
        return refuse_reply;
    }

    public void setRefuse_reply(int refuse_reply) {
        this.refuse_reply = refuse_reply;
    }
}
