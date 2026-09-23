package com.google.android.libraries.navigation.internal.il;

import com.google.android.libraries.navigation.internal.afl.at;
import com.google.android.libraries.navigation.internal.fw.n;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface a {
    String a();

    void b(String str);

    void c();

    void d(DataOutputStream dataOutputStream, n nVar) throws IOException;

    boolean e();

    at f(ByteBuffer byteBuffer, String str) throws IOException;

    void g(DataOutputStream dataOutputStream, n nVar, boolean z, com.google.android.libraries.navigation.internal.io.b bVar, String str) throws IOException;
}
