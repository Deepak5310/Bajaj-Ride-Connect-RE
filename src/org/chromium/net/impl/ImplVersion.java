package org.chromium.net.impl;

/* JADX INFO: loaded from: classes5.dex */
public class ImplVersion {
    private static final int API_LEVEL = 26;
    private static final String CRONET_VERSION = "119.0.6045.31";
    private static final String LAST_CHANGE = "c76b9b6a188d43a09957c13e835bc6a2fe7ac772-refs/branch-heads/6045@{#604}";

    public static int getApiLevel() {
        return 26;
    }

    private ImplVersion() {
    }

    public static String getCronetVersionWithLastChange() {
        return "119.0.6045.31@c76b9b6a";
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }
}
