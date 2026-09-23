package com.google.android.libraries.navigation.internal.fi;

import android.util.Xml;
import androidx.core.app.NotificationCompat;
import com.google.android.libraries.navigation.internal.agi.dv;
import com.google.android.libraries.navigation.internal.agi.dy;
import com.google.android.libraries.navigation.internal.dh.ad;
import com.google.android.libraries.navigation.internal.dh.ai;
import com.google.android.libraries.navigation.internal.dh.ar;
import com.google.android.libraries.navigation.internal.yz.fy;
import de.patwoz.rn.bluetoothstatemanager.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.google.android.libraries.navigation.internal.ia.b, com.google.android.libraries.navigation.internal.fq.p {
    public static final /* synthetic */ int c = 0;
    private final i e;
    private final i f;
    private final com.google.android.libraries.navigation.internal.mj.a g;
    private final String h;
    private volatile int i;
    static final String[] a = {"<!-- Event track created by EventTrackRecorder. -->\n", "<!-- NOTE: The location information and serialized requests and responses in -->\n", "<!-- this event-track may contain sensitive or personal information. -->\n", "<!-- This information should only be used to debug issues or to make general -->\n", "<!-- product improvements (e.g. to improve the road-snapping location algorithm), -->\n", "<!-- but not to track any additional information about the reporter. -->\n"};
    static final String[] b = {"<!-- This file contains a trace of recent location, sensor and route data in XML format. -->\n"};
    private static final fy d = fy.u(com.google.android.libraries.navigation.internal.dh.a.class, com.google.android.libraries.navigation.internal.dh.g.class, com.google.android.libraries.navigation.internal.dh.i.class, com.google.android.libraries.navigation.internal.aq.b.class, com.google.android.libraries.navigation.internal.aq.c.class, com.google.android.libraries.navigation.internal.aq.d.class, com.google.android.libraries.navigation.internal.aq.e.class, com.google.android.libraries.navigation.internal.cy.a.class, com.google.android.libraries.navigation.internal.aq.g.class, com.google.android.libraries.navigation.internal.dh.q.class, com.google.android.libraries.navigation.internal.aq.h.class, com.google.android.libraries.navigation.internal.aq.i.class, com.google.android.libraries.navigation.internal.gz.d.class, com.google.android.libraries.navigation.internal.dh.r.class, com.google.android.libraries.navigation.internal.dh.s.class, com.google.android.libraries.navigation.internal.aq.k.class, com.google.android.libraries.navigation.internal.dh.y.class, com.google.android.libraries.navigation.internal.fw.t.class, com.google.android.libraries.navigation.internal.da.h.class, ad.class, com.google.android.libraries.navigation.internal.sw.f.class, ai.class, ar.class, com.google.android.libraries.navigation.internal.fk.a.class, com.google.android.libraries.navigation.internal.as.a.class);

    private j(String str, int i, com.google.android.libraries.navigation.internal.mj.a aVar, i iVar, i iVar2) {
        this.i = 1;
        this.h = str == null ? Constants.BluetoothState.UNKNOWN : str;
        this.i = i;
        this.g = aVar;
        this.e = iVar;
        this.f = iVar2;
    }

    public static j f(String str, int i, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.a aVar2) {
        if (i == 2 && !aVar2.a()) {
            String str2 = aVar2.h;
            String str3 = com.google.android.libraries.navigation.internal.ia.a.EXTERNAL.h;
            aVar2 = com.google.android.libraries.navigation.internal.ia.a.EXTERNAL;
        }
        int i2 = aVar2.k;
        int i3 = aVar2.i;
        return new j(str, i, aVar, new i(i2, i3, i3), new i(aVar2.l, aVar2.i, aVar2.j));
    }

    private final boolean i() {
        return this.i != 1;
    }

    private final boolean j() {
        return this.i == 2;
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final String a() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final String b() {
        ArrayList<com.google.android.libraries.navigation.internal.kp.a> arrayList;
        if (!i()) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (i()) {
                for (String str : j() ? b : a) {
                    printWriter.write("");
                    printWriter.write(str);
                }
                printWriter.write("");
                printWriter.write("<!-- ");
                printWriter.write("Version: ");
                printWriter.write(this.h);
                printWriter.write(" -->\n");
                printWriter.write("");
                printWriter.write("<event-track>\n");
                long jA = this.g.a();
                synchronized (this) {
                    if (j()) {
                        this.e.f(jA);
                        this.f.f(jA);
                    }
                    arrayList = new ArrayList(this.e.a() + this.f.a());
                    this.e.c(arrayList, jA);
                    this.f.c(arrayList, jA);
                }
                Collections.sort(arrayList);
                try {
                    XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                    for (com.google.android.libraries.navigation.internal.kp.a aVar : arrayList) {
                        printWriter.write("");
                        com.google.android.libraries.navigation.internal.kp.f fVarN = aVar.n();
                        xmlSerializerNewSerializer.setOutput(printWriter);
                        xmlSerializerNewSerializer.startTag(null, NotificationCompat.CATEGORY_EVENT);
                        xmlSerializerNewSerializer.attribute(null, "time", Long.toString(fVarN.c));
                        xmlSerializerNewSerializer.startTag(null, fVarN.a);
                        dv dvVar = new dv((dy) fVarN.b.d());
                        while (dvVar.hasNext()) {
                            Map.Entry entry = (Map.Entry) dvVar.next();
                            xmlSerializerNewSerializer.attribute(null, (String) entry.getKey(), (String) entry.getValue());
                        }
                        xmlSerializerNewSerializer.endTag(null, fVarN.a);
                        xmlSerializerNewSerializer.endTag(null, NotificationCompat.CATEGORY_EVENT);
                        xmlSerializerNewSerializer.endDocument();
                        printWriter.write("\n");
                    }
                    printWriter.write("");
                    printWriter.write("</event-track>\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            printWriter.close();
            return stringWriter.toString();
        } catch (Throwable th) {
            try {
                printWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final void c(com.google.android.libraries.navigation.internal.ic.a aVar) {
        if (aVar instanceof com.google.android.libraries.navigation.internal.kp.e) {
            com.google.android.libraries.navigation.internal.kp.e eVar = (com.google.android.libraries.navigation.internal.kp.e) aVar;
            if (eVar.k() && i()) {
                if (!j() || d.contains(eVar.getClass())) {
                    com.google.android.libraries.navigation.internal.kp.a aVarP = eVar.p(this.g.a());
                    synchronized (this) {
                        if (aVarP instanceof com.google.android.libraries.navigation.internal.kp.d) {
                            this.f.b(aVarP);
                        } else {
                            this.e.b(aVarP);
                        }
                        aVarP.d();
                    }
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final void d(com.google.android.libraries.navigation.internal.ia.a aVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        if (j() && !aVar.a()) {
            String str = aVar.h;
            return;
        }
        synchronized (this) {
            i iVar = this.e;
            int i = aVar.k;
            int i2 = aVar.i;
            iVar.e(i, i2, i2);
            this.f.e(aVar.l, aVar.i, aVar.j);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final boolean e() {
        return this.i != 1;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final synchronized void g(int i) {
        if (i == this.i) {
            return;
        }
        this.f.d();
        this.e.d();
        this.i = i;
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final void h(float f) {
        com.google.android.libraries.navigation.internal.fk.a aVar = new com.google.android.libraries.navigation.internal.fk.a("cache-trimmed", Float.toString(f));
        long jA = this.g.a();
        synchronized (this) {
            this.f.g(f, jA, null);
            this.e.g(f, jA, aVar);
        }
    }
}
