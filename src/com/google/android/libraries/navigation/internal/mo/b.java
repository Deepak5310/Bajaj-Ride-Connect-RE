package com.google.android.libraries.navigation.internal.mo;

import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final b a = new b();
    private final a[] b;

    /* JADX WARN: Code duplicated, block: B:26:0x004c A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:28:0x0050  */
    /* JADX WARN: Code duplicated, block: B:37:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Switch 'out' block B:26:0x004c for B:23:0x0045 already processed. Defaulting to fallback option. */
    private b() {
        a[] aVarArr;
        int iMax = 0;
        for (int i : com.google.android.libraries.navigation.internal.aeo.a.values$ar$edu$b46a8d2b_0()) {
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            iMax = Math.max(iMax, i2);
        }
        this.b = new a[iMax + 1];
        for (int i3 : com.google.android.libraries.navigation.internal.aeo.a.values$ar$edu$b46a8d2b_0()) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            if (i4 != 17 && i4 != 27 && i4 != 78 && i4 != 82) {
                switch (i4) {
                    default:
                        switch (i4) {
                            default:
                                switch (i4) {
                                    default:
                                        switch (i4) {
                                            case 56:
                                            case 57:
                                            case 58:
                                            case 59:
                                            case 60:
                                            case 61:
                                            case 62:
                                            case 63:
                                            case 64:
                                            case 65:
                                            case 66:
                                            case 67:
                                            case 68:
                                            case 69:
                                            case 70:
                                            case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
                                            case 72:
                                            case 73:
                                                break;
                                            default:
                                                continue;
                                        }
                                    case 31:
                                    case 32:
                                    case 33:
                                    case 34:
                                    case 35:
                                    case 36:
                                    case 37:
                                    case 38:
                                    case 39:
                                    case 40:
                                    case 41:
                                    case 42:
                                    case 43:
                                    case 44:
                                    case 45:
                                    case 46:
                                    case 47:
                                    case 48:
                                    case 49:
                                        aVarArr = this.b;
                                        if (i3 != 0) {
                                            throw null;
                                        }
                                        a aVar = new a();
                                        aVarArr[i4] = aVar;
                                        int i5 = ev.d;
                                        aVar.a = lv.a;
                                        break;
                                        break;
                                }
                            case 19:
                            case 20:
                            case 21:
                                aVarArr = this.b;
                                if (i3 != 0) {
                                    throw null;
                                }
                                a aVar2 = new a();
                                aVarArr[i4] = aVar2;
                                int i6 = ev.d;
                                aVar2.a = lv.a;
                                break;
                                break;
                        }
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        aVarArr = this.b;
                        if (i3 != 0) {
                            throw null;
                        }
                        a aVar3 = new a();
                        aVarArr[i4] = aVar3;
                        int i7 = ev.d;
                        aVar3.a = lv.a;
                        break;
                        break;
                }
            } else {
                aVarArr = this.b;
                if (i3 != 0) {
                    throw null;
                }
                a aVar4 = new a();
                aVarArr[i4] = aVar4;
                int i8 = ev.d;
                aVar4.a = lv.a;
            }
        }
    }
}
