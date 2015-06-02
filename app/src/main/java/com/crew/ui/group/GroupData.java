package com.crew.ui.group;

import android.graphics.Bitmap;

/**
 * Created by hyeon-seob on 15. 3. 4..
 * 곡 정보를 저장하는 클래스
 */
public class GroupData {
    public String id;
    public String artist_id;
    public String albumUrl;
    public Bitmap albumArt;
    public String title;
    public String artist;
    public String mGenre;
    public int rating;

    public void setAlbumArt(Bitmap mAlbumArt) { albumArt = mAlbumArt; }
}
