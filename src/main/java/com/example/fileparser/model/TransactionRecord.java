package com.example.fileparser.model;

public class TransactionRecord {
    // 'Имя клиента';Телефон;Email;Товары;Сумма;'Время платежа';'Способ оплаты';'Владелец карты';'Страна Клиента';'Фамилия клиента'
    private Long id;
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

    public TransactionRecord(Long id, String clientName, String phoneNumber, String email, String goods,
                             String sumOfPayment, String timeOfPayment, String paymentMethod,
                             String cardOwner, String clientCountry, String clientSurname) {
        this.id = id;
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
