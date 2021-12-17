package com.example.projectfile.Model;

public class List2VO {
    String number2;
    String business2;
    String location2;
    String remark;

    public List2VO(String number2, String business2, String location2, String remark) {
        this.number2 = number2;
        this.business2 = business2;
        this.location2 = location2;
        this.remark = remark;
    }

    public List2VO() {

    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getBusiness2() {
        return business2;
    }

    public void setBusiness2(String business2) {
        this.business2 = business2;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "List2VO{" +
                "number2='" + number2 + '\'' +
                ", business2='" + business2 + '\'' +
                ", location2='" + location2 + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
