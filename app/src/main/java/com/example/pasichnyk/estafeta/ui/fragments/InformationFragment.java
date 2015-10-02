package com.example.pasichnyk.estafeta.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pasichnyk.estafeta.R;
import com.example.pasichnyk.estafeta.models.Order;
import com.example.pasichnyk.estafeta.ui.activities.MainActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class InformationFragment extends Fragment {

    Order order;
    TextView typeTaskTitile;
    TextView typeTaskTxt;
    TextView startTimeTitle;
    TextView startTimeTxt;
    TextView surveyDateTitle;
    TextView surveyDateTxt;
    TextView vinTitle;
    TextView vinTxt;
    TextView brandTitle;
    TextView brandTxt;
    TextView modelTitle;
    TextView modelTxt;
    TextView modelCodeTitle;
    TextView modelCodeTxt;
    TextView placeInspectionTitle;
    TextView getPlaceInspectionTxt;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_information, container, false);
        order = getArguments().getParcelable(MainActivity.ORDER_BUNDLE_KEY);

        typeTaskTitile = (TextView) rootView.findViewById(R.id.info_frag_type_task_title);
        typeTaskTxt = (TextView) rootView.findViewById(R.id.info_frag_type_task_txt);
        startTimeTitle = (TextView) rootView.findViewById(R.id.info_frag_planned_start_title);
        startTimeTxt = (TextView) rootView.findViewById(R.id.info_frag_planned_start_txt);
        surveyDateTitle = (TextView) rootView.findViewById(R.id.info_frag_survey_date_title);
        surveyDateTxt = (TextView) rootView.findViewById(R.id.info_frag_survey_date_txt);
        vinTitle = (TextView) rootView.findViewById(R.id.info_frag_vin_title);
        vinTxt = (TextView) rootView.findViewById(R.id.info_frag_vin_txt);
        brandTitle = (TextView) rootView.findViewById(R.id.info_frag_brand_title);
        brandTxt = (TextView) rootView.findViewById(R.id.info_frag_brand_txt);
        modelTitle = (TextView) rootView.findViewById(R.id.info_frag_model_title);
        modelTxt = (TextView) rootView.findViewById(R.id.info_frag_model_txt);
        modelCodeTitle = (TextView) rootView.findViewById(R.id.info_frag_model_code_title);
        modelCodeTxt = (TextView) rootView.findViewById(R.id.info_frag_model_code_txt);
        placeInspectionTitle = (TextView) rootView.findViewById(R.id.info_frag_place_inspection_title);
        getPlaceInspectionTxt = (TextView) rootView.findViewById(R.id.info_frag_place_inspection_txt);


        typeTaskTitile.setText(R.string.type_of_task_title);
        typeTaskTxt.setText(R.string.type_of_task_txt);
        startTimeTitle.setText(R.string.planned_start_title);
        startTimeTxt.setText(changeDateFormat(order.getPlannedStartDate()));
        surveyDateTitle.setText(R.string.survey_date_title);
        surveyDateTxt.setText(changeDateFormat(order.getPlannedEndDate()));
        vinTitle.setText(R.string.vin_title);
        vinTxt.setText(order.getVin());
        brandTitle.setText(R.string.Brand);
        brandTxt.setText(order.getBrand());
        modelTitle.setText(R.string.model_title);
        modelTxt.setText(order.getModel());
        modelCodeTitle.setText(R.string.model_code_title);
        modelCodeTxt.setText(order.getModelCode());
        placeInspectionTitle.setText(R.string.place_inspection_title);
        getPlaceInspectionTxt.setText(order.getSurveyPoint());

        return rootView;
    }

    private String changeDateFormat(String date) {
        Date newDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            newDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String resultDate = format.format(newDate);

        return resultDate;
    }
}
