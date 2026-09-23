package com.google.android.libraries.navigation.internal.afx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class az {
    public static final b a = new b("internal:health-checking-config");
    public static final an b = new an("internal:health-check-consumer-listener", null);
    public static final an c = new an("internal:disable-subchannel-reconnect", Boolean.FALSE);
    public static final b d = new b("internal:has-health-check-producer-listener");
    public static final b e = new b("io.grpc.IS_PETIOLE_POLICY");
    private int f;

    public cl a(av avVar) {
        throw null;
    }

    public abstract void b(cl clVar);

    public void c(av avVar) {
        int i = this.f;
        this.f = i + 1;
        if (i == 0) {
            a(avVar);
        }
        this.f = 0;
    }

    public void d() {
    }

    public abstract void e();
}
