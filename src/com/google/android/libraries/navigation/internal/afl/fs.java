package com.google.android.libraries.navigation.internal.afl;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.mapsplatform.turnbyturn.TurnByTurnManager;
import com.google.firebase.perf.util.Constants;
import com.mappls.sdk.navigation.NavigationConstants;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fs extends com.google.android.libraries.navigation.internal.ael.bi<fs, fh> implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fs a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg aZ;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean M;
    public float N;
    public float O;
    public boolean P;
    public boolean Q;
    public fl aA;
    public boolean aB;
    public int aC;
    public boolean aD;
    public fr aF;
    public boolean aG;
    public boolean aH;
    public boolean aI;
    public float aK;
    public int aL;
    public boolean aM;
    public boolean aN;
    public cy aO;
    public boolean aP;
    public kc aQ;
    public boolean aR;
    public boolean aS;
    public boolean aT;
    public jw aV;
    public boolean aW;
    public fp aX;
    public boolean aY;
    public int ab;
    public boolean ae;
    public int ag;
    public boolean ah;
    public int aq;
    public int ar;
    public int as;
    public boolean at;
    public boolean au;
    public boolean av;
    public boolean aw;
    public boolean ax;
    public boolean ay;
    public int az;
    private int ba;
    private int bb;
    private int bc;
    private int bd;
    private int be;
    private int bf;
    private int bg;
    private int bh;
    private int bi;
    public int w;
    public gv y;
    public boolean z;
    public int b = 70;
    public int c = 650000;
    public int d = 10;
    public int e = 120;
    public int f = 128;
    public int g = 128;
    public int h = 10;
    public int i = DurationKt.NANOS_IN_MILLIS;
    public int j = DurationKt.NANOS_IN_MILLIS;
    public int k = 200;
    public int l = Constants.MAX_URL_LENGTH;
    public int m = 1000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f311n = 900;
    public int o = 50;
    public int p = 10000;
    public int q = 400;
    public int r = 3;
    public int s = 1000;
    public int t = NavigationConstants.UI_HANDLER_LOCATION_SERVICE;
    public int u = 64;
    public boolean v = true;
    public int x = 50;
    public int A = 35;
    public int E = 60;
    public int F = 10;
    public int G = 30;
    public int H = 14400;
    public int I = 70;
    public int J = 900;
    public int K = 3600;
    public com.google.android.libraries.navigation.internal.ael.bz L = com.google.android.libraries.navigation.internal.ael.dj.b;
    public int R = 1000;
    public int S = 10;
    public int T = 60;
    public int U = 1800;
    public int V = 500;
    public int W = 1000;
    public int X = 30;
    public int Y = TurnByTurnManager.MSG_NAV_INFO;
    public int Z = 10;
    public int aa = 3600;
    public boolean ac = true;
    public boolean ad = true;
    public int af = 90;
    public int ai = 3;
    public int aj = 3;
    public int ao = 10000;
    public int ap = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    public int aE = 5;
    public int aJ = 300;
    public float aU = 0.05f;

    static {
        fs fsVar = new fs();
        a = fsVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fs.class, fsVar);
    }

    private fs() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001b\u0000\t\u0001ĵb\u0000\u0001\u0000\u0001င\u0000\u0002ဆ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0007င\u0006\bဆ\u0007\tင\u000b\nင\f\fင\u0011\u0011င\u0016\u0012င\u0017\u0013ဆ\u0018\u0014င\u0019\u0015င\u001a\u0016င\u001b\u0017င\u001c\u0018င\u001d\u0019ဇ\u001e\u001cင \u001dဉ\"\u001eင!\u001fဇ# င$!ဇ%\"ဇ&#ဇ'$င((င.*င0+င1,င2-ဆ\n1င\u00052င34\u001bYခSZခT^ဇW_ဇX`ငYaငZbင[cင\\dင]eင^fင_gင`hငaiငbjငckဇdlဇemဇfnငgoငhpဇirငj}ဉ\u0084~င)\u0082ငl\u0083ငm\u0084ငn\u008aင\u0092\u008dငo\u008eငp\u0090ဉ\u0097\u0096ဇ\u009b\u0099ဇs\u009cဇ\u009f\u009fဇ¡¦ဇ\u008c§င\u008d¨ဇ\u008e¯ဇH±ဇu²င«µဇvºခ°»᠌±½ဇw¾ဇ²Èဇ½Éဉ¾ËဇyÌဇzÎဇÁÏဉÂÒဇÄÔဇÅ×င{ßငqîဇÜûခäąဉöīဇČıဉĕĵဇĘ", new Object[]{"ba", "bb", "bc", "bd", "be", "bf", "bg", "bh", "bi", "b", "c", "d", "e", "f", "h", ContextChain.TAG_INFRA, "k", "l", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "r", "s", "t", "u", "v", "w", "y", "x", "z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", WeatherCriteria.UNIT_CELSIUS, "D", ExifInterface.LONGITUDE_EAST, "G", "H", "I", "J", "j", "g", "K", "L", ey.class, "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "aa", "ab", "ac", "ad", "ae", "af", "ag", "ah", "ai", "aA", WeatherCriteria.UNIT_FARENHEIT, "aj", "ao", "ap", "aE", "aq", "ar", "aF", "aG", "at", "aH", "aI", "aB", "aC", "aD", "M", "au", "aJ", "av", "aK", "aL", fm.a, "aw", "aM", "aN", "aO", "ax", "ay", "aP", "aQ", "aR", "aS", "az", "as", "aT", "aU", "aV", "aW", "aX", "aY"});
        }
        if (i2 == 3) {
            return new fs();
        }
        if (i2 == 4) {
            return new fh();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = aZ;
        if (bcVar == null) {
            synchronized (fs.class) {
                bcVar = aZ;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    aZ = bcVar;
                }
            }
        }
        return bcVar;
    }
}
