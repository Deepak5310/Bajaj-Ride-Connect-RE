package com.google.android.libraries.places.internal;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzblh implements Runnable {
    final /* synthetic */ CountDownLatch zza;
    final /* synthetic */ zzbkn zzb;
    final /* synthetic */ zzblk zzc;

    zzblh(zzblk zzblkVar, CountDownLatch countDownLatch, zzbkn zzbknVar) {
        this.zzc = zzblkVar;
        this.zza = countDownLatch;
        this.zzb = zzbknVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        Socket socketZzA;
        try {
            this.zza.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        zzbpn zzbpnVarZzb = zzbpr.zzb(new zzblg(this));
        try {
            try {
                zzblk zzblkVar = this.zzc;
                zzatq zzatqVar = zzblkVar.zza;
                SSLSession session = null;
                if (zzatqVar == null) {
                    socketZzA = zzblkVar.zzE.createSocket(zzblkVar.zze.getAddress(), this.zzc.zze.getPort());
                } else {
                    if (!(zzatqVar.zze() instanceof InetSocketAddress)) {
                        throw new zzaxe(zzaxd.zzo.zzg("Unsupported SocketAddress implementation " + String.valueOf(this.zzc.zza.zze().getClass())), null);
                    }
                    socketZzA = zzblk.zzA(zzblkVar, zzatqVar.zzd(), (InetSocketAddress) zzatqVar.zze(), this.zzc.zza.zzc(), this.zzc.zza.zzb());
                }
                zzblk zzblkVar2 = this.zzc;
                Socket socket = socketZzA;
                if (zzblkVar2.zzF != null) {
                    SSLSocketFactory sSLSocketFactory = zzblkVar2.zzF;
                    String strZzy = zzblkVar2.zzy();
                    int iZzh = this.zzc.zzh();
                    zzbme zzbmeVar = this.zzc.zzJ;
                    zzkt.zzc(sSLSocketFactory, "sslSocketFactory");
                    zzkt.zzc(socketZzA, "socket");
                    zzkt.zzc(zzbmeVar, "spec");
                    SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socketZzA, strZzy, iZzh, true);
                    zzbmeVar.zza(sSLSocket, false);
                    String strZzb = zzblp.zzd().zzb(sSLSocket, strZzy, zzbmeVar.zzb() ? zzblr.zza : null);
                    zzkt.zzq(zzblr.zza.contains(zzbmu.zza(strZzb)), "Only " + String.valueOf(zzblr.zza) + " are supported, but negotiated protocol is %s", strZzb);
                    if (!zzbmj.zza.verify((strZzy.startsWith("[") && strZzy.endsWith("]")) ? strZzy.substring(1, strZzy.length() - 1) : strZzy, sSLSocket.getSession())) {
                        throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(String.valueOf(strZzy)));
                    }
                    session = sSLSocket.getSession();
                    socket = sSLSocket;
                }
                socket.setTcpNoDelay(true);
                zzbpn zzbpnVarZzb2 = zzbpr.zzb(zzbpr.zzd(socket));
                this.zzb.zzm(zzbpr.zzc(socket), socket);
                zzblk zzblkVar3 = this.zzc;
                zzars zzarsVarZzb = zzblkVar3.zzy.zzb();
                zzarsVarZzb.zzb(zzatm.zza, socket.getRemoteSocketAddress());
                zzarsVarZzb.zzb(zzatm.zzb, socket.getLocalSocketAddress());
                zzarsVarZzb.zzb(zzatm.zzc, session);
                zzarsVarZzb.zzb(zzbck.zza, session == null ? zzawu.NONE : zzawu.PRIVACY_AND_INTEGRITY);
                zzblkVar3.zzy = zzarsVarZzb.zzc();
                zzblk zzblkVar4 = this.zzc;
                zzblkVar4.zzx = new zzblj(zzblkVar4, zzblkVar4.zzk.zzc(zzbpnVarZzb2, true));
                synchronized (this.zzc.zzo) {
                    zzblk zzblkVar5 = this.zzc;
                    zzkt.zzc(socket, "socket");
                    zzblkVar5.zzG = socket;
                    if (session != null) {
                        this.zzc.zzP = new zzatv(new zzatw(session));
                    }
                }
            } catch (Throwable th) {
                zzblk zzblkVar6 = this.zzc;
                zzblkVar6.zzx = new zzblj(zzblkVar6, zzblkVar6.zzk.zzc(zzbpnVarZzb, true));
                throw th;
            }
        } catch (zzaxe e) {
            this.zzc.zzaa(0, zzbmx.INTERNAL_ERROR, e.zza());
            zzblk zzblkVar7 = this.zzc;
            zzblkVar7.zzx = new zzblj(zzblkVar7, zzblkVar7.zzk.zzc(zzbpnVarZzb, true));
        } catch (Exception e2) {
            this.zzc.zzb(e2);
            zzblk zzblkVar8 = this.zzc;
            zzblkVar8.zzx = new zzblj(zzblkVar8, zzblkVar8.zzk.zzc(zzbpnVarZzb, true));
        }
    }
}
