package com.google.android.libraries.navigation.internal.aga;

import io.grpc.internal.GrpcUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az {
    public static final com.google.android.libraries.navigation.internal.afx.cd a;
    public static final eq b;
    public static final eq c;
    public static final com.google.android.libraries.navigation.internal.yx.br d;
    private static final Set e;

    static {
        Logger.getLogger(az.class.getName());
        e = Collections.unmodifiableSet(EnumSet.of(com.google.android.libraries.navigation.internal.afx.ci.OK, com.google.android.libraries.navigation.internal.afx.ci.INVALID_ARGUMENT, com.google.android.libraries.navigation.internal.afx.ci.NOT_FOUND, com.google.android.libraries.navigation.internal.afx.ci.ALREADY_EXISTS, com.google.android.libraries.navigation.internal.afx.ci.FAILED_PRECONDITION, com.google.android.libraries.navigation.internal.afx.ci.ABORTED, com.google.android.libraries.navigation.internal.afx.ci.OUT_OF_RANGE, com.google.android.libraries.navigation.internal.afx.ci.DATA_LOSS));
        Charset.forName(CharEncoding.US_ASCII);
        com.google.android.libraries.navigation.internal.afx.bl.a(GrpcUtil.TIMEOUT, new ay());
        com.google.android.libraries.navigation.internal.afx.bl.a(GrpcUtil.MESSAGE_ENCODING, com.google.android.libraries.navigation.internal.afx.bo.b);
        com.google.android.libraries.navigation.internal.afx.ak.a(GrpcUtil.MESSAGE_ACCEPT_ENCODING, new ax());
        com.google.android.libraries.navigation.internal.afx.bl.a(GrpcUtil.CONTENT_ENCODING, com.google.android.libraries.navigation.internal.afx.bo.b);
        com.google.android.libraries.navigation.internal.afx.ak.a(GrpcUtil.CONTENT_ACCEPT_ENCODING, new ax());
        com.google.android.libraries.navigation.internal.afx.bl.a("content-length", com.google.android.libraries.navigation.internal.afx.bo.b);
        com.google.android.libraries.navigation.internal.afx.bl.a("content-type", com.google.android.libraries.navigation.internal.afx.bo.b);
        com.google.android.libraries.navigation.internal.afx.bl.a("te", com.google.android.libraries.navigation.internal.afx.bo.b);
        com.google.android.libraries.navigation.internal.afx.bl.a("user-agent", com.google.android.libraries.navigation.internal.afx.bo.b);
        com.google.android.libraries.navigation.internal.yx.bj.b(',').f();
        TimeUnit.SECONDS.toNanos(20L);
        TimeUnit.HOURS.toNanos(2L);
        TimeUnit.SECONDS.toNanos(20L);
        a = new dy();
        b = new au();
        c = new av();
        d = new aw();
    }

    private az() {
    }

    public static String a(String str, int i) {
        try {
            return new URI(null, null, str, i, null, null, null).getAuthority();
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Invalid host or port: " + str + StringUtils.SPACE + i, e2);
        }
    }

    public static boolean b(String str) {
        String strTrim = System.getenv(str);
        if (strTrim == null) {
            strTrim = System.getProperty(str);
        }
        if (strTrim != null) {
            strTrim = strTrim.trim();
        }
        return !com.google.android.libraries.navigation.internal.yx.aq.c(strTrim) && Boolean.parseBoolean(strTrim);
    }

    public static ThreadFactory c(String str) {
        com.google.android.libraries.navigation.internal.aac.cc ccVar = new com.google.android.libraries.navigation.internal.aac.cc();
        ccVar.b();
        ccVar.a = str;
        return com.google.android.libraries.navigation.internal.aac.cc.a(ccVar);
    }
}
