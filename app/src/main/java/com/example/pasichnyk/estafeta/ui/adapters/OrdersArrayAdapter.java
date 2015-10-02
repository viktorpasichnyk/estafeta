package com.example.pasichnyk.estafeta.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pasichnyk.estafeta.R;
import com.example.pasichnyk.estafeta.models.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OrdersArrayAdapter extends ArrayAdapter<Order> {

    public OrdersArrayAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Order orderItem = getItem(position);
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.order_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.orderVinTxt = (TextView) convertView.findViewById(R.id.order_vin_txt);
            viewHolder.orderModelBrandTxt = (TextView) convertView.findViewById(R.id.order_model_brand_txt);
            viewHolder.orderDriverTxt = (TextView) convertView.findViewById(R.id.order_driver_txt);
            viewHolder.orderNumberTxt = (TextView) convertView.findViewById(R.id.order_number_txt);
            viewHolder.orderStartDateTxt = (TextView) convertView.findViewById(R.id.order_start_date);
            viewHolder.downloadImage = (ImageView) convertView.findViewById(R.id.download_image);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.orderVinTxt.setText(orderItem.getVin());
        viewHolder.orderModelBrandTxt.setText(orderItem.getBrand() + " " + orderItem.getModel());
        viewHolder.orderDriverTxt.setText(orderItem.getDriver());
        viewHolder.orderNumberTxt.setText(orderItem.getNumber());
        viewHolder.orderStartDateTxt.setText(changeDateFormat(orderItem.getActualStartData()));


        return convertView;
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


    private static class ViewHolder {

        TextView orderVinTxt;
        TextView orderModelBrandTxt;
        TextView orderDriverTxt;
        TextView orderNumberTxt;
        TextView orderStartDateTxt;
        ImageView downloadImage;

    }
}
