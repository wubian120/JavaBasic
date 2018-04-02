package cn.brady.hackerthon;

import java.sql.Timestamp;

public class Order {

    private Long oid;  //订单id

    private Timestamp orderTime;
    private Long cid; // circle商圈id
    private Long shopId;
    private double shopX;
    private double shopY;
    private double customerX;
    private double customerY;
    private double startTime;  //预计出餐时间
    private double deliverTime; //预计配送时长
    private boolean isPre;

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getDeliverTime() {
        return deliverTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public void setDeliverTime(double deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public double getShopY() {
        return shopY;
    }

    public void setShopY(double shopY) {
        this.shopY = shopY;
    }

    public double getCustomerX() {
        return customerX;
    }

    public void setCustomerX(double customerX) {
        this.customerX = customerX;
    }

    public double getCustomerY() {
        return customerY;
    }

    public void setCustomerY(double customerY) {
        this.customerY = customerY;
    }

    public Long getCid() {
        return cid;
    }

    public Long getOid() {
        return oid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public double getShopX() {
        return shopX;
    }

    public void setShopX(double shopX) {
        this.shopX = shopX;
    }

    public boolean isPre() {
        return isPre;
    }

    public void setPre(boolean pre) {
        isPre = pre;
    }

}
