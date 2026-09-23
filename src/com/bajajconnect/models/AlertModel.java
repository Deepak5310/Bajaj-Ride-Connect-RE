package com.bajajconnect.models;

import com.bajajconnect.enums.Alert;

/* JADX INFO: loaded from: classes3.dex */
public class AlertModel {
    private int id;
    private String name;
    private long timestamp;
    private Alert type;

    public AlertModel(int i, Alert alert, String str, long j) {
        this.type = alert;
        this.name = str;
        this.timestamp = j;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public void setType(Alert alert) {
        this.type = alert;
    }

    public Alert getType() {
        return this.type;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
