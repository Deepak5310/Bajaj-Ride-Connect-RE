package com.google.android.libraries.navigation.internal.sk;

import android.app.Application;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.common.util.zzb$$ExternalSyntheticApiModelOutline0;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bf implements AudioManager.OnAudioFocusChangeListener, af {
    public static final /* synthetic */ int t = 0;
    public final Application b;
    public final AudioManager c;
    public final com.google.android.libraries.navigation.internal.ia.e d;
    public final com.google.android.libraries.navigation.internal.iv.f e;
    public final com.google.android.libraries.navigation.internal.aac.bn f;
    public final com.google.android.libraries.navigation.internal.mj.a g;
    public final aa h;
    public ae i;
    public final Executor j;
    public final com.google.android.libraries.navigation.internal.aac.bn k;
    public volatile long m;
    public com.google.android.libraries.navigation.internal.yp.a o;
    public com.google.android.libraries.navigation.internal.sl.i p;
    public int r;
    private final com.google.android.libraries.navigation.internal.jy.af v;
    private final com.google.android.libraries.navigation.internal.jy.t w;
    private final com.google.android.libraries.navigation.internal.rw.f x;
    private AudioFocusRequest y;
    private static final com.google.android.libraries.navigation.internal.zb.j u = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sk.bf");
    static final long a = TimeUnit.MINUTES.toMillis(1);
    public final AtomicInteger q = new AtomicInteger(0);
    final av s = new av(this);
    public ad l = ad.NEVER_PLAY_ALERT;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.sl.i f573n = com.google.android.libraries.navigation.internal.sl.i.IDLE;

    public bf(Application application, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.iv.f fVar2, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.mj.a aVar, aa aaVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, com.google.android.libraries.navigation.internal.aac.bn bnVar, com.google.android.libraries.navigation.internal.aac.bn bnVar2) {
        this.b = application;
        this.x = fVar;
        this.e = fVar2;
        this.d = eVar;
        this.g = aVar;
        this.h = aaVar;
        this.c = (AudioManager) application.getSystemService("audio");
        this.v = afVar;
        this.w = tVar;
        this.f = bnVar;
        this.j = new com.google.android.libraries.navigation.internal.aac.bz(bnVar2);
        this.k = bnVar2;
    }

    private final com.google.android.libraries.navigation.internal.aac.bj i() {
        return com.google.android.libraries.navigation.internal.aac.az.k(new ax(this), this.j);
    }

    @Override // com.google.android.libraries.navigation.internal.sk.af
    public final com.google.android.libraries.navigation.internal.aac.bj a(final com.google.android.libraries.navigation.internal.sl.h hVar) {
        final com.google.android.libraries.navigation.internal.aac.bj bjVarC = c();
        final com.google.android.libraries.navigation.internal.aac.bj bjVarJ = j();
        return com.google.android.libraries.navigation.internal.aac.j.i(com.google.android.libraries.navigation.internal.aac.az.c(bjVarC, bjVarJ).a(new Callable() { // from class: com.google.android.libraries.navigation.internal.sk.am
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int i = bf.t;
                boolean z = false;
                if (Objects.equals(com.google.android.libraries.navigation.internal.aac.az.n(bjVarC), Boolean.TRUE) && Objects.equals(com.google.android.libraries.navigation.internal.aac.az.n(bjVarJ), Boolean.FALSE)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }, this.k), new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.sk.an
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final com.google.android.libraries.navigation.internal.aac.bj a(Object obj) {
                boolean zEquals = Objects.equals((Boolean) obj, Boolean.TRUE);
                final bf bfVar = this.a;
                if (zEquals) {
                    bfVar.e(ad.NEVER_PLAY_ALERT);
                    return com.google.android.libraries.navigation.internal.aac.az.h(ad.NEVER_PLAY_ALERT);
                }
                final com.google.android.libraries.navigation.internal.sl.h hVar2 = hVar;
                return com.google.android.libraries.navigation.internal.aac.j.i(com.google.android.libraries.navigation.internal.aac.az.k(new Callable() { // from class: com.google.android.libraries.navigation.internal.sk.ah
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return bfVar.l;
                    }
                }, bfVar.j), new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.sk.ai
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final com.google.android.libraries.navigation.internal.aac.bj a(Object obj2) {
                        ad adVar = (ad) obj2;
                        if (adVar != ad.NEVER_PLAY_ALERT) {
                            return com.google.android.libraries.navigation.internal.aac.az.h(adVar);
                        }
                        final com.google.android.libraries.navigation.internal.sl.h hVar3 = hVar2;
                        final bf bfVar2 = bfVar;
                        return com.google.android.libraries.navigation.internal.aac.j.i(com.google.android.libraries.navigation.internal.aac.az.k(new Callable() { // from class: com.google.android.libraries.navigation.internal.sk.aj
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                bf bfVar3 = bfVar2;
                                return new be(((ac) bfVar3.h).b.getDefaultRoute().getVolume(), bfVar3.h.a());
                            }
                        }, bfVar2.f), new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.sk.ak
                            @Override // com.google.android.libraries.navigation.internal.aac.t
                            public final com.google.android.libraries.navigation.internal.aac.bj a(Object obj3) {
                                int mode;
                                TelephonyManager telephonyManager;
                                be beVar = (be) obj3;
                                boolean z = ((be) Objects.requireNonNull(beVar)).b;
                                final bf bfVar3 = bfVar2;
                                com.google.android.libraries.navigation.internal.sl.h hVar4 = hVar3;
                                if (!z) {
                                    bfVar3.e(bfVar3.g(hVar4, true == ((com.google.android.libraries.navigation.internal.sl.k) hVar4.l).d ? 3 : 4) ? ad.READY_TO_PLAY_ALERT : ad.NEVER_PLAY_ALERT);
                                } else {
                                    if (beVar.a == 0 && bfVar3.q.get() == 0) {
                                        bfVar3.e(ad.NEVER_PLAY_ALERT);
                                        return com.google.android.libraries.navigation.internal.aac.az.h(ad.NEVER_PLAY_ALERT);
                                    }
                                    if (bfVar3.g(hVar4, 4)) {
                                        com.google.android.libraries.navigation.internal.aac.bn bnVar = bfVar3.f;
                                        final aa aaVar = bfVar3.h;
                                        Objects.requireNonNull(aaVar);
                                        bnVar.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.ap
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
                                                ac acVar = (ac) aaVar;
                                                if (!acVar.a()) {
                                                    av avVar = acVar.f;
                                                    if (avVar != null) {
                                                        avVar.a();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                if (acVar.d == null) {
                                                    acVar.d = new ab(acVar);
                                                    acVar.b.addCallback(ac.a, acVar.d, 4);
                                                }
                                                acVar.c = acVar.b.getSelectedRoute();
                                                acVar.e = 2;
                                                MediaRouter mediaRouter = acVar.b;
                                                mediaRouter.selectRoute(mediaRouter.getDefaultRoute());
                                            }
                                        });
                                        bfVar3.e(ad.WAIT_TO_PLAY_ALERT);
                                    } else {
                                        bfVar3.e(ad.NEVER_PLAY_ALERT);
                                    }
                                }
                                if (Build.VERSION.SDK_INT >= 31 ? (mode = bfVar3.c.getMode()) == 2 || mode == 3 : (telephonyManager = (TelephonyManager) bfVar3.b.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)) != null && telephonyManager.getCallState() != 0) {
                                    if (bfVar3.e.y(com.google.android.libraries.navigation.internal.iv.ab.aK, true)) {
                                        return com.google.android.libraries.navigation.internal.aac.az.h(ad.READY_TO_PLAY_ALERT);
                                    }
                                }
                                return com.google.android.libraries.navigation.internal.aac.az.k(new Callable() { // from class: com.google.android.libraries.navigation.internal.sk.aq
                                    @Override // java.util.concurrent.Callable
                                    public final Object call() {
                                        return bfVar3.l;
                                    }
                                }, bfVar3.j);
                            }
                        }, bfVar2.k);
                    }
                }, bfVar.k);
            }
        }, this.k);
    }

    @Override // com.google.android.libraries.navigation.internal.sk.af
    public final void b(final com.google.android.libraries.navigation.internal.sl.i iVar) {
        this.j.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.as
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f573n = iVar;
            }
        });
        final com.google.android.libraries.navigation.internal.aac.bj bjVarC = c();
        final com.google.android.libraries.navigation.internal.aac.bj bjVarJ = j();
        com.google.android.libraries.navigation.internal.aac.az.o(com.google.android.libraries.navigation.internal.aac.az.c(bjVarC, bjVarJ).a(new Callable() { // from class: com.google.android.libraries.navigation.internal.sk.at
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int i = bf.t;
                boolean z = true;
                if (!Objects.equals(com.google.android.libraries.navigation.internal.aac.az.n(bjVarC), Boolean.FALSE) && !Objects.equals(com.google.android.libraries.navigation.internal.aac.az.n(bjVarJ), Boolean.TRUE)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, this.k), new aw(this, iVar), this.j);
    }

    public final com.google.android.libraries.navigation.internal.aac.bj c() {
        return com.google.android.libraries.navigation.internal.aac.j.i(i(), new ba(this), this.k);
    }

    public final void e(final ad adVar) {
        this.j.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.ao
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l = adVar;
            }
        });
    }

    public final void f(final com.google.android.libraries.navigation.internal.yp.a aVar) {
        this.j.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.ag
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.sl.i iVar;
                final bf bfVar = this.a;
                com.google.android.libraries.navigation.internal.yp.a aVar2 = aVar;
                bfVar.o = aVar2;
                bfVar.m = bfVar.g.a();
                if (aVar2 == com.google.android.libraries.navigation.internal.yp.a.IDLE) {
                    if (bfVar.p != com.google.android.libraries.navigation.internal.sl.i.PROCESSING) {
                        bfVar.h(bfVar.f573n, 1);
                        return;
                    }
                    bfVar.p = bfVar.f573n;
                    bfVar.r = 1;
                    bfVar.k.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.ar
                        @Override // java.lang.Runnable
                        public final void run() {
                            bf bfVar2 = bfVar;
                            com.google.android.libraries.navigation.internal.aac.az.o(com.google.android.libraries.navigation.internal.aac.az.k(new bc(bfVar2), bfVar2.j), new bd(bfVar2), bfVar2.f);
                        }
                    }, 100L, TimeUnit.MILLISECONDS);
                    return;
                }
                ae aeVar = bfVar.i;
                if (aeVar != null) {
                    aeVar.p();
                }
                int iOrdinal = aVar2.ordinal();
                if (iOrdinal == 1) {
                    iVar = com.google.android.libraries.navigation.internal.sl.i.LISTENING;
                } else if (iOrdinal == 2) {
                    iVar = com.google.android.libraries.navigation.internal.sl.i.RECORDING;
                } else if (iOrdinal != 3) {
                    iVar = iOrdinal != 4 ? com.google.android.libraries.navigation.internal.sl.i.IDLE : com.google.android.libraries.navigation.internal.sl.i.PLAYING_PROMPTED;
                } else {
                    iVar = com.google.android.libraries.navigation.internal.sl.i.PROCESSING;
                }
                bfVar.h(iVar, 2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004c  */
    public final boolean g(com.google.android.libraries.navigation.internal.sl.h hVar, int i) {
        int iRequestAudioFocus;
        AudioAttributes audioAttributesBuild;
        if (Build.VERSION.SDK_INT >= 26) {
            AudioManager audioManager = this.c;
            AudioFocusRequest.Builder builderM = zzb$$ExternalSyntheticApiModelOutline0.m(i);
            int iOrdinal = ((com.google.android.libraries.navigation.internal.sl.k) hVar.l).h.ordinal();
            if (iOrdinal == 0) {
                audioAttributesBuild = new AudioAttributes.Builder().setUsage(12).setContentType(1).build();
            } else if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    audioAttributesBuild = new AudioAttributes.Builder().setUsage(0).setContentType(0).build();
                } else {
                    audioAttributesBuild = new AudioAttributes.Builder().setUsage(10).setContentType(1).build();
                }
            } else if (Build.VERSION.SDK_INT >= 26) {
                audioAttributesBuild = new AudioAttributes.Builder().setUsage(16).setContentType(1).build();
            } else {
                audioAttributesBuild = new AudioAttributes.Builder().setUsage(0).setContentType(0).build();
            }
            AudioFocusRequest audioFocusRequestBuild = builderM.setAudioAttributes(audioAttributesBuild).setOnAudioFocusChangeListener(this).build();
            this.y = audioFocusRequestBuild;
            iRequestAudioFocus = audioManager.requestAudioFocus(audioFocusRequestBuild);
        } else {
            iRequestAudioFocus = this.c.requestAudioFocus(this, 3, i);
        }
        return iRequestAudioFocus == 1;
    }

    public final void h(final com.google.android.libraries.navigation.internal.sl.i iVar, final int i) {
        if (iVar != this.p) {
            this.p = iVar;
            this.r = i;
            this.k.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.al
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d.a(new com.google.android.libraries.navigation.internal.sm.a(iVar));
                }
            });
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        if (i == -1 || i == -2) {
            ae aeVar = this.i;
            if (aeVar != null) {
                aeVar.p();
            }
            d();
        }
    }

    private final com.google.android.libraries.navigation.internal.aac.bj j() {
        ae aeVar = this.i;
        return com.google.android.libraries.navigation.internal.aac.j.h(i(), new bb(aeVar == null ? null : aeVar.g()), this.k);
    }

    public final void d() {
        AudioFocusRequest audioFocusRequest;
        if (Build.VERSION.SDK_INT < 26 || (audioFocusRequest = this.y) == null) {
            this.c.abandonAudioFocus(this);
        } else {
            this.c.abandonAudioFocusRequest(audioFocusRequest);
        }
        e(ad.NEVER_PLAY_ALERT);
    }
}
