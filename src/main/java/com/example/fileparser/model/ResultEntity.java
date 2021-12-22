package com.example.fileparser.model;

public class ResultEntity {
    private Long transactionalTableId;
    private String clientName;
    private String phoneNumber;
    private String email;
    private String goods;
    private String sumOfPayment;
    private String timeOfPayment;
    private String paymentMethod;
    private String cardOwner;
    private String clientCountry;
    private String clientSurname;

    private Long crmTableId;
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

    public ResultEntity(Long transactionalTableId, String clientName, String phoneNumber, String email,
                        String goods, String sumOfPayment, String timeOfPayment, String paymentMethod,
                        String cardOwner, String clientCountry, String clientSurname, Long crmTableId,
                        Long id, String contactFullName, String workPhone, String workDirectPhone,
                        String mobilePhone, String homePhone, String anotherPhone, String workEmail,
                        String personalEmail, String anotherEmail) {
        this.transactionalTableId = transactionalTableId;
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.goods = goods;
        this.sumOfPayment = sumOfPayment;
        this.timeOfPayment = timeOfPayment;
        this.paymentMethod = paymentMethod;
        this.cardOwner = cardOwner;
        this.clientCountry = clientCountry;
        this.clientSurname = clientSurname;
        this.crmTableId = crmTableId;
        this.id = id;
        this.contactFullName = contactFullName;
        this.workPhone = workPhone;
        this.workDirectPhone = workDirectPhone;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.anotherPhone = anotherPhone;
        this.workEmail = workEmail;
        this.personalEmail = personalEmail;
        this.anotherEmail = anotherEmail;
    }

    public Long getTransactionalTableId() {
        return transactionalTableId;
    }

    public void setTransactionalTableId(Long transactionalTableId) {
        this.transactionalTableId = transactionalTableId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getSumOfPayment() {
        return sumOfPayment;
    }

    public void setSumOfPayment(String sumOfPayment) {
        this.sumOfPayment = sumOfPayment;
    }

    public String getTimeOfPayment() {
        return timeOfPayment;
    }

    public void setTimeOfPayment(String timeOfPayment) {
        this.timeOfPayment = timeOfPayment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public String getClientCountry() {
        return clientCountry;
    }

    public void setClientCountry(String clientCountry) {
        this.clientCountry = clientCountry;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public Long getCrmTableId() {
        return crmTableId;
    }

    public void setCrmTableId(Long crmTableId) {
        this.crmTableId = crmTableId;
    }

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

    @Override
    public String toString() {
        return "ResultEntity{" +
                "transactionalTableId=" + transactionalTableId +
                ", clientName='" + clientName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", goods='" + goods + '\'' +
                ", sumOfPayment='" + sumOfPayment + '\'' +
                ", timeOfPayment='" + timeOfPayment + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", cardOwner='" + cardOwner + '\'' +
                ", clientCountry='" + clientCountry + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", crmTableId=" + crmTableId +
                ", id=" + id +
                ", contactFullName='" + contactFullName + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", workDirectPhone='" + workDirectPhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", anotherPhone='" + anotherPhone + '\'' +
                ", workEmail='" + workEmail + '\'' +
                ", personalEmail='" + personalEmail + '\'' +
                ", anotherEmail='" + anotherEmail + '\'' +
                '}';
    }
}
