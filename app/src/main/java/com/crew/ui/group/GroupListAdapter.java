package com.crew.ui.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.crew.R;

import java.util.ArrayList;

import util.ViewHolder;

/**
 * Created by hyeon-seob on 15. 3. 4..
 * 리스트 뷰에 곡 정보를 추가하기 위한 어댑터 클래스
 * addItem()으로 리스트에 곡 추가
 */

public class GroupListAdapter extends BaseAdapter{

    private int userId;
    private Context mContext = null;
    private ArrayList<GroupData> mListData = new ArrayList<>();
    private ViewHolder holder;
    private ProgressBar progressBar;
    private int ratingCount;
    private TextView textView;
    private ImageButton rightButton;

    public GroupListAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public void addItem(String _id, String _artist_id, String _albumArtURL, String _title, String _artist, int _rating){
        GroupData temp = new GroupData();
        temp.id = _id;
        temp.artist_id = _artist_id;
        temp.title = _title;
        temp.artist = _artist;
        temp.rating = _rating;
        temp.albumUrl = _albumArtURL;
        temp.albumArt = null;
        mListData.add(temp);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_group, null);

            holder.albumImageView = (ImageView) convertView.findViewById(R.id.albumArtView);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
            holder.artistTextView = (TextView) convertView.findViewById(R.id.artistTextView);
            holder.ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        final GroupData mData = mListData.get(position);

        holder.titleTextView.setText(mData.title);
        holder.artistTextView.setText(mData.artist);
        holder.ratingBar.setProgress(mData.rating);

        holder.position = position;

        // 앨범아트 가져오기
        // Spotify에 앨범아트 정보가 있을 경우

        holder.ratingBar.setTag(position);
        return convertView;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public GroupData getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
