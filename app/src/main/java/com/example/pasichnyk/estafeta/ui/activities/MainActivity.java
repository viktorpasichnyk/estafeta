package com.example.pasichnyk.estafeta.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.pasichnyk.estafeta.tools.JsonParser;
import com.example.pasichnyk.estafeta.tools.MyBasicAuthJsonArrayRequest;
import com.example.pasichnyk.estafeta.ui.adapters.OrdersArrayAdapter;
import com.example.pasichnyk.estafeta.R;
import com.example.pasichnyk.estafeta.models.Order;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private static final String LOG_TAG = "myLogs";
    private static final String OUR_URL = "http://rem.estafeta.org:9081/amt/api/mobilesurveytasks/gettestsurveytasks";
    private static final String USER_NAME = "admin";
    private static final String COMPANY_ID = "9F346DDB-8FF8-4F42-8221-6E03D6491756";
    private static final String PASSWORD = "1";
    private JSONArray jsonArray;
    public static final String ORDER_BUNDLE_KEY = "Order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            selectItem(0);
        }

        RequestQueue queue = Volley.newRequestQueue(this);

        MyBasicAuthJsonArrayRequest jsonArrayRequest = new MyBasicAuthJsonArrayRequest(OUR_URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                // TODO Auto-generated method stub
                jsonArray = response;
                final FragmentManager fm = getSupportFragmentManager();
                ArrayList<Order> ordersList = null;

                try {
                    ordersList = (ArrayList<Order>) JsonParser.getOrdersListFromJson(jsonArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                ListView listView = (ListView) fm.findFragmentById(R.id.content_frame).getView().findViewById(R.id.list_first_fragment);
                OrdersArrayAdapter ordersArrayAdapter = new OrdersArrayAdapter(getApplicationContext());
                ordersArrayAdapter.addAll(ordersList);
                listView.setAdapter(ordersArrayAdapter);


                final ArrayList<Order> finalOrdersList = ordersList;
                AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getBaseContext(), InformationActivity.class);
                        intent.putExtra(ORDER_BUNDLE_KEY, finalOrdersList.get(position));
                        startActivity(intent);

                    }
                };
                listView.setOnItemClickListener(onItemClickListener);

                Log.i(LOG_TAG, "fm.getFragments().size(): " + fm.getFragments().size());
                Log.i(LOG_TAG, "in onResponse()!!!");
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Log.i(LOG_TAG, "onErrorResponse " + error.getMessage());

            }
        }, USER_NAME, PASSWORD, COMPANY_ID);
        queue.add(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}



