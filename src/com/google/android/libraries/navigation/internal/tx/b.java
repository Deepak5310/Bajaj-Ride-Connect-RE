package com.google.android.libraries.navigation.internal.tx;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final a a(URL url) throws IOException {
        return new a((HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())));
    }
}
