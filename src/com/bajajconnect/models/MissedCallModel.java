package com.bajajconnect.models;

/* JADX INFO: loaded from: classes3.dex */
public class MissedCallModel {
    private int id;
    private String name;
    private String number;
    private long timestamp;

    public MissedCallModel(int i, String str, String str2, long j) {
        this.name = str;
        this.number = str2;
        this.timestamp = j;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
