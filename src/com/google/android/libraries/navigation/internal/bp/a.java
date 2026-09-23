package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.fv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static boolean a(com.google.android.libraries.navigation.internal.adr.bq bqVar) {
        if ((bqVar.b & 1) == 0) {
            return false;
        }
        fv fvVar = bqVar.c;
        if (fvVar == null) {
            fvVar = fv.a;
        }
        if (!bm.a(fvVar)) {
            return false;
        }
        com.google.android.libraries.navigation.internal.adr.bo boVar = bqVar.d;
        if (boVar == null) {
            boVar = com.google.android.libraries.navigation.internal.adr.bo.a;
        }
        if (!c(boVar)) {
            return false;
        }
        com.google.android.libraries.navigation.internal.adr.bo boVar2 = bqVar.e;
        if (boVar2 == null) {
            boVar2 = com.google.android.libraries.navigation.internal.adr.bo.a;
        }
        return c(boVar2);
    }

    public static boolean b(com.google.android.libraries.navigation.internal.adr.bs bsVar) {
        int i = bsVar.b;
        if ((i & 1) == 0 || (i & 2) == 0) {
            return false;
        }
        com.google.android.libraries.navigation.internal.adr.r rVar = bsVar.c;
        if (rVar == null) {
            rVar = com.google.android.libraries.navigation.internal.adr.r.a;
        }
        int i2 = rVar.b;
        if ((i2 & 4) == 0 || (i2 & 16) == 0 || (bsVar.b & 8) == 0) {
            return false;
        }
        fv fvVar = bsVar.d;
        if (fvVar == null) {
            fvVar = fv.a;
        }
        return bm.a(fvVar);
    }

    public static boolean c(com.google.android.libraries.navigation.internal.adr.bo boVar) {
        int i = boVar.b;
        return ((i & 2) == 0 || (i & 8) == 0) ? false : true;
    }
}
