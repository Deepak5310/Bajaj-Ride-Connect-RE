package com.google.android.libraries.navigation.internal.tu;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.nf;
import com.google.android.libraries.navigation.internal.afl.nl;
import com.google.android.libraries.navigation.internal.sk.ef;
import com.reactnativekeyboardcontroller.views.background.ImePackages;
import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements as {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ File c;
    final /* synthetic */ f d;

    public c(f fVar, String str, String str2, File file) {
        this.a = str;
        this.b = str2;
        this.c = file;
        this.d = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1829)).p("ttsFileHandler::isStorageAvailable call failed.");
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0340  */
    /* JADX WARN: Code duplicated, block: B:114:0x035f A[LOOP:2: B:112:0x0359->B:114:0x035f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:117:0x0371  */
    /* JADX WARN: Code duplicated, block: B:118:0x037b  */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bc, code lost:
    
        if (r14 == false) goto L46;
     */
    @Override // com.google.android.libraries.navigation.internal.aac.as
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        Bundle bundle;
        TextToSpeech textToSpeech;
        int iSynthesizeToFile;
        long j;
        boolean zG;
        if (!((Boolean) obj).booleanValue()) {
            this.d.e(this.a);
            return;
        }
        if (this.d.f.e()) {
            f fVar = this.d;
            com.google.android.libraries.navigation.internal.sl.p pVar = fVar.a;
            String strA = fVar.f.a();
            ef efVar = (ef) pVar;
            TextToSpeech textToSpeech2 = efVar.h;
            if (textToSpeech2 != null) {
                String str = efVar.i;
                if (str == null || !str.equals(strA)) {
                    if (strA.isEmpty()) {
                        Locale locale = efVar.j;
                        if (locale == null || efVar.a(locale) == -1) {
                            efVar.i = null;
                        } else {
                            efVar.i = strA;
                        }
                    } else {
                        Set<Voice> voices = textToSpeech2.getVoices();
                        if (voices != null) {
                            String strReplace = strA.replace("-vocoded", "");
                            Iterator<Voice> it2 = voices.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Voice next = it2.next();
                                    if (next.getName().endsWith(ImagesContract.LOCAL)) {
                                        if (!next.getName().startsWith("en-us-x-fis")) {
                                            if (!next.getName().startsWith("en-us-x-afh")) {
                                                if (next.getName().contains(strReplace)) {
                                                    zG = efVar.g(next, strA);
                                                    break;
                                                }
                                            } else {
                                                if (strReplace.equals("afh-us")) {
                                                    zG = efVar.g(next, strA);
                                                    break;
                                                }
                                            }
                                        } else {
                                            if (strReplace.equals("fis-us")) {
                                                zG = efVar.g(next, strA);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.d.f.a();
            this.d.e(this.a);
            return;
        }
        f fVar2 = this.d;
        String str2 = this.b;
        String str3 = this.a;
        File file = this.c;
        com.google.android.libraries.navigation.internal.sl.p pVar2 = fVar2.a;
        com.google.android.libraries.navigation.internal.db.r rVarB = fVar2.c.b();
        String absolutePath = file.getAbsolutePath();
        ef efVar2 = (ef) pVar2;
        Locale localeC = efVar2.c();
        if (localeC != null && localeC.equals(efVar2.j)) {
            efVar2.e.h();
            efVar2.e.m(str2);
            if (rVarB == null || !((nl) efVar2.d.b()).r) {
                bundle = new Bundle();
                bundle.putString("utteranceId", str3);
                bundle.putString("com.google.android.tts:Mode", "LocalOnly");
                for (nf nfVar : ((nl) efVar2.d.b()).h) {
                    bundle.putString(nfVar.b, nfVar.c);
                }
                textToSpeech = efVar2.h;
                if (textToSpeech != null) {
                    iSynthesizeToFile = textToSpeech.synthesizeToFile(str2, bundle, new File(absolutePath), str3);
                } else {
                    iSynthesizeToFile = -1;
                }
            } else {
                try {
                    j = ((ef) pVar2).b.getApplicationContext().getPackageManager().getPackageInfo(ImePackages.GOOGLE_TTS, 0).versionCode;
                } catch (Exception unused) {
                    j = -1;
                }
                if (j >= 210316593) {
                    int iP = rVarB.n().p();
                    int iR = rVarB.n().r();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("utteranceId", str3);
                    bundle2.putString("com.google.android.tts:Mode", "LocalOnly");
                    for (nf nfVar2 : ((nl) efVar2.d.b()).h) {
                        bundle2.putString(nfVar2.b, nfVar2.c);
                    }
                    com.google.android.libraries.navigation.internal.aes.c cVar = (com.google.android.libraries.navigation.internal.aes.c) com.google.android.libraries.navigation.internal.aes.d.a.q();
                    if (!cVar.b.H()) {
                        cVar.v();
                    }
                    com.google.android.libraries.navigation.internal.aes.d dVar = (com.google.android.libraries.navigation.internal.aes.d) cVar.b;
                    dVar.b |= 1;
                    dVar.c = iP;
                    if (!cVar.b.H()) {
                        cVar.v();
                    }
                    com.google.android.libraries.navigation.internal.aes.d dVar2 = (com.google.android.libraries.navigation.internal.aes.d) cVar.b;
                    dVar2.b |= 2;
                    dVar2.d = iR;
                    com.google.android.libraries.navigation.internal.aes.d dVar3 = (com.google.android.libraries.navigation.internal.aes.d) cVar.t();
                    com.google.android.libraries.navigation.internal.aes.g gVar = (com.google.android.libraries.navigation.internal.aes.g) com.google.android.libraries.navigation.internal.aes.h.a.q();
                    if (!gVar.b.H()) {
                        gVar.v();
                    }
                    com.google.android.libraries.navigation.internal.aes.h hVar = (com.google.android.libraries.navigation.internal.aes.h) gVar.b;
                    dVar3.getClass();
                    hVar.f = dVar3;
                    hVar.b |= 16;
                    com.google.android.libraries.navigation.internal.aes.h hVar2 = (com.google.android.libraries.navigation.internal.aes.h) gVar.t();
                    com.google.android.libraries.navigation.internal.afg.m mVar = (com.google.android.libraries.navigation.internal.afg.m) com.google.android.libraries.navigation.internal.afg.n.a.q();
                    if (!mVar.b.H()) {
                        mVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afg.n nVar = (com.google.android.libraries.navigation.internal.afg.n) mVar.b;
                    hVar2.getClass();
                    nVar.c = hVar2;
                    nVar.b |= 1;
                    com.google.android.libraries.navigation.internal.afg.n nVar2 = (com.google.android.libraries.navigation.internal.afg.n) mVar.t();
                    com.google.android.libraries.navigation.internal.afg.a aVar = (com.google.android.libraries.navigation.internal.afg.a) com.google.android.libraries.navigation.internal.afg.b.a.q();
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afg.b bVar = (com.google.android.libraries.navigation.internal.afg.b) aVar.b;
                    nVar2.getClass();
                    bVar.c = nVar2;
                    bVar.b |= 1;
                    com.google.android.libraries.navigation.internal.afg.b bVar2 = (com.google.android.libraries.navigation.internal.afg.b) aVar.t();
                    com.google.android.libraries.navigation.internal.afg.i iVar = (com.google.android.libraries.navigation.internal.afg.i) com.google.android.libraries.navigation.internal.afg.j.a.q();
                    if (!iVar.b.H()) {
                        iVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afg.j jVar = (com.google.android.libraries.navigation.internal.afg.j) iVar.b;
                    bVar2.getClass();
                    jVar.d = bVar2;
                    jVar.b |= 8;
                    if (!iVar.b.H()) {
                        iVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afg.j jVar2 = (com.google.android.libraries.navigation.internal.afg.j) iVar.b;
                    str2.getClass();
                    jVar2.b |= 2;
                    jVar2.c = str2;
                    com.google.android.libraries.navigation.internal.afg.j jVar3 = (com.google.android.libraries.navigation.internal.afg.j) iVar.t();
                    com.google.android.libraries.navigation.internal.afg.k kVar = (com.google.android.libraries.navigation.internal.afg.k) com.google.android.libraries.navigation.internal.afg.l.a.q();
                    if (!kVar.b.H()) {
                        kVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afg.l lVar = (com.google.android.libraries.navigation.internal.afg.l) kVar.b;
                    jVar3.getClass();
                    bz bzVar = lVar.c;
                    if (!bzVar.c()) {
                        lVar.c = bi.A(bzVar);
                    }
                    lVar.c.add(jVar3);
                    if (!kVar.b.H()) {
                        kVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afg.l lVar2 = (com.google.android.libraries.navigation.internal.afg.l) kVar.b;
                    lVar2.b |= 2;
                    lVar2.d = true;
                    com.google.android.libraries.navigation.internal.afg.l lVar3 = (com.google.android.libraries.navigation.internal.afg.l) kVar.t();
                    com.google.android.libraries.navigation.internal.afg.d dVar4 = (com.google.android.libraries.navigation.internal.afg.d) com.google.android.libraries.navigation.internal.afg.e.a.q();
                    if (!dVar4.b.H()) {
                        dVar4.v();
                    }
                    com.google.android.libraries.navigation.internal.afg.e eVar = (com.google.android.libraries.navigation.internal.afg.e) dVar4.b;
                    lVar3.getClass();
                    eVar.c = lVar3;
                    eVar.b = 2;
                    com.google.android.libraries.navigation.internal.afg.e eVar2 = (com.google.android.libraries.navigation.internal.afg.e) dVar4.t();
                    com.google.android.libraries.navigation.internal.afh.a aVar2 = (com.google.android.libraries.navigation.internal.afh.a) com.google.android.libraries.navigation.internal.afh.b.a.q();
                    com.google.android.libraries.navigation.internal.afg.c cVar2 = (com.google.android.libraries.navigation.internal.afg.c) com.google.android.libraries.navigation.internal.afg.f.a.q();
                    if (!cVar2.b.H()) {
                        cVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.afg.f fVar3 = (com.google.android.libraries.navigation.internal.afg.f) cVar2.b;
                    eVar2.getClass();
                    bz bzVar2 = fVar3.b;
                    if (!bzVar2.c()) {
                        fVar3.b = bi.A(bzVar2);
                    }
                    fVar3.b.add(eVar2);
                    com.google.android.libraries.navigation.internal.afg.f fVar4 = (com.google.android.libraries.navigation.internal.afg.f) cVar2.t();
                    if (!aVar2.b.H()) {
                        aVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.afh.b bVar3 = (com.google.android.libraries.navigation.internal.afh.b) aVar2.b;
                    fVar4.getClass();
                    bVar3.c = fVar4;
                    bVar3.b |= 1;
                    bundle2.putByteArray("com.google.android.tts:TextProto", ((com.google.android.libraries.navigation.internal.afh.b) aVar2.t()).m());
                    TextToSpeech textToSpeech3 = efVar2.h;
                    if (textToSpeech3 != null) {
                        iSynthesizeToFile = textToSpeech3.synthesizeToFile(str2, bundle2, new File(absolutePath), str3);
                    } else {
                        iSynthesizeToFile = -1;
                    }
                } else {
                    bundle = new Bundle();
                    bundle.putString("utteranceId", str3);
                    bundle.putString("com.google.android.tts:Mode", "LocalOnly");
                    while (r4.hasNext()) {
                        bundle.putString(nfVar.b, nfVar.c);
                    }
                    textToSpeech = efVar2.h;
                    if (textToSpeech != null) {
                        iSynthesizeToFile = textToSpeech.synthesizeToFile(str2, bundle, new File(absolutePath), str3);
                    } else {
                        iSynthesizeToFile = -1;
                    }
                }
            }
            if (iSynthesizeToFile != -1) {
                return;
            }
        }
        this.d.e(this.a);
    }
}
