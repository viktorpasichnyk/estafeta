package com.example.pasichnyk.estafeta.tools;

import com.example.pasichnyk.estafeta.models.Order;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonParser {

    private final static String ID = "Id";
    private final static String NUMBER = "Number";
    private final static String PLANNED_START_DATE = "PlannedStartDate";
    private final static String PLANNED_END_DATE = "PlannedEndDate";
    private final static String ACTUAL_START_DATE = "ActualStartDate";
    private final static String ACTUAL_END_DATE = "ActualEndDate";
    private final static String VIN = "Vin";
    private final static String MODEL = "Model";
    private final static String MODEL_CODE = "ModelCode";
    private final static String BRAND = "Brand";
    private final static String SURVEY_POINT = "SurveyPoint";
    private final static String CARRIER = "Carrier";
    private final static String DRIVER = "Driver";


    public static List<Order> getOrdersListFromJson(JSONArray jsonArray) throws JSONException {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject orderItemObject = jsonArray.getJSONObject(i);
            Order order = new Order();
            order.setOrderId(orderItemObject.getString(ID));
            order.setNumber(orderItemObject.getString(NUMBER));
            order.setPlannedStartDate(orderItemObject.getString(PLANNED_START_DATE));
            order.setPlannedEndDate(orderItemObject.getString(PLANNED_END_DATE));
            order.setActualStartData(orderItemObject.getString(ACTUAL_START_DATE));
            order.setActualEndData(orderItemObject.getString(ACTUAL_END_DATE));
            order.setVin(orderItemObject.getString(VIN));
            order.setModel(orderItemObject.getString(MODEL));
            order.setModelCode(orderItemObject.getString(MODEL_CODE));
            order.setBrand(orderItemObject.getString(BRAND));
            order.setSurveyPoint(orderItemObject.getString(SURVEY_POINT));
            order.setCarrier(orderItemObject.getString(CARRIER));
            order.setDriver(orderItemObject.getString(DRIVER));
            orderList.add(order);
        }

        return orderList;
    }
}
