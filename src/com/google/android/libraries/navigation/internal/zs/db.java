package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class db extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final db a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public int c = 0;
    public Object d;
    public boolean e;
    public com.google.android.libraries.navigation.internal.ael.ed f;
    public fh g;

    static {
        db dbVar = new db();
        a = dbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(db.class, dbVar);
    }

    private db() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001C\u0001\u0001\u0001DC\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဉ\u0001\u0004ဉ\u0002\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000\u0011<\u0000\u0012<\u0000\u0013<\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000\u0017<\u0000\u0018<\u0000\u0019<\u0000\u001a<\u0000\u001b<\u0000\u001c<\u0000\u001d<\u0000\u001e<\u0000\u001f<\u0000 <\u0000!<\u0000\"<\u0000#<\u0000$<\u0000%<\u0000&<\u0000'<\u0000(<\u0000)<\u0000*<\u0000+<\u0000,<\u0000-<\u0000.<\u0000/<\u00000<\u00001<\u00002<\u00003<\u00004<\u00005<\u00006<\u00007<\u00008<\u00009<\u0000:<\u0000;<\u0000<<\u0000=<\u0000><\u0000?<\u0000@<\u0000A<\u0000B<\u0000C<\u0000D<\u0000", new Object[]{"d", "c", "b", "e", "f", "g", cn.class, bz.class, cd.class, fd.class, f.class, fp.class, l.class, j.class, n.class, el.class, bn.class, ef.class, ad.class, bf.class, bx.class, bt.class, er.class, fb.class, fn.class, br.class, dv.class, bl.class, r.class, fv.class, ah.class, af.class, fr.class, cf.class, ct.class, b.class, fz.class, ft.class, eb.class, dx.class, aj.class, at.class, cv.class, gd.class, gb.class, di.class, dz.class, dt.class, dt.class, ab.class, z.class, x.class, v.class, al.class, an.class, ep.class, cy.class, ap.class, en.class, eh.class, bp.class, t.class, ch.class, av.class, bv.class, cl.class, cj.class, fj.class, fl.class, ax.class});
        }
        if (i2 == 3) {
            return new db();
        }
        if (i2 == 4) {
            return new cz();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (db.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}
