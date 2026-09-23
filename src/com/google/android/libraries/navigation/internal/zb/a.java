package com.google.android.libraries.navigation.internal.zb;

import com.google.android.libraries.navigation.internal.zb.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a<API extends z<API>> {
    public final com.google.android.libraries.navigation.internal.zd.j a;

    protected a(com.google.android.libraries.navigation.internal.zd.j jVar) {
        this.a = jVar;
    }

    public static void b(String str, com.google.android.libraries.navigation.internal.zd.f fVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date(TimeUnit.NANOSECONDS.toMillis(fVar.e()))));
        sb.append(": logging error [");
        com.google.android.libraries.navigation.internal.zd.i.DEFAULT.a(fVar.f(), sb);
        sb.append("]: ");
        sb.append(str);
        System.err.println(sb);
        System.err.flush();
    }

    protected final String a() {
        return this.a.a();
    }

    protected final boolean c(Level level) {
        return this.a.d(level);
    }
}
