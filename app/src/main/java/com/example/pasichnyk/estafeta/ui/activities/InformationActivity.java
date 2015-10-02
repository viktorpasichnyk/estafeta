package com.example.pasichnyk.estafeta.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pasichnyk.estafeta.R;
import com.example.pasichnyk.estafeta.models.Order;
import com.example.pasichnyk.estafeta.ui.fragments.FragmentTabsFragmentSupport;


public class InformationActivity extends BaseActivity {

    int lengthOfTitleVin = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Order order = getIntent().getParcelableExtra(MainActivity.ORDER_BUNDLE_KEY);
        Bundle bundle = new Bundle();
        bundle.putParcelable(MainActivity.ORDER_BUNDLE_KEY, order);

        getSupportActionBar().setTitle("..." + order.getVin().substring(order.getVin().length() - lengthOfTitleVin, order.getVin().length()));

        FragmentManager fm = getSupportFragmentManager();
        FragmentTabsFragmentSupport fragmentTabsFragmentSupport = new FragmentTabsFragmentSupport();
        fragmentTabsFragmentSupport.setArguments(bundle);
        fm.beginTransaction().replace(R.id.content_frame, fragmentTabsFragmentSupport).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item_send:
                Toast.makeText(this, R.string.action_send, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
