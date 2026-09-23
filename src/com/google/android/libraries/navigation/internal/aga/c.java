package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public final com.google.android.libraries.navigation.internal.afx.ar a;
    public com.google.android.libraries.navigation.internal.afx.az b;
    public com.google.android.libraries.navigation.internal.afx.ba c;
    final /* synthetic */ h d;

    public c(h hVar, com.google.android.libraries.navigation.internal.afx.ar arVar) {
        this.d = hVar;
        this.a = arVar;
        com.google.android.libraries.navigation.internal.afx.ba baVarA = hVar.a.a(hVar.b);
        this.c = baVarA;
        if (baVarA != null) {
            this.b = baVarA.a(arVar);
            return;
        }
        throw new IllegalStateException("Could not find policy '" + hVar.b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
    }
}
