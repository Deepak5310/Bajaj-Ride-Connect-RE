package com.google.android.libraries.navigation.internal.ks;

import android.graphics.Bitmap;
import com.google.android.libraries.navigation.internal.zn.e;
import com.google.android.libraries.navigation.internal.zn.f;
import com.google.android.libraries.navigation.internal.zn.g;
import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static String a(Bitmap bitmap) {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("data:image/png;base64,");
        e eVar = new e((f) g.d, stringWriter);
        if (!bitmap.compress(Bitmap.CompressFormat.PNG, 100, eVar)) {
            return "";
        }
        try {
            eVar.close();
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }
}
