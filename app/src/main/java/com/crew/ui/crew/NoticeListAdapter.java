package com.crew.ui.crew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.crew.R;

import java.util.ArrayList;

import util.ViewHolder;

/**
 * Created by hyeon-seob on 15. 3. 4..
 * 리스트 뷰에 곡 정보를 추가하기 위한 어댑터 클래스
 * addItem()으로 리스트에 곡 추가
 */

public class NoticeListAdapter extends BaseAdapter{

    private int userId;
    private Context mContext = null;
    private ArrayList<NoticeData> mListData = new ArrayList<>();
    private ViewHolder holder;

    public NoticeListAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public void addItem(String _importance, String _title){
        NoticeData temp = new NoticeData();
        temp.importance = _importance;
        temp.title = _title;
        mListData.add(temp);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_notice, null);

            holder.column1TextView = (TextView) convertView.findViewById(R.id.nameTextView);
            holder.column2TextView = (TextView) convertView.findViewById(R.id.contentTextView);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        final NoticeData mData = mListData.get(position);

        holder.column1TextView.setText(mData.importance);
        holder.column2TextView.setText(mData.title);

        if(position != 0) {

        }

        return convertView;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public NoticeData getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
