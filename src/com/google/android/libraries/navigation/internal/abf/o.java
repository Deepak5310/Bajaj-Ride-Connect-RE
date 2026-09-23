package com.google.android.libraries.navigation.internal.abf;

import com.drew.metadata.wav.WavDirectory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    static final int a;
    public static final /* synthetic */ int b = 0;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x006c  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static {
        byte b2;
        String strB = com.google.android.libraries.navigation.internal.yx.c.b(y.b.a("debug.mapview.logs", "NOTHING"));
        int i = 2;
        switch (strB.hashCode()) {
            case -1938386595:
                if (!strB.equals("PERTAG")) {
                    b2 = -1;
                } else {
                    b2 = 7;
                }
                break;
            case -1447660627:
                if (!strB.equals("NOTHING")) {
                    b2 = -1;
                } else {
                    b2 = 1;
                }
                break;
            case 64897:
                if (!strB.equals("ALL")) {
                    b2 = -1;
                } else {
                    b2 = 0;
                }
                break;
            case 2251950:
                if (!strB.equals(WavDirectory.LIST_INFO)) {
                    b2 = -1;
                } else {
                    b2 = 4;
                }
                break;
            case 2656902:
                if (!strB.equals("WARN")) {
                    b2 = -1;
                } else {
                    b2 = 5;
                }
                break;
            case 64921139:
                if (!strB.equals("DEBUG")) {
                    b2 = -1;
                } else {
                    b2 = 3;
                }
                break;
            case 66247144:
                if (!strB.equals("ERROR")) {
                    b2 = -1;
                } else {
                    b2 = 6;
                }
                break;
            case 1069090146:
                if (!strB.equals("VERBOSE")) {
                    b2 = -1;
                } else {
                    b2 = 2;
                }
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                i = 1;
                break;
            case 1:
            default:
                i = 0;
                break;
            case 2:
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 6:
                i = 6;
                break;
            case 7:
                i = 7;
                break;
        }
        a = i;
    }
}
