package com.mappls.sdk.traffic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BeaconPacket {

    @SerializedName("probes")
    @Expose
    private List<ProbeWrapper> probes = null;

    public List<ProbeWrapper> getProbes() {
        return this.probes;
    }

    public void setProbes(List<ProbeWrapper> list) {
        this.probes = list;
    }
}
