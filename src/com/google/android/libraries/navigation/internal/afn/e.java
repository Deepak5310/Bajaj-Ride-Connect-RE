package com.google.android.libraries.navigation.internal.afn;

import android.graphics.Picture;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public InputStream a = null;
    private boolean c = false;
    private final float d = 72.0f;
    public boolean b = false;

    public final b a() throws d {
        InputStream inputStream = this.a;
        if (inputStream == null) {
            throw new IllegalStateException("No input SVG provided");
        }
        boolean z = this.c;
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            Picture picture = new Picture();
            m mVar = new m(picture);
            mVar.q = 72.0f;
            if (z) {
                xMLReader.setContentHandler(mVar);
                xMLReader.parse(new InputSource(inputStream));
            } else {
                f fVar = new f(inputStream);
                i iVar = new i();
                xMLReader.setContentHandler(iVar);
                xMLReader.parse(new InputSource(fVar.a()));
                mVar.a = iVar.a;
                xMLReader.setContentHandler(mVar);
                xMLReader.parse(new InputSource(fVar.a()));
            }
            b bVar = new b(picture);
            float f = mVar.p.top;
            if (this.b) {
                try {
                    this.a.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return bVar;
        } catch (Exception e2) {
            throw new d(e2);
        }
    }

    public final void b() {
        this.c = true;
    }
}
