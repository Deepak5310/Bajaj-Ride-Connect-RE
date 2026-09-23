package com.google.android.libraries.navigation.internal.afn;

import java.util.HashMap;
import java.util.Stack;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends DefaultHandler {
    HashMap a = new HashMap();
    Stack b = new Stack();

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        if (this.b.size() > 0) {
            h hVar = (h) this.b.lastElement();
            hVar.c.append("</");
            hVar.c.append(str2);
            hVar.c.append(">");
            int i = hVar.b - 1;
            hVar.b = i;
            if (i == 0) {
                String string = hVar.c.toString();
                this.a.put(hVar.a, string);
                this.b.pop();
                if (this.b.size() > 0) {
                    ((h) this.b.lastElement()).c.append(string);
                }
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        String value = attributes.getValue("id");
        if (value != null) {
            this.b.push(new h(value));
        }
        if (this.b.size() > 0) {
            h hVar = (h) this.b.lastElement();
            hVar.b++;
            StringBuilder sb = hVar.c;
            sb.append("<");
            sb.append(str2);
            for (int i = 0; i < attributes.getLength(); i++) {
                sb.append(StringUtils.SPACE);
                sb.append(attributes.getQName(i));
                sb.append("='");
                sb.append(o.c(attributes.getValue(i)));
                sb.append("'");
            }
            sb.append(">");
        }
    }
}
