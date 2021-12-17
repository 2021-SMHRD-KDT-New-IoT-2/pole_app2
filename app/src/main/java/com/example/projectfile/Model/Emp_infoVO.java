package com.example.projectfile.Model;

import java.io.Serializable;

public class Emp_infoVO implements Serializable {

    private String emp_id;
    private String emp_pw;
    private String emp_name;
    private String emp_office;
    private String emp_phone;
    private String emp_joindate;
    private String admin_yesno;

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_pw() {
        return emp_pw;
    }

    public void setEmp_pw(String emp_pw) {
        this.emp_pw = emp_pw;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_office() {
        return emp_office;
    }

    public void setEmp_office(String emp_office) {
        this.emp_office = emp_office;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getEmp_joindate() {
        return emp_joindate;
    }

    public void setEmp_joindate(String emp_joindate) {
        this.emp_joindate = emp_joindate;
    }

    public String getAdmin_yesno() {
        return admin_yesno;
    }

    public void setAdmin_yesno(String admin_yesno) {
        this.admin_yesno = admin_yesno;
    }

    public Emp_infoVO(String emp_id, String emp_pw, String emp_name, String emp_office, String emp_phone, String emp_joindate, String admin_yesno) {
        this.emp_id = emp_id;
        this.emp_pw = emp_pw;
        this.emp_name = emp_name;
        this.emp_office = emp_office;
        this.emp_phone = emp_phone;
        this.emp_joindate = emp_joindate;
        this.admin_yesno = admin_yesno;
    }


    public Emp_infoVO() {

    }


    public Emp_infoVO(String emp_id, String emp_pw, String emp_name, String emp_office, String emp_phone, String admin_yesno) {
        this.emp_id = emp_id;
        this.emp_pw = emp_pw;
        this.emp_name = emp_name;
        this.emp_office = emp_office;
        this.emp_phone = emp_phone;
        this.admin_yesno = admin_yesno;
    }



    public Emp_infoVO(String emp_id, String emp_name, String emp_office, String emp_phone, String admin_yesno) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_office = emp_office;
        this.emp_phone = emp_phone;
        this.admin_yesno = admin_yesno;
    }




    @Override
    public String toString() {
        return "emp_infoVO{" +
                "emp_id='" + emp_id + '\'' +
                ", emp_pw='" + emp_pw + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", emp_office='" + emp_office + '\'' +
                ", emp_phone='" + emp_phone + '\'' +
                ", emp_joindate=" + emp_joindate +
                ", admin_yesno='" + admin_yesno + '\'' +
                '}';
    }
}
