package com.bajajconnect.models;

/* JADX INFO: loaded from: classes3.dex */
public class SongInfo {
    private String primaryInfo;
    private String secondaryInfo;

    public SongInfo(String str, String str2) {
        this.primaryInfo = str;
        this.secondaryInfo = str2;
    }

    public String getPrimaryInfo() {
        return this.primaryInfo;
    }

    public void setPrimaryInfo(String str) {
        this.primaryInfo = str;
    }

    public String getSecondaryInfo() {
        return this.secondaryInfo;
    }

    public void setSecondaryInfo(String str) {
        this.secondaryInfo = str;
    }
}
