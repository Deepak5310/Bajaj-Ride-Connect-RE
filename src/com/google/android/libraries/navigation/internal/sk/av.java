package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class av {
    final /* synthetic */ bf a;

    public av(bf bfVar) {
        this.a = bfVar;
    }

    public final void a() {
        if (this.a.q.get() != 0) {
            bf bfVar = this.a;
            int streamVolume = bfVar.c.getStreamVolume(3) + bfVar.q.get();
            this.a.c.setStreamVolume(3, Math.min(Math.max(streamVolume, 0), this.a.c.getStreamMaxVolume(3)), 1);
            this.a.q.set(0);
        }
        this.a.e(ad.READY_TO_PLAY_ALERT);
        ae aeVar = this.a.i;
        if (aeVar != null) {
            aeVar.r();
        }
    }

    public final void b() {
        this.a.d();
        ae aeVar = this.a.i;
        if (aeVar != null) {
            aeVar.q();
        }
    }
}
