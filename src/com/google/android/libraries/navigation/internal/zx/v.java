package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yz.cw;
import com.google.android.libraries.navigation.internal.yz.dk;
import com.google.android.libraries.navigation.internal.yz.hn;
import com.google.android.libraries.navigation.internal.yz.ho;
import com.google.android.libraries.navigation.internal.yz.kd;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends dk implements Cloneable, Serializable {
    public static final v a = new v(cw.a);
    private static final long serialVersionUID = -3053773769157973706L;
    public final ho b;

    public v() {
        this(new hn(12));
    }

    public v(ho hoVar) {
        this.b = new l(hoVar);
    }

    public static String f(String str, int i, int i2, Charset charset, boolean z) {
        try {
            return z ? new String(URLDecoder.decode(str.substring(i, i2), CharEncoding.ISO_8859_1).getBytes(StandardCharsets.ISO_8859_1), charset) : URLDecoder.decode(str.substring(i, i2), charset.name());
        } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
            return str.substring(i, i2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dk
    protected final ho a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dk, com.google.android.libraries.navigation.internal.yz.dn
    /* JADX INFO: renamed from: b */
    protected final /* synthetic */ kd aF() {
        return this.b;
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final v clone() {
        return new v(new hn(this.b));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.Cdo
    public final String toString() {
        return q.b(this, u.a, t.a);
    }
}
