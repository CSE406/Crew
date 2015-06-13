package com.crew.ui.crew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.crew.R;

import java.util.ArrayList;

/**
 * Created by hyeon-seob on 15. 3. 4..
 * 리스트 뷰에 곡 정보를 추가하기 위한 어댑터 클래스
 * addItem()으로 리스트에 곡 추가
 */

public class TodayListAdapter extends BaseAdapter{

    private int userId;
    private Context mContext = null;
    private ArrayList<TodayData> mListData = new ArrayList<>();
    private ViewHolder2 holder;

    public TodayListAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public void addItem(String _time, String _locaiton, String _content){
        TodayData temp = new TodayData();
        temp.time = _time;
        temp.location = _locaiton;
        temp.content = _content;
        mListData.add(temp);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder2();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_crew_today, null);

            holder.column1TextView = (TextView) convertView.findViewById(R.id.timeTextView);
            holder.column2TextView = (TextView) convertView.findViewById(R.id.locationTextView);
            holder.column3TextView = (TextView) convertView.findViewById(R.id.contentTextView);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder2) convertView.getTag();
        }

        final TodayData mData = mListData.get(position);

        holder.column1TextView.setText(mData.time);
        holder.column2TextView.setText(mData.location);
        holder.column3TextView.setText(mData.content);

        return convertView;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public TodayData getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
