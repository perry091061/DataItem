package com.dataitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dataitem.model.DataItem;
import com.dataitem.model.DataItemAdapter;
import com.dataitem.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return (o1.getItemName().compareTo(o2.getItemName()));
            }
        });

        for(DataItem item : dataItemList) {
            itemNames.add(item.getItemName());
        }


        DataItemAdapter adapter = new DataItemAdapter(this, dataItemList);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);


    }

}
