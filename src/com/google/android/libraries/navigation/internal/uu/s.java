package com.google.android.libraries.navigation.internal.uu;

import android.content.SharedPreferences;
import com.google.android.libraries.navigation.internal.iv.ab;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ t a;

    public s(t tVar) {
        this.a = tVar;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        p pVar;
        p pVar2;
        if (str.equals(ab.aN.toString()) || str.equals(ab.N.toString())) {
            t tVar = this.a;
            boolean z = tVar.b;
            tVar.a();
            t tVar2 = this.a;
            boolean z2 = tVar2.b;
            if (z2 == z || (pVar = tVar2.e) == null) {
                return;
            }
            pVar.a(z2);
            return;
        }
        if (str.equals(ab.aP.toString())) {
            t tVar3 = this.a;
            boolean z3 = tVar3.c;
            tVar3.b();
            t tVar4 = this.a;
            boolean z4 = tVar4.c;
            if (z4 == z3 || (pVar2 = tVar4.e) == null) {
                return;
            }
            pVar2.b(z4);
        }
    }
}
