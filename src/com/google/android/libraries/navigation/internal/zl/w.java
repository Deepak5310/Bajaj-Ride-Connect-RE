package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w extends b implements Serializable {
    private final MessageDigest a;
    private final int b;
    private final boolean c;
    private final String d;

    public w(String str, int i, String str2) {
        ar.q("Hashing.sha256()");
        this.d = "Hashing.sha256()";
        MessageDigest messageDigestF = f(str);
        this.a = messageDigestF;
        int digestLength = messageDigestF.getDigestLength();
        boolean z = false;
        if (i >= 4 && i <= digestLength) {
            z = true;
        }
        ar.g(z, "bytes (%s) must be >= 4 and < %s", i, digestLength);
        this.b = i;
        this.c = g(messageDigestF);
    }

    private static MessageDigest f(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private static boolean g(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.android.libraries.navigation.internal.zl.m
    public final n e() {
        if (this.c) {
            try {
                return new u((MessageDigest) this.a.clone(), this.b);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new u(f(this.a.getAlgorithm()), this.b);
    }

    public final String toString() {
        return this.d;
    }

    Object writeReplace() {
        return new v(this.a.getAlgorithm(), this.b, this.d);
    }

    public w() {
        MessageDigest messageDigestF = f("SHA-256");
        this.a = messageDigestF;
        this.b = messageDigestF.getDigestLength();
        this.d = "Hashing.sha256()";
        this.c = g(messageDigestF);
    }
}
