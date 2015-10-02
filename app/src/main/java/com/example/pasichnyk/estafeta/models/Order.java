package com.example.pasichnyk.estafeta.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {
    private String orderId = "";
    private String number = "";
    private String plannedStartDate = null;
    private String plannedEndDate = null;
    private String actualStartData = null;
    private String actualEndData = null;
    private String vin = "";
    private String model = "";
    private String modelCode = "";
    private String brand = "";
    private String surveyPoint = "";
    private String carrier = "";
    private String driver = "";

    public Order() {
        orderId = "";
        number = "";
        plannedStartDate = "";
        plannedEndDate = "";
        actualStartData = "";
        actualEndData = "";
        vin = "";
        model = "";
        modelCode = "";
        brand = "";
        surveyPoint = "";
        carrier = "";
        driver = "";
    }

    public Order(String orderId,
                 String number,
                 String plannedStartDate,
                 String plannedEndDate,
                 String actualStartData,
                 String actualEndData,
                 String vin,
                 String model,
                 String modelCode,
                 String brand,
                 String surveyPoint,
                 String carrier,
                 String driver) {

        this.orderId = orderId;
        this.number = number;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.actualStartData = actualStartData;
        this.actualEndData = actualEndData;
        this.vin = vin;
        this.model = model;
        this.modelCode = modelCode;
        this.brand = brand;
        this.surveyPoint = surveyPoint;
        this.carrier = carrier;
        this.driver = driver;
    }

    public Order(Parcel in) {
        String[] data = new String[13];
        in.readStringArray(data);
        orderId = data[0];
        number = data[1];
        plannedStartDate = data[2];
        plannedEndDate = data[3];
        actualStartData = data[4];
        actualEndData = data[5];
        vin = data[6];
        model = data[7];
        modelCode = data[8];
        brand = data[9];
        surveyPoint = data[10];
        carrier = data[11];
        driver = data[12];
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(String plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public String getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(String plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public String getActualStartData() {
        return actualStartData;
    }

    public void setActualStartData(String actualStartData) {
        this.actualStartData = actualStartData;
    }

    public String getActualEndData() {
        return actualEndData;
    }

    public void setActualEndData(String actualEndData) {
        this.actualEndData = actualEndData;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSurveyPoint() {
        return surveyPoint;
    }

    public void setSurveyPoint(String surveyPoint) {
        this.surveyPoint = surveyPoint;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{orderId,
                number,
                plannedStartDate,
                plannedEndDate,
                actualStartData,
                actualEndData,
                vin,
                model,
                modelCode,
                brand,
                surveyPoint,
                carrier,
                driver});
    }

    public static final Parcelable.Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
