package com.mappls.sdk.direction.ui.plugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes6.dex */
final class n implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ l.c b;

    n(String str, l.c cVar) {
        this.a = str;
        this.b = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        URL url;
        Bitmap bitmapDecodeStream = null;
        try {
            url = new URL(this.a);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())).getInputStream());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.b.a(bitmapDecodeStream);
    }
}
