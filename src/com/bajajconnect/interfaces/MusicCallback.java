package com.bajajconnect.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import com.bajajconnect.enums.music.PlayStatus;
import com.bajajconnect.models.Item_song;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface MusicCallback {
    void onActiveSessionFound(Context context);

    void onArtworkReady(Bitmap bitmap);

    void onCurrentPositionChange(int i, Long l);

    void onCurrentSessionDestroyed();

    void onFetchSpotifyPlaylist();

    void onMetadataChange(String str, int i, String str2, String str3, long j, Bitmap bitmap);

    void onPlaybackStateChange(PlayStatus playStatus);

    void onQueueItemChange(ArrayList<Item_song> arrayList, String str);

    void onSessionReady(String str);

    void onSongSelected(int i);

    void onTrackListRequested(int i);

    default void onMusicAppKilled() {
        onCurrentSessionDestroyed();
    }
}
