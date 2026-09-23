package com.bajajconnect.models;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public class Item_song {
    private Bundle extras;
    private long id;
    private String mediaId;
    private Uri mediaUri;
    private String subtitle;
    private String title;

    public Item_song(String str, String str2, long j, Uri uri, Bundle bundle, String str3) {
        this.title = str;
        this.subtitle = str2;
        this.id = j;
        this.mediaUri = uri;
        this.extras = bundle;
        this.mediaId = str3;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public long getId() {
        return this.id;
    }

    public Uri getMediaUri() {
        return this.mediaUri;
    }

    public void setMediaUri(Uri uri) {
        this.mediaUri = uri;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public String getMediaId() {
        return this.mediaId;
    }
}
