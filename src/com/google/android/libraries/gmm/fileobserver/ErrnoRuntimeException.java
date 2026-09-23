package com.google.android.libraries.gmm.fileobserver;

import android.system.OsConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class ErrnoRuntimeException extends RuntimeException {
    ErrnoRuntimeException(String str, int i) {
        super(OsConstants.errnoName(i) + " from " + str);
    }
}
