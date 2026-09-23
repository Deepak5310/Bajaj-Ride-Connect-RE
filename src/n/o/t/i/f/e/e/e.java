package n.o.t.i.f.e.e;

import android.content.Context;
import app.notifee.core.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class e {
    public static Context a;

    public static void a(Context context) {
        Logger.d("context", "received application context");
        a = context;
    }
}
