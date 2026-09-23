package com.google.android.libraries.navigation.internal.zd;

import com.google.maps.android.BuildConfig;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Formattable;
import java.util.Formatter;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.zi.c implements com.google.android.libraries.navigation.internal.zh.d {
    protected final Object[] a;
    public final StringBuilder b;
    private int e;

    protected a(ak akVar, Object[] objArr, StringBuilder sb) {
        super(akVar);
        this.e = 0;
        com.google.android.libraries.navigation.internal.zj.b.d(objArr, "arguments");
        this.a = objArr;
        this.b = sb;
    }

    public static void c(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(l.b(obj));
        sb.append("]");
    }

    public static void e(f fVar, StringBuilder sb) {
        if (fVar.j() == null) {
            sb.append(l.b(fVar.k()));
            return;
        }
        com.google.android.libraries.navigation.internal.zi.c aVar = new a(fVar.j(), fVar.D(), sb);
        aVar.f().b(aVar);
        int i = aVar.c;
        if (((i + 1) & i) != 0 || (aVar.d > 31 && i != -1)) {
            throw new com.google.android.libraries.navigation.internal.zi.e(String.format("unreferenced arguments [first missing index=%d]", Integer.valueOf(Integer.numberOfTrailingZeros(~i))));
        }
        Object objA = aVar.a();
        if (fVar.D().length > aVar.d + 1) {
            ((StringBuilder) objA).append(" [ERROR: UNUSED LOG ARGUMENTS]");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zi.c
    public final /* bridge */ /* synthetic */ Object a() {
        f().c(this.b, g(), this.e, g().length());
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.zi.c
    public final void b(int i, int i2, com.google.android.libraries.navigation.internal.zh.c cVar) {
        f().c(this.b, g(), this.e, i);
        Object[] objArr = this.a;
        int i3 = cVar.a;
        if (i3 < objArr.length) {
            Object obj = objArr[i3];
            if (obj != null) {
                cVar.a(this, obj);
            } else {
                this.b.append(BuildConfig.TRAVIS);
            }
        } else {
            this.b.append("[ERROR: MISSING LOG ARGUMENT]");
        }
        this.e = i2;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x012d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0133  */
    /* JADX WARN: Code duplicated, block: B:15:0x0022  */
    /* JADX WARN: Code duplicated, block: B:31:0x003f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0094  */
    @Override // com.google.android.libraries.navigation.internal.zh.d
    public final void d(Object obj, b bVar, c cVar) {
        c cVar2;
        boolean zIsValidCodePoint;
        int iOrdinal = bVar.m.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                zIsValidCodePoint = obj instanceof Boolean;
            } else if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        throw null;
                    }
                    if ((obj instanceof Double) || (obj instanceof Float) || (obj instanceof BigDecimal)) {
                        zIsValidCodePoint = true;
                    } else {
                        zIsValidCodePoint = false;
                    }
                } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof BigInteger)) {
                    zIsValidCodePoint = true;
                } else {
                    zIsValidCodePoint = false;
                }
            } else if (obj instanceof Character) {
                zIsValidCodePoint = true;
            } else if ((obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short)) {
                zIsValidCodePoint = Character.isValidCodePoint(((Number) obj).intValue());
            } else {
                zIsValidCodePoint = false;
            }
            if (!zIsValidCodePoint) {
                c(this.b, obj, bVar.o);
                return;
            }
        }
        StringBuilder sb = this.b;
        int iOrdinal2 = bVar.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                if (cVar.c()) {
                    sb.append(obj);
                    return;
                }
            } else if (iOrdinal2 != 2) {
                if (iOrdinal2 != 3) {
                    if (iOrdinal2 == 5) {
                        if (cVar.c()) {
                            cVar2 = cVar;
                        } else {
                            int i = cVar.b;
                            int i2 = i & 128;
                            if (i2 == 0) {
                                cVar2 = c.a;
                            } else if (i2 == i && cVar.c == -1 && cVar.d == -1) {
                                cVar2 = cVar;
                            } else {
                                cVar2 = new c(i2, -1, -1);
                            }
                        }
                        if (cVar2.equals(cVar)) {
                            Number number = (Number) obj;
                            boolean zD = cVar.d();
                            long jLongValue = number.longValue();
                            if (number instanceof Long) {
                                l.c(sb, jLongValue, zD);
                                return;
                            }
                            if (number instanceof Integer) {
                                l.c(sb, jLongValue & 4294967295L, zD);
                                return;
                            }
                            if (number instanceof Byte) {
                                l.c(sb, jLongValue & 255, zD);
                                return;
                            }
                            if (number instanceof Short) {
                                l.c(sb, jLongValue & WebSocketProtocol.PAYLOAD_SHORT_MAX, zD);
                                return;
                            } else {
                                if (!(number instanceof BigInteger)) {
                                    throw new IllegalStateException("unsupported number type: ".concat(String.valueOf(String.valueOf(number.getClass()))));
                                }
                                String string = ((BigInteger) number).toString(16);
                                if (zD) {
                                    string = string.toUpperCase(l.a);
                                }
                                sb.append(string);
                                return;
                            }
                        }
                    }
                } else if (cVar.c()) {
                    sb.append(obj);
                    return;
                }
            } else if (cVar.c()) {
                if (obj instanceof Character) {
                    sb.append(obj);
                    return;
                }
                int iIntValue = ((Number) obj).intValue();
                if ((iIntValue >>> 16) == 0) {
                    sb.append((char) iIntValue);
                    return;
                } else {
                    sb.append(Character.toChars(iIntValue));
                    return;
                }
            }
        } else {
            if (obj instanceof Formattable) {
                Formattable formattable = (Formattable) obj;
                int i3 = cVar.b;
                int i4 = i3 & 162;
                if (i4 != 0) {
                    i4 = ((i3 & 32) == 0 ? 0 : 1) | ((i3 & 128) != 0 ? 2 : 0) | ((i3 & 2) == 0 ? 0 : 4);
                }
                int length = sb.length();
                Formatter formatter = new Formatter(sb, l.a);
                try {
                    formattable.formatTo(formatter, i4, cVar.c, cVar.d);
                    return;
                } catch (RuntimeException e) {
                    sb.setLength(length);
                    try {
                        formatter.out().append(l.a(formattable, e));
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            }
            if (cVar.c()) {
                sb.append(l.b(obj));
                return;
            }
        }
        String string2 = bVar.o;
        if (!cVar.c()) {
            int i5 = bVar.l;
            if (cVar.d()) {
                i5 &= 65503;
            }
            StringBuilder sb2 = new StringBuilder("%");
            cVar.f(sb2);
            sb2.append((char) i5);
            string2 = sb2.toString();
        }
        sb.append(String.format(l.a, string2, obj));
    }
}
