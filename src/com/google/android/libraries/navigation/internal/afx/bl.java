package com.google.android.libraries.navigation.internal.afx;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bl {
    public static final /* synthetic */ int b = 0;
    private static final BitSet c;
    public final String a;
    private final String d;

    static {
        BitSet bitSet = new BitSet(127);
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        for (char c2 = '0'; c2 <= '9'; c2 = (char) (c2 + 1)) {
            bitSet.set(c2);
        }
        for (char c3 = 'a'; c3 <= 'z'; c3 = (char) (c3 + 1)) {
            bitSet.set(c3);
        }
        c = bitSet;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0056 A[SYNTHETIC] */
    public bl(String str, boolean z) {
        this.d = str;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        com.google.android.libraries.navigation.internal.yx.ar.r(lowerCase, "name");
        com.google.android.libraries.navigation.internal.yx.ar.b(!lowerCase.isEmpty(), "token must have at least 1 tchar");
        if (lowerCase.equals("connection")) {
            bo.a.logp(Level.WARNING, "io.grpc.Metadata$Key", "validateName", "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
        }
        int i = 0;
        while (i < lowerCase.length()) {
            char cCharAt = lowerCase.charAt(i);
            if (z && cCharAt == ':') {
                if (i == 0) {
                    i = 0;
                } else {
                    cCharAt = ':';
                    if (c.get(cCharAt)) {
                        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.yx.bq.a("Invalid character '%s' in key name '%s'", Character.valueOf(cCharAt), lowerCase));
                    }
                }
            } else if (c.get(cCharAt)) {
                throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.yx.bq.a("Invalid character '%s' in key name '%s'", Character.valueOf(cCharAt), lowerCase));
            }
            i++;
        }
        this.a = lowerCase;
        Charset charset = StandardCharsets.US_ASCII;
    }

    public static void a(String str, bj bjVar) {
        new bi(str, bjVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((bl) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Key{name='" + this.a + "'}";
    }
}
