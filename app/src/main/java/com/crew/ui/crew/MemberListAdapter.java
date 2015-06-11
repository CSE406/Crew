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

public class MemberListAdapter extends BaseAdapter{

    private int userId;
    private Context mContext = null;
    private ArrayList<MemberData> mListData = new ArrayList<>();
    private ViewHolder2 holder;

    public MemberListAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public void addItem(String _name, String _role, String _email){
        MemberData temp = new MemberData();
        temp.name = _name;
        temp.role = _role;
        temp.email = _email;
        mListData.add(temp);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder2();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_member, null);

            holder.column1TextView = (TextView) convertView.findViewById(R.id.nameTextView);
            holder.column2TextView = (TextView) convertView.findViewById(R.id.roleTextView);
            holder.column3TextView = (TextView) convertView.findViewById(R.id.emailTextView);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder2) convertView.getTag();
        }

        final MemberData mData = mListData.get(position);

        holder.column1TextView.setText(mData.name);
        holder.column2TextView.setText(mData.role);
        holder.column3TextView.setText(mData.email);

        if(position != 0) {

        }

        return convertView;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public MemberData getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
