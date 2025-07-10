package frontend.pages.reserve;

import java.util.Date;

public class Booking {
    private String fname;
    private String sname;
    private Date checkin;
    private Date checkout;
    private String mobile;
    private String roomType;
    private String paymentMethod;
    private String transactionId;

    
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }
    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }
    public Date getCheckin() { return checkin; }
    public void setCheckin(Date checkin) { this.checkin = checkin; }
    public Date getCheckout() { return checkout; }
    public void setCheckout(Date checkout) { this.checkout = checkout; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
