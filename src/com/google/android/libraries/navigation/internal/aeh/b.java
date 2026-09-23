package com.google.android.libraries.navigation.internal.aeh;

import com.drew.metadata.exif.makernotes.KodakMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final int a = 1;
    public static final int b = 2;

    @Deprecated
    public static final int c = 3;

    @Deprecated
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;

    @Deprecated
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f239n = 15;
    public static final int o = 16;
    public static final int p = 17;
    public static final int q = 18;
    public static final int r = 19;
    public static final int s = 20;
    public static final int t = 21;
    public static final int u = 87;
    public static final int v = 22;

    @Deprecated
    public static final int w = 23;
    public static final int x = 24;

    @Deprecated
    public static final int y = 25;
    public static final int z = 26;
    public static final int A = 27;
    public static final int B = 46;
    public static final int C = 29;
    public static final int D = 31;
    public static final int E = 33;
    public static final int F = 49;
    public static final int G = 47;
    public static final int H = 32;
    public static final int I = 34;
    public static final int J = 35;
    public static final int K = 36;
    public static final int L = 38;
    public static final int M = 39;
    public static final int N = 40;
    public static final int O = 42;
    public static final int P = 88;
    public static final int Q = 41;

    @Deprecated
    public static final int R = 43;
    public static final int S = 56;
    public static final int T = 55;
    public static final int U = 44;
    public static final int V = 45;
    public static final int W = 48;
    public static final int X = 58;
    public static final int Y = 50;
    public static final int Z = 51;
    public static final int aa = 52;

    @Deprecated
    public static final int ab = 53;

    @Deprecated
    public static final int ac = 57;
    public static final int ad = 72;
    public static final int ae = 54;
    public static final int af = 77;
    public static final int ag = 66;
    public static final int ah = 67;
    public static final int ai = 79;
    public static final int aj = 59;
    public static final int ak = 61;
    public static final int al = 60;
    public static final int am = 62;
    public static final int an = 63;
    public static final int ao = 64;
    public static final int ap = 65;
    public static final int aq = 68;
    public static final int ar = 69;
    public static final int as = 70;
    public static final int at = 71;
    public static final int au = 73;
    public static final int av = 74;
    public static final int aw = 75;
    public static final int ax = 76;
    public static final int ay = 78;
    public static final int az = 80;
    public static final int aA = 81;
    public static final int aB = 82;
    public static final int aC = 83;
    public static final int aD = 84;
    public static final int aE = 85;
    public static final int aF = 86;
    public static final int aG = 89;
    public static final int aH = 91;
    public static final int aI = 92;
    public static final int aJ = 93;
    public static final int aK = 90;
    public static final int aL = 94;
    public static final int aM = 95;
    private static final /* synthetic */ int[] aN = {a, b, c, d, e, f, g, h, i, j, k, l, m, f239n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM};

    public static int a(int i2) {
        switch (i2) {
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
            case 3:
                return d;
            case 4:
                return e;
            case 5:
                return f;
            case 6:
                return g;
            case 7:
                return h;
            case 8:
                return i;
            case 9:
                return j;
            case 10:
                return k;
            case 11:
                return l;
            case 12:
                return m;
            case 13:
            case 27:
            case 29:
            case 36:
            default:
                return 0;
            case 14:
                return f239n;
            case 15:
                return o;
            case 16:
                return p;
            case 17:
                return q;
            case 18:
                return r;
            case 19:
                return s;
            case 20:
                return t;
            case 21:
                return v;
            case 22:
                return w;
            case 23:
                return x;
            case 24:
                return y;
            case 25:
                return z;
            case 26:
                return A;
            case 28:
                return C;
            case 30:
                return D;
            case 31:
                return H;
            case 32:
                return E;
            case 33:
                return I;
            case 34:
                return J;
            case 35:
                return K;
            case 37:
                return L;
            case 38:
                return M;
            case 39:
                return N;
            case 40:
                return Q;
            case 41:
                return O;
            case 42:
                return R;
            case 43:
                return U;
            case 44:
                return V;
            case 45:
                return B;
            case 46:
                return G;
            case 47:
                return W;
            case 48:
                return F;
            case 49:
                return Y;
            case 50:
                return Z;
            case 51:
                return aa;
            case 52:
                return ab;
            case 53:
                return ae;
            case 54:
                return T;
            case 55:
                return S;
            case 56:
                return ac;
            case 57:
                return X;
            case 58:
                return aj;
            case 59:
                return al;
            case 60:
                return ak;
            case 61:
                return am;
            case 62:
                return an;
            case 63:
                return ao;
            case 64:
                return ap;
            case 65:
                return ag;
            case 66:
                return ah;
            case 67:
                return aq;
            case 68:
                return ar;
            case 69:
                return as;
            case 70:
                return at;
            case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
                return ad;
            case 72:
                return au;
            case 73:
                return av;
            case ReconyxHyperFireMakernoteDirectory.TAG_BRIGHTNESS /* 74 */:
                return aw;
            case 75:
                return ax;
            case 76:
                return af;
            case PanasonicMakernoteDirectory.TAG_AF_POINT_POSITION /* 77 */:
                return ay;
            case 78:
                return ai;
            case 79:
                return az;
            case 80:
                return aA;
            case PanasonicMakernoteDirectory.TAG_LENS_TYPE /* 81 */:
                return aB;
            case 82:
                return aC;
            case PanasonicMakernoteDirectory.TAG_ACCESSORY_TYPE /* 83 */:
                return aD;
            case 84:
                return aE;
            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                return aF;
            case ReconyxHyperFireMakernoteDirectory.TAG_USER_LABEL /* 86 */:
                return u;
            case 87:
                return P;
            case 88:
                return aG;
            case PanasonicMakernoteDirectory.TAG_TRANSFORM /* 89 */:
                return aK;
            case 90:
                return aH;
            case 91:
                return aI;
            case KodakMakernoteDirectory.TAG_FLASH_MODE /* 92 */:
                return aJ;
            case 93:
                return aL;
            case KodakMakernoteDirectory.TAG_ISO_SETTING /* 94 */:
                return aM;
        }
    }

    public static int[] values$ar$edu$9f85a603_0() {
        return new int[]{a, b, c, d, e, f, g, h, i, j, k, l, m, f239n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM};
    }
}
