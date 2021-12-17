package com.example.fileparser.model;

//ID,"Полное имя контакта", "Рабочий телефон","Рабочий прямой телефон","Мобильный телефон","Домашний телефон","Другой телефон","Рабочий email","Личный email","Другой email"
public class CrmEntity {
    private Long id;
    private String contactFullName;
    private String workPhone;
    private String workDirectPhone;
    private String mobilePhone;
    private String homePhone;
    private String anotherPhone;
    private String workEmail;
    private String personalEmail;
    private String anotherEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactFullName() {
        return contactFullName;
    }

    public void setContactFullName(String contactFullName) {
        this.contactFullName = contactFullName;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkDirectPhone() {
        return workDirectPhone;
    }

    public void setWorkDirectPhone(String workDirectPhone) {
        this.workDirectPhone = workDirectPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getAnotherPhone() {
        return anotherPhone;
    }

    public void setAnotherPhone(String anotherPhone) {
        this.anotherPhone = anotherPhone;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getAnotherEmail() {
        return anotherEmail;
    }

    public void setAnotherEmail(String anotherEmail) {
        this.anotherEmail = anotherEmail;
    }
}
