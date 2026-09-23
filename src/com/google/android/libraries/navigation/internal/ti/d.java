package com.google.android.libraries.navigation.internal.ti;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import com.google.android.libraries.navigation.internal.acd.ml;
import com.google.android.libraries.navigation.internal.afl.cg;
import com.google.android.libraries.navigation.internal.zs.ay;
import com.google.android.libraries.navigation.internal.zs.ba;
import com.google.android.libraries.navigation.internal.zs.bc;
import com.google.android.libraries.navigation.internal.zs.be;
import com.google.android.libraries.navigation.internal.zs.bf;
import com.google.android.libraries.navigation.internal.zs.cz;
import com.google.android.libraries.navigation.internal.zs.db;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d {
    private final com.google.android.libraries.navigation.internal.iv.f a;
    private final com.google.android.libraries.navigation.internal.fr.d b;
    private final Context c;
    private final com.google.android.libraries.navigation.internal.sl.l d;
    private final com.google.android.libraries.navigation.internal.aq.m e;
    private final com.google.android.libraries.navigation.internal.hn.p f;
    private final Optional g;
    private final ay h = (ay) bf.a.q();
    private final com.google.android.libraries.navigation.internal.au.c i;

    public d(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.fr.d dVar, Context context, com.google.android.libraries.navigation.internal.sl.l lVar, com.google.android.libraries.navigation.internal.aq.m mVar, com.google.android.libraries.navigation.internal.au.c cVar, com.google.android.libraries.navigation.internal.hn.p pVar, Optional optional) {
        this.a = fVar;
        this.b = dVar;
        this.c = context;
        this.d = lVar;
        this.e = mVar;
        this.i = cVar;
        this.f = pVar;
        this.g = optional;
    }

    private static int b(int i) {
        com.google.android.libraries.navigation.internal.sl.m mVar = com.google.android.libraries.navigation.internal.sl.m.UNMUTED;
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            return ba.a;
        }
        if (i2 == 1) {
            return ba.b;
        }
        if (i2 == 2) {
            return ba.c;
        }
        if (i2 != 3) {
            return i2 != 4 ? ba.a : ba.e;
        }
        return ba.d;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:103:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:106:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:10:0x002f  */
    /* JADX WARN: Code duplicated, block: B:111:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:13:0x003a  */
    /* JADX WARN: Code duplicated, block: B:15:0x004c  */
    /* JADX WARN: Code duplicated, block: B:170:0x030f  */
    /* JADX WARN: Code duplicated, block: B:172:0x0317  */
    /* JADX WARN: Code duplicated, block: B:175:0x0322  */
    /* JADX WARN: Code duplicated, block: B:177:0x0334  */
    /* JADX WARN: Code duplicated, block: B:180:0x033d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0055  */
    /* JADX WARN: Code duplicated, block: B:195:0x037a  */
    /* JADX WARN: Code duplicated, block: B:197:0x0382  */
    /* JADX WARN: Code duplicated, block: B:200:0x038d  */
    /* JADX WARN: Code duplicated, block: B:202:0x039f  */
    /* JADX WARN: Code duplicated, block: B:205:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:25:0x007b  */
    /* JADX WARN: Code duplicated, block: B:273:0x055f  */
    /* JADX WARN: Code duplicated, block: B:274:0x0560  */
    /* JADX WARN: Code duplicated, block: B:275:0x0561  */
    /* JADX WARN: Code duplicated, block: B:276:0x0562  */
    /* JADX WARN: Code duplicated, block: B:277:0x0563  */
    /* JADX WARN: Code duplicated, block: B:278:0x0564  */
    /* JADX WARN: Code duplicated, block: B:279:0x0565  */
    /* JADX WARN: Code duplicated, block: B:27:0x0083  */
    /* JADX WARN: Code duplicated, block: B:280:0x0566  */
    /* JADX WARN: Code duplicated, block: B:281:0x0567  */
    /* JADX WARN: Code duplicated, block: B:282:0x0568  */
    /* JADX WARN: Code duplicated, block: B:283:0x0569  */
    /* JADX WARN: Code duplicated, block: B:284:0x056a  */
    /* JADX WARN: Code duplicated, block: B:30:0x008e  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:73:0x014c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0154  */
    /* JADX WARN: Code duplicated, block: B:78:0x015f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0170  */
    /* JADX WARN: Code duplicated, block: B:83:0x0179  */
    /* JADX WARN: Code duplicated, block: B:84:0x0181  */
    /* JADX WARN: Code duplicated, block: B:85:0x0182  */
    /* JADX WARN: Code duplicated, block: B:8:0x0027  */
    final cz a(com.google.android.libraries.navigation.internal.cw.c cVar) {
        bf bfVar;
        int i;
        ay ayVar;
        bf bfVar2;
        bf bfVar3;
        int i2;
        ay ayVar2;
        bf bfVar4;
        bf bfVar5;
        int i3;
        ay ayVar3;
        bf bfVar6;
        int i4;
        bf bfVar7;
        int i5;
        ay ayVar4;
        bf bfVar8;
        int i6;
        bf bfVar9;
        int i7;
        ay ayVar5;
        bf bfVar10;
        int i8;
        bf bfVar11;
        int i9;
        ay ayVar6;
        bf bfVar12;
        int i10;
        bf bfVar13;
        int i11;
        ay ayVar7;
        bf bfVar14;
        ay ayVar8 = (ay) bf.a.q();
        int iB = b(cVar.a);
        bf bfVar15 = (bf) this.h.b;
        if ((bfVar15.b & 64) == 0) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bfVar = (bf) ayVar8.b;
            i = iB - 1;
            if (iB != 0) {
                throw null;
            }
            bfVar.i = i;
            bfVar.b |= 64;
            ayVar = this.h;
            if (!ayVar.b.H()) {
                ayVar.v();
            }
            bfVar2 = (bf) ayVar.b;
            if (iB != 0) {
                throw null;
            }
            bfVar2.i = i;
            bfVar2.b |= 64;
        } else {
            int iA = ba.a(bfVar15.i);
            if (iA == 0) {
                iA = ba.a;
            }
            if (iA != iB) {
                if (!ayVar8.b.H()) {
                    ayVar8.v();
                }
                bfVar = (bf) ayVar8.b;
                i = iB - 1;
                if (iB != 0) {
                    throw null;
                }
                bfVar.i = i;
                bfVar.b |= 64;
                ayVar = this.h;
                if (!ayVar.b.H()) {
                    ayVar.v();
                }
                bfVar2 = (bf) ayVar.b;
                if (iB != 0) {
                    throw null;
                }
                bfVar2.i = i;
                bfVar2.b |= 64;
            }
        }
        int iB2 = b(cVar.b);
        bf bfVar16 = (bf) this.h.b;
        if ((bfVar16.b & 128) == 0) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bfVar3 = (bf) ayVar8.b;
            i2 = iB2 - 1;
            if (iB2 != 0) {
                throw null;
            }
            bfVar3.j = i2;
            bfVar3.b |= 128;
            ayVar2 = this.h;
            if (!ayVar2.b.H()) {
                ayVar2.v();
            }
            bfVar4 = (bf) ayVar2.b;
            if (iB2 != 0) {
                throw null;
            }
            bfVar4.j = i2;
            bfVar4.b |= 128;
        } else {
            int iA2 = ba.a(bfVar16.j);
            if (iA2 == 0) {
                iA2 = ba.a;
            }
            if (iA2 != iB2) {
                if (!ayVar8.b.H()) {
                    ayVar8.v();
                }
                bfVar3 = (bf) ayVar8.b;
                i2 = iB2 - 1;
                if (iB2 != 0) {
                    throw null;
                }
                bfVar3.j = i2;
                bfVar3.b |= 128;
                ayVar2 = this.h;
                if (!ayVar2.b.H()) {
                    ayVar2.v();
                }
                bfVar4 = (bf) ayVar2.b;
                if (iB2 != 0) {
                    throw null;
                }
                bfVar4.j = i2;
                bfVar4.b |= 128;
            }
        }
        int iB3 = b(cVar.c);
        bf bfVar17 = (bf) this.h.b;
        if ((bfVar17.b & 256) == 0) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bfVar5 = (bf) ayVar8.b;
            i3 = iB3 - 1;
            if (iB3 != 0) {
                throw null;
            }
            bfVar5.k = i3;
            bfVar5.b |= 256;
            ayVar3 = this.h;
            if (!ayVar3.b.H()) {
                ayVar3.v();
            }
            bfVar6 = (bf) ayVar3.b;
            if (iB3 != 0) {
                throw null;
            }
            bfVar6.k = i3;
            bfVar6.b |= 256;
        } else {
            int iA3 = ba.a(bfVar17.k);
            if (iA3 == 0) {
                iA3 = ba.a;
            }
            if (iA3 != iB3) {
                if (!ayVar8.b.H()) {
                    ayVar8.v();
                }
                bfVar5 = (bf) ayVar8.b;
                i3 = iB3 - 1;
                if (iB3 != 0) {
                    throw null;
                }
                bfVar5.k = i3;
                bfVar5.b |= 256;
                ayVar3 = this.h;
                if (!ayVar3.b.H()) {
                    ayVar3.v();
                }
                bfVar6 = (bf) ayVar3.b;
                if (iB3 != 0) {
                    throw null;
                }
                bfVar6.k = i3;
                bfVar6.b |= 256;
            }
        }
        Intent intentA = com.google.android.libraries.navigation.internal.fr.a.a(this.c);
        if (intentA != null) {
            int intExtra = intentA.getIntExtra("plugged", -1);
            if (intExtra == 1) {
                i10 = cg.b;
            } else if (intExtra == 2) {
                i10 = cg.c;
            } else if (intExtra != 4) {
                i10 = (Build.VERSION.SDK_INT < 33 || intExtra != 8) ? cg.a : cg.e;
            } else {
                i10 = cg.d;
            }
            bf bfVar18 = (bf) this.h.b;
            if ((bfVar18.b & 1) == 0) {
                if (!ayVar8.b.H()) {
                    ayVar8.v();
                }
                bfVar13 = (bf) ayVar8.b;
                i11 = i10 - 1;
                if (i10 != 0) {
                    throw null;
                }
                bfVar13.c = i11;
                bfVar13.b |= 1;
                ayVar7 = this.h;
                if (!ayVar7.b.H()) {
                    ayVar7.v();
                }
                bfVar14 = (bf) ayVar7.b;
                if (i10 != 0) {
                    throw null;
                }
                bfVar14.c = i11;
                bfVar14.b |= 1;
            } else {
                int iA4 = cg.a(bfVar18.c);
                if (iA4 == 0) {
                    iA4 = cg.a;
                }
                if (iA4 != i10) {
                    if (!ayVar8.b.H()) {
                        ayVar8.v();
                    }
                    bfVar13 = (bf) ayVar8.b;
                    i11 = i10 - 1;
                    if (i10 != 0) {
                        throw null;
                    }
                    bfVar13.c = i11;
                    bfVar13.b |= 1;
                    ayVar7 = this.h;
                    if (!ayVar7.b.H()) {
                        ayVar7.v();
                    }
                    bfVar14 = (bf) ayVar7.b;
                    if (i10 != 0) {
                        throw null;
                    }
                    bfVar14.c = i11;
                    bfVar14.b |= 1;
                }
            }
        }
        if (this.b.d()) {
            com.google.android.libraries.navigation.internal.fr.c cVarA = this.b.a();
            if (cVarA == null || (i4 = cVarA.b) == 0) {
                i4 = ml.a;
            }
        } else {
            i4 = ml.b;
        }
        bf bfVar19 = (bf) this.h.b;
        if ((bfVar19.b & 2) == 0) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bfVar7 = (bf) ayVar8.b;
            i5 = i4 - 1;
            if (i4 != 0) {
                throw null;
            }
            bfVar7.d = i5;
            bfVar7.b |= 2;
            ayVar4 = this.h;
            if (!ayVar4.b.H()) {
                ayVar4.v();
            }
            bfVar8 = (bf) ayVar4.b;
            if (i4 != 0) {
                throw null;
            }
            bfVar8.d = i5;
            bfVar8.b |= 2;
        } else {
            int iB4 = ml.b(bfVar19.d);
            if (iB4 == 0) {
                iB4 = ml.a;
            }
            if (iB4 != i4) {
                if (!ayVar8.b.H()) {
                    ayVar8.v();
                }
                bfVar7 = (bf) ayVar8.b;
                i5 = i4 - 1;
                if (i4 != 0) {
                    throw null;
                }
                bfVar7.d = i5;
                bfVar7.b |= 2;
                ayVar4 = this.h;
                if (!ayVar4.b.H()) {
                    ayVar4.v();
                }
                bfVar8 = (bf) ayVar4.b;
                if (i4 != 0) {
                    throw null;
                }
                bfVar8.d = i5;
                bfVar8.b |= 2;
            }
        }
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        if (streamMaxVolume > 0) {
            int streamVolume = audioManager.getStreamVolume(3) * 100;
            bf bfVar20 = (bf) this.h.b;
            int i12 = streamVolume / streamMaxVolume;
            if ((bfVar20.b & 4) == 0 || bfVar20.e != i12) {
                if (!ayVar8.b.H()) {
                    ayVar8.v();
                }
                bf bfVar21 = (bf) ayVar8.b;
                bfVar21.b |= 4;
                bfVar21.e = i12;
                ay ayVar9 = this.h;
                if (!ayVar9.b.H()) {
                    ayVar9.v();
                }
                bf bfVar22 = (bf) ayVar9.b;
                bfVar22.b = 4 | bfVar22.b;
                bfVar22.e = i12;
            }
        }
        boolean zIsWiredHeadsetOn = audioManager.isWiredHeadsetOn();
        bf bfVar23 = (bf) this.h.b;
        if ((bfVar23.b & 8) == 0 || bfVar23.f != zIsWiredHeadsetOn) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bf bfVar24 = (bf) ayVar8.b;
            bfVar24.b |= 8;
            bfVar24.f = zIsWiredHeadsetOn;
            ay ayVar10 = this.h;
            if (!ayVar10.b.H()) {
                ayVar10.v();
            }
            bf bfVar25 = (bf) ayVar10.b;
            bfVar25.b = 8 | bfVar25.b;
            bfVar25.f = zIsWiredHeadsetOn;
        }
        boolean z = audioManager.isBluetoothScoOn() || audioManager.isBluetoothA2dpOn();
        bf bfVar26 = (bf) this.h.b;
        if ((bfVar26.b & 16) == 0 || bfVar26.g != z) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bf bfVar27 = (bf) ayVar8.b;
            bfVar27.b |= 16;
            bfVar27.g = z;
            ay ayVar11 = this.h;
            if (!ayVar11.b.H()) {
                ayVar11.v();
            }
            bf bfVar28 = (bf) ayVar11.b;
            bfVar28.b |= 16;
            bfVar28.g = z;
        }
        Configuration configuration = this.c.getResources().getConfiguration();
        if (configuration.smallestScreenWidthDp >= 600) {
            i6 = configuration.screenWidthDp > configuration.screenHeightDp ? be.e : be.d;
        } else {
            i6 = configuration.screenWidthDp > configuration.screenHeightDp ? be.c : be.b;
        }
        bf bfVar29 = (bf) this.h.b;
        if ((bfVar29.b & 32) == 0) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bfVar9 = (bf) ayVar8.b;
            i7 = i6 - 1;
            if (i6 != 0) {
                throw null;
            }
            bfVar9.h = i7;
            bfVar9.b |= 32;
            ayVar5 = this.h;
            if (!ayVar5.b.H()) {
                ayVar5.v();
            }
            bfVar10 = (bf) ayVar5.b;
            if (i6 != 0) {
                throw null;
            }
            bfVar10.h = i7;
            bfVar10.b |= 32;
        } else {
            int iA5 = be.a(bfVar29.h);
            if (iA5 == 0) {
                iA5 = be.a;
            }
            if (iA5 != i6) {
                if (!ayVar8.b.H()) {
                    ayVar8.v();
                }
                bfVar9 = (bf) ayVar8.b;
                i7 = i6 - 1;
                if (i6 != 0) {
                    throw null;
                }
                bfVar9.h = i7;
                bfVar9.b |= 32;
                ayVar5 = this.h;
                if (!ayVar5.b.H()) {
                    ayVar5.v();
                }
                bfVar10 = (bf) ayVar5.b;
                if (i6 != 0) {
                    throw null;
                }
                bfVar10.h = i7;
                bfVar10.b |= 32;
            }
        }
        com.google.android.libraries.navigation.internal.sl.m mVarA = this.d.a();
        com.google.android.libraries.navigation.internal.sl.m mVar = com.google.android.libraries.navigation.internal.sl.m.UNMUTED;
        int iOrdinal = mVarA.ordinal();
        if (iOrdinal == 0) {
            i8 = bc.b;
        } else if (iOrdinal != 1) {
            i8 = iOrdinal != 2 ? bc.a : bc.d;
        } else {
            i8 = bc.c;
        }
        bf bfVar30 = (bf) this.h.b;
        if ((bfVar30.b & 512) == 0) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bfVar11 = (bf) ayVar8.b;
            i9 = i8 - 1;
            if (i8 != 0) {
                throw null;
            }
            bfVar11.l = i9;
            bfVar11.b |= 512;
            ayVar6 = this.h;
            if (!ayVar6.b.H()) {
                ayVar6.v();
            }
            bfVar12 = (bf) ayVar6.b;
            if (i8 != 0) {
                throw null;
            }
            bfVar12.l = i9;
            bfVar12.b |= 512;
        } else {
            int iA6 = bc.a(bfVar30.l);
            if (iA6 == 0) {
                iA6 = bc.a;
            }
            if (iA6 != i8) {
                if (!ayVar8.b.H()) {
                    ayVar8.v();
                }
                bfVar11 = (bf) ayVar8.b;
                i9 = i8 - 1;
                if (i8 != 0) {
                    throw null;
                }
                bfVar11.l = i9;
                bfVar11.b |= 512;
                ayVar6 = this.h;
                if (!ayVar6.b.H()) {
                    ayVar6.v();
                }
                bfVar12 = (bf) ayVar6.b;
                if (i8 != 0) {
                    throw null;
                }
                bfVar12.l = i9;
                bfVar12.b |= 512;
            }
        }
        boolean zY = this.a.y(com.google.android.libraries.navigation.internal.iv.ab.ab, false);
        bf bfVar31 = (bf) this.h.b;
        if ((bfVar31.b & 1024) == 0 || bfVar31.m != zY) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bf bfVar32 = (bf) ayVar8.b;
            bfVar32.b |= 1024;
            bfVar32.m = zY;
            ay ayVar12 = this.h;
            if (!ayVar12.b.H()) {
                ayVar12.v();
            }
            bf bfVar33 = (bf) ayVar12.b;
            bfVar33.b |= 1024;
            bfVar33.m = zY;
        }
        boolean zA = this.e.a().a();
        bf bfVar34 = (bf) this.h.b;
        if ((bfVar34.b & 2048) == 0 || bfVar34.f672n != zA) {
            if (!ayVar8.b.H()) {
                ayVar8.v();
            }
            bf bfVar35 = (bf) ayVar8.b;
            bfVar35.b |= 2048;
            bfVar35.f672n = zA;
            ay ayVar13 = this.h;
            if (!ayVar13.b.H()) {
                ayVar13.v();
            }
            bf bfVar36 = (bf) ayVar13.b;
            bfVar36.b |= 2048;
            bfVar36.f672n = zA;
            if (zA && this.f.o()) {
                Optional optionalK = com.google.android.libraries.navigation.internal.au.c.a().k();
                if (optionalK.isPresent() && this.f.p()) {
                    com.google.android.libraries.navigation.internal.zr.q qVarA = com.google.android.libraries.navigation.internal.tg.a.a((com.google.android.libraries.navigation.internal.zr.q) optionalK.get());
                    if (!ayVar8.b.H()) {
                        ayVar8.v();
                    }
                    bf bfVar37 = (bf) ayVar8.b;
                    qVarA.getClass();
                    bfVar37.o = qVarA;
                    bfVar37.b |= 4096;
                } else {
                    com.google.android.libraries.navigation.internal.zr.j jVar = (com.google.android.libraries.navigation.internal.zr.j) com.google.android.libraries.navigation.internal.zr.q.a.q();
                    int iA7 = com.google.android.libraries.navigation.internal.zr.p.a(((com.google.android.libraries.navigation.internal.zr.q) optionalK.get()).c);
                    if (iA7 == 0) {
                        iA7 = com.google.android.libraries.navigation.internal.zr.p.a;
                    }
                    if (!jVar.b.H()) {
                        jVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zr.q qVar = (com.google.android.libraries.navigation.internal.zr.q) jVar.b;
                    int i13 = iA7 - 1;
                    if (iA7 == 0) {
                        throw null;
                    }
                    qVar.c = i13;
                    qVar.b |= 1;
                    if (!ayVar8.b.H()) {
                        ayVar8.v();
                    }
                    bf bfVar38 = (bf) ayVar8.b;
                    com.google.android.libraries.navigation.internal.zr.q qVar2 = (com.google.android.libraries.navigation.internal.zr.q) jVar.t();
                    qVar2.getClass();
                    bfVar38.o = qVar2;
                    bfVar38.b |= 4096;
                }
            }
        }
        if (this.g.isPresent()) {
            boolean zA2 = ((com.google.android.libraries.navigation.internal.tc.ab) this.g.get()).a();
            bf bfVar39 = (bf) this.h.b;
            if ((bfVar39.b & 8192) == 0 || bfVar39.p != zA2) {
                if (!ayVar8.b.H()) {
                    ayVar8.v();
                }
                bf bfVar40 = (bf) ayVar8.b;
                bfVar40.b |= 8192;
                bfVar40.p = zA2;
                ay ayVar14 = this.h;
                if (!ayVar14.b.H()) {
                    ayVar14.v();
                }
                bf bfVar41 = (bf) ayVar14.b;
                bfVar41.b |= 8192;
                bfVar41.p = zA2;
            }
        }
        bf bfVar42 = (bf) ayVar8.t();
        if (bfVar42.equals(bf.a)) {
            return null;
        }
        cz czVar = (cz) db.a.q();
        if (!czVar.b.H()) {
            czVar.v();
        }
        db dbVar = (db) czVar.b;
        bfVar42.getClass();
        dbVar.d = bfVar42;
        dbVar.c = 18;
        return czVar;
    }
}
