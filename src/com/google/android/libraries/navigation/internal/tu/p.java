package com.google.android.libraries.navigation.internal.tu;

import com.google.android.libraries.navigation.internal.sk.eo;
import com.google.android.libraries.navigation.internal.yx.bp;
import com.mappls.sdk.services.account.Region;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements u {
    private static final int b = (int) TimeUnit.SECONDS.toMillis(2);
    public com.google.android.libraries.navigation.internal.oe.x a = null;
    private final com.google.android.libraries.navigation.internal.fz.d c;
    private final eo d;
    private final com.google.android.libraries.navigation.internal.tx.b e;

    public p(com.google.android.libraries.navigation.internal.fz.d dVar, eo eoVar, com.google.android.libraries.navigation.internal.tx.b bVar) {
        this.c = dVar;
        this.d = eoVar;
        this.e = bVar;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.tu.u
    public final boolean b(t tVar, String str) {
        String language;
        String strReplace;
        File file = new File(str);
        String str2 = ((g) tVar).a;
        try {
            try {
                Locale locale = Locale.getDefault();
                com.google.android.libraries.navigation.internal.oe.x xVar = this.a;
                com.google.android.libraries.navigation.internal.fz.d dVar = this.c;
                eo eoVar = this.d;
                String strReplace2 = str2.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", StringUtils.SPACE);
                if (xVar == null) {
                    xVar = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
                }
                String str3 = dVar.R().g;
                if (str3 == null) {
                    strReplace = null;
                } else {
                    if (bp.c(locale.getCountry())) {
                        language = locale.getLanguage();
                    } else {
                        language = locale.getLanguage() + "-" + locale.getCountry();
                    }
                    strReplace = str3.replace("$VOICE", URLEncoder.encode(eoVar.e() ? eoVar.a() : dVar.R().f321n, "UTF-8")).replace("$LOCALE", URLEncoder.encode(language, "UTF-8")).replace("$TEXT", URLEncoder.encode(strReplace2, "UTF-8")).replace("$LAT_E7", URLEncoder.encode(String.valueOf(xVar.p()), "UTF-8")).replace("$LONG_E7", URLEncoder.encode(String.valueOf(xVar.r()), "UTF-8"));
                }
                if (strReplace == null) {
                    return false;
                }
                URL url = new URL(strReplace);
                SSLContext sSLContext = SSLContext.getInstance(Region.REGION_TIMOR_LESTE);
                sSLContext.init(null, null, new SecureRandom());
                com.google.android.libraries.navigation.internal.tx.a aVarA = com.google.android.libraries.navigation.internal.tx.b.a(url);
                aVarA.a.setSSLSocketFactory(sSLContext.getSocketFactory());
                aVarA.a.setConnectTimeout(b);
                InputStream inputStream = aVarA.a.getInputStream();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return false;
                        }
                        while (i != -1) {
                            fileOutputStream.write(bArr, 0, i);
                            i = inputStream.read(bArr);
                        }
                        fileOutputStream.close();
                        if (inputStream == null) {
                            return true;
                        }
                        inputStream.close();
                        return true;
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th3;
            } catch (SocketTimeoutException | IOException | IllegalStateException | KeyManagementException | NoSuchAlgorithmException unused) {
                return false;
            }
        } catch (MalformedURLException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1866)).p("Could not synthesize text, malformed URL");
            return false;
        }
    }
}
