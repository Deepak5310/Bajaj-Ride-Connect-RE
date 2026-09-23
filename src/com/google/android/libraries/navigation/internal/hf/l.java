package com.google.android.libraries.navigation.internal.hf;

import android.text.SpannableStringBuilder;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.MissingFormatArgumentException;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends m {
    public n.a a;

    public l(n nVar, CharSequence charSequence) {
        super(charSequence);
        this.a = new n.a();
    }

    private final CharSequence j(String str, Object obj) {
        if (!(obj instanceof m)) {
            return (str.equals("%s") && (obj instanceof CharSequence)) ? (CharSequence) obj : String.format(str, obj);
        }
        m mVar = (m) obj;
        this.e = Math.max(mVar.e + 1, this.e);
        return super.c(str);
    }

    public final void a(Object... objArr) {
        ArrayList<j> arrayList;
        int i;
        String strConcat;
        int i2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("Styler.DeferredText#args");
        try {
            String string = this.b.toString();
            int i3 = 0;
            if (string.contains("{0}")) {
                arrayList = new ArrayList();
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    String strJ = com.google.android.libraries.navigation.internal.b.b.j(i4, "{", "}");
                    int iIndexOf = string.indexOf(strJ);
                    if (iIndexOf < 0) {
                        throw new MissingFormatArgumentException(strJ);
                    }
                    arrayList.add(new j(iIndexOf, strJ.length() + iIndexOf, j("%s", objArr[i4])));
                }
                arrayList.sort(Comparator.comparingInt(new ToIntFunction() { // from class: com.google.android.libraries.navigation.internal.hf.k
                    @Override // java.util.function.ToIntFunction
                    public final int applyAsInt(Object obj) {
                        return ((j) obj).a;
                    }
                }));
            } else {
                arrayList = new ArrayList();
                Matcher matcher = n.a.matcher(string);
                int i5 = 0;
                while (matcher.find()) {
                    String strGroup = matcher.group();
                    if (strGroup.equals("%%")) {
                        arrayList.add(new j(matcher.start(), matcher.end(), "%"));
                    } else {
                        String strGroup2 = matcher.group(1);
                        if (strGroup2 != null) {
                            i = Integer.parseInt(strGroup2.substring(0, strGroup2.length() - 1)) - 1;
                            strConcat = "%".concat(String.valueOf(strGroup.substring(strGroup2.length() + 1)));
                        } else {
                            i = i5;
                            strConcat = strGroup;
                        }
                        if (i >= objArr.length) {
                            throw new MissingFormatArgumentException(strGroup);
                        }
                        arrayList.add(new j(matcher.start(), matcher.end(), j(strConcat, objArr[i])));
                        i5++;
                    }
                }
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            int length = 0;
            for (j jVar : arrayList) {
                if (!this.a.a.isEmpty() && (i2 = jVar.a) > i3) {
                    this.a.a(spannableStringBuilder, this.e, i3 + length, i2 + length);
                }
                i3 = jVar.b;
                spannableStringBuilder.replace(jVar.a + length, length + i3, jVar.c);
                length += jVar.c.length() - (jVar.b - jVar.a);
            }
            if (!this.a.a.isEmpty() && i3 < string.length()) {
                this.a.a(spannableStringBuilder, this.e, i3 + length, length + string.length());
            }
            this.b = spannableStringBuilder;
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
