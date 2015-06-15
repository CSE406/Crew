package com.crew.ui.crew;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.crew.R;
import com.crew.ui.main.ViewHolder;

import java.util.ArrayList;

/**
 * Created by hyeon-seob on 15. 3. 4..
 * 리스트 뷰에 곡 정보를 추가하기 위한 어댑터 클래스
 * addItem()으로 리스트에 곡 추가
 */

public class CrewListAdapter extends BaseAdapter{

    private int userId;
    private Context mContext = null;
    private ArrayList<CrewData> mListData = new ArrayList<>();
    private ViewHolder holder;

    public CrewListAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public void addItem(int _id, String _div, String _name){
        CrewData temp = new CrewData();
        temp.id = _id;
        temp.div = _div;
        temp.name = _name;
        mListData.add(temp);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_crew, null);

            holder.column1TextView = (TextView) convertView.findViewById(R.id.divTextView);
            holder.column2TextView = (TextView) convertView.findViewById(R.id.nameTextView);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        final CrewData mData = mListData.get(position);

        holder.column1TextView.setText(mData.div);
        holder.column2TextView.setText(mData.name);
        holder.column2TextView.setTag(mData.id);

        holder.column2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CrewDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("group_id", (int) ((TextView)v).getTag());
                intent.putExtra("crewName", ((TextView)v).getText());
                mContext.startActivity(intent);
                }
        });

        return convertView;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public CrewData getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
