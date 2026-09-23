package com.mappls.sdk.navigation.ui.map.route;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements Runnable {
    public final /* synthetic */ ReportDetails a;
    public final /* synthetic */ String b;
    public final /* synthetic */ o c;

    public p(ReportDetails reportDetails, String str, o oVar) {
        this.a = reportDetails;
        this.b = str;
        this.c = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        URL url;
        try {
            url = new URL(this.a.getReportIcon("24px"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())).getInputStream());
            com.mappls.sdk.navigation.ui.g gVar = com.mappls.sdk.navigation.ui.g.b;
            gVar.a.put(this.b, bitmapDecodeStream);
            this.c.a.b.getStyle(new n(this.b, bitmapDecodeStream));
        } catch (IOException e2) {
            e2.printStackTrace();
            Timber.e("There is some error in loading image", new Object[0]);
        }
    }
}
