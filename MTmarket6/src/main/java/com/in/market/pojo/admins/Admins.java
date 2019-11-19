package com.in.market.pojo.admins;



public class Admins {
    private Integer adminId;

    private String adminName;

    private String adminPhone;

    private String adminDate;

    private Integer adminState;

    private Integer adminRole;

    public String getAdminDate() {
        return adminDate;
    }

    public void setAdminDate(String adminDate) {
        this.adminDate = adminDate;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }


    public Integer getAdminState() {
        return adminState;
    }

    public void setAdminState(Integer adminState) {
        this.adminState = adminState;
    }

    public Integer getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(Integer adminRole) {
        this.adminRole = adminRole;
    }

    public Admins() {
    }

    @Override
    public String toString() {
        return "Admins{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", adminDate='" + adminDate + '\'' +
                ", adminState=" + adminState +
                ", adminRole=" + adminRole +
                '}';
    }

    public Admins(Integer adminId, String adminName, String adminPhone, String adminDate, Integer adminState, Integer adminRole) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPhone = adminPhone;
        this.adminDate = adminDate;
        this.adminState = adminState;
        this.adminRole = adminRole;
    }
}