package com.google.android.libraries.navigation.internal.yx;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bw {
    public static br a(br brVar) {
        if ((brVar instanceof bu) || (brVar instanceof bs)) {
            return brVar;
        }
        return brVar instanceof Serializable ? new bs(brVar) : new bu(brVar);
    }
}
