package com.google.android.libraries.navigation.internal.fe;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.zb.j;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements a {
    public static final /* synthetic */ int a = 0;
    private static final j b = j.e("com.google.android.libraries.navigation.internal.fe.h");
    private static final Pattern c = Pattern.compile("_(\\d+)_[^\\d]+_(\\d+)$");
    private final String d;
    private volatile an e = com.google.android.libraries.navigation.internal.yx.a.a;
    private final int f;

    public h(String str, int i) {
        if (aq.c(str)) {
            ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 453)).p("Prefix cannot be null or empty");
        }
        if (str.contains("_")) {
            ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 452)).p("Prefix cannot have underscore (_) as it's used as a file parts separator.");
        }
        this.d = str;
        this.f = i;
    }

    private static int c(File file) throws b {
        String name = file.getName();
        try {
            return Integer.parseInt(name.substring(name.lastIndexOf("_") + 1));
        } catch (NumberFormatException e) {
            throw new b("Inconsistent marker file name ".concat(String.valueOf(name)), e, name);
        }
    }

    private static File d(Context context) {
        return new File(com.google.android.libraries.navigation.internal.id.a.a(context), "crash_markers");
    }

    private static boolean e(f fVar) {
        int i = 0;
        do {
            try {
                return fVar.a();
            } catch (Exception e) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalStateException(e))).F((char) 454)).o();
                i++;
            }
        } while (i < 2);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.fe.a
    public final void a(Context context) throws b {
        an anVarJ;
        int length;
        int iC;
        Object gVar;
        String strGroup;
        try {
            File fileD = d(context);
            if (this.e.g()) {
                gVar = this.e.c();
            } else {
                File fileD2 = d(context);
                if (fileD2.exists()) {
                    final String str = String.format("crashloop_%s", this.d);
                    File[] fileArrListFiles = fileD2.listFiles(new FilenameFilter() { // from class: com.google.android.libraries.navigation.internal.fe.e
                        @Override // java.io.FilenameFilter
                        public final boolean accept(File file, String str2) {
                            int i = h.a;
                            return str2.startsWith(str);
                        }
                    });
                    if (fileArrListFiles == null || (length = fileArrListFiles.length) == 0) {
                        anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                    } else if (length == 1) {
                        anVarJ = an.j(fileArrListFiles[0]);
                    } else {
                        File file = fileArrListFiles[0];
                        int i = -1;
                        for (File file2 : fileArrListFiles) {
                            try {
                                iC = c(file2);
                            } catch (b unused) {
                                iC = -1;
                            }
                            if (iC > i) {
                                file = file2;
                            }
                            if (iC > i) {
                                i = iC;
                            }
                        }
                        for (File file3 : fileArrListFiles) {
                            if (!am.a(file3, file)) {
                                file3.delete();
                            }
                        }
                        anVarJ = an.j(file);
                    }
                } else {
                    anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                }
                long j = 0;
                if (anVarJ.g()) {
                    Object objC = anVarJ.c();
                    int i2 = this.f;
                    int iC2 = c((File) anVarJ.c());
                    Matcher matcher = c.matcher(((File) anVarJ.c()).getName());
                    if (matcher.find() && (strGroup = matcher.group(1)) != null) {
                        try {
                            j = Long.parseLong(strGroup);
                        } catch (IllegalStateException | NumberFormatException unused2) {
                        }
                    }
                    gVar = new g((File) objC, new com.google.android.libraries.navigation.internal.fg.a(i2, iC2, j));
                } else {
                    gVar = new g(new File(fileD2, b(0L)), new com.google.android.libraries.navigation.internal.fg.a(this.f, 0, 0L));
                }
                this.e = an.j(gVar);
            }
            try {
                com.google.android.libraries.navigation.internal.fg.a aVar = ((g) gVar).b;
                long j2 = aVar.a;
                final File file4 = new File(fileD, b(j2));
                final File file5 = ((g) gVar).a;
                if (!file5.exists()) {
                    fileD.mkdirs();
                    if (!e(new f() { // from class: com.google.android.libraries.navigation.internal.fe.c
                        @Override // com.google.android.libraries.navigation.internal.fe.f
                        public final boolean a() {
                            return file4.createNewFile();
                        }
                    })) {
                        throw new b("Cannot create new crash marker file", file4.getName());
                    }
                } else if (!file4.getName().equals(file5.getName()) && !e(new f() { // from class: com.google.android.libraries.navigation.internal.fe.d
                    @Override // com.google.android.libraries.navigation.internal.fe.f
                    public final boolean a() {
                        int i3 = h.a;
                        return file5.renameTo(file4);
                    }
                })) {
                    throw new b("Cannot rename crash marker file", file4.getName());
                }
                this.e = an.j(new g(file4, new com.google.android.libraries.navigation.internal.fg.a(aVar.b, 0, j2)));
            } catch (RuntimeException e) {
                throw new b("Error while incrementing crash counter", e);
            }
        } catch (RuntimeException e2) {
            throw new b("Exception while resetting counter", e2);
        }
    }

    final String b(long j) {
        return String.format(Locale.getDefault(), "crashloop_%s_attempted_%d_count_%d", this.d, Long.valueOf(j), 0);
    }
}
