package com.dataitem.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataitem.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by perrydavies on 27/02/2018.
 */

public class DataItemAdapter extends ArrayAdapter {
    List<DataItem> mDataItems;
    LayoutInflater mIinflater;

    public DataItemAdapter(@NonNull Context context, @NonNull List<DataItem> objects) {
        super(context, R.layout.list_item, objects);

        mDataItems = objects;

        mIinflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = mIinflater.inflate(R.layout.list_item, parent, false);

        }

        TextView tvName = (TextView)convertView.findViewById(R.id.itemNameText);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        DataItem item = mDataItems.get(position);
        tvName.setText(item.getItemName());
        //imageView.setImageResource(R.drawable.apple_pie);
        String imageName = item.getImage();
        try (InputStream inputStream = getContext().getAssets().open(imageName);) {

            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
