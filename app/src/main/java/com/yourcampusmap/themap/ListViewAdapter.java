package com.yourcampusmap.themap;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<CampusName> campusnamelist = null;
    private ArrayList<CampusName> arraylist;

    public ListViewAdapter(Context context, List<CampusName> campusnamelist) {
        mContext = context;
        this.campusnamelist = campusnamelist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<CampusName>();
        this.arraylist.addAll(campusnamelist);
    }

    public class ViewHolder {
        TextView state;
        TextView uni;
        TextView campusname;
    }

    @Override
    public int getCount() {
        return campusnamelist.size();
    }

    @Override
    public CampusName getItem(int position) {
        return campusnamelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.state = (TextView) view.findViewById(R.id.state);
            holder.uni = (TextView) view.findViewById(R.id.uni);
            holder.campusname = (TextView) view.findViewById(R.id.campusname);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.state.setText(campusnamelist.get(position).getRank());
        holder.uni.setText(campusnamelist.get(position).getCountry());

        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                // Pass all data state
                intent.putExtra("state", (campusnamelist.get(position).getRank()));
                // Pass all data uni
                intent.putExtra("uni", (campusnamelist.get(position).getCountry()));

                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        campusnamelist.clear();
        if (charText.length() == 0) {
            campusnamelist.addAll(arraylist);
        } else {
            for (CampusName wp : arraylist) {
                if (wp.getCountry().toLowerCase(Locale.getDefault()).contains(charText)) {
                    campusnamelist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
