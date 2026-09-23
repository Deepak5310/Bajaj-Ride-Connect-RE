package com.google.android.libraries.navigation.internal.xt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq {
    final /* synthetic */ ar a;
    private final ax b;

    public aq(ar arVar, ax axVar) {
        this.a = arVar;
        this.b = axVar;
    }

    public final void a(ag agVar) {
        boolean z = false;
        for (w wVar : this.a.d) {
            if (w.a(agVar.b) && !z) {
                this.b.a();
                z = true;
            }
        }
    }
}
