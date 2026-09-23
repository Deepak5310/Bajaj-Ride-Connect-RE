package com.google.android.libraries.navigation.internal.sk;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bm implements Closeable {
    public final Map a = new TreeMap();
    public final String b;
    public final ZipFile c;

    public bm(String str, ZipFile zipFile, InputStream inputStream) throws IOException {
        this.b = str;
        this.c = zipFile;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try {
            b(inputStreamReader);
            inputStreamReader.close();
        } catch (Throwable th) {
            try {
                inputStreamReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0091  */
    public static bm a(File file) throws Throwable {
        InputStream fileInputStream;
        ZipFile zipFile;
        File parentFile = file.getParentFile();
        InputStream inputStream = null;
        ZipFile zipFile2 = null;
        try {
            try {
                if (file.getName().endsWith(".zip")) {
                    zipFile = new ZipFile(file, 1);
                    try {
                        ZipEntry entry = zipFile.getEntry("messages.xml");
                        if (entry == null) {
                            throw new IOException("Canned message bundle did not contain index file: " + file.getName());
                        }
                        fileInputStream = zipFile.getInputStream(entry);
                    } catch (IOException e) {
                        e = e;
                        zipFile2 = zipFile;
                        if (zipFile2 != null) {
                            try {
                                try {
                                    zipFile2.close();
                                } catch (IOException unused) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1430)).p("Failed to close bundle zip file.");
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream = null;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        }
                        throw e;
                    }
                } else {
                    fileInputStream = new FileInputStream(file);
                    zipFile = null;
                }
                InputStream inputStream2 = fileInputStream;
                if (inputStream2 != null) {
                    bm bmVar = new bm(parentFile != null ? parentFile.getPath() : "", zipFile, inputStream2);
                    inputStream2.close();
                    return bmVar;
                }
                throw new IOException("Error getting input steam for bundle: " + file.getName());
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0040  */
    private final void b(Reader reader) throws IOException {
        byte b;
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(false);
            XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            xmlPullParserNewPullParser.setInput(reader);
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType == 2) {
                    String name = xmlPullParserNewPullParser.getName();
                    int iHashCode = name.hashCode();
                    if (iHashCode != -1512558702) {
                        if (iHashCode == 305394053 && name.equals("canned_message")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (name.equals("voice_instructions")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "id");
                        if (attributeValue == null) {
                            throw new IOException("Canned message entry did not contain an id value.");
                        }
                        Integer numDecode = Integer.decode(attributeValue);
                        int iIntValue = numDecode.intValue();
                        String strNextText = xmlPullParserNewPullParser.nextText();
                        if (this.a.containsKey(numDecode)) {
                            throw new IOException(com.google.android.libraries.navigation.internal.b.b.b(iIntValue, "Duplicated canned message: "));
                        }
                        if (!com.google.android.libraries.navigation.internal.yx.aq.c(strNextText)) {
                            this.a.put(numDecode, strNextText);
                        }
                    } else if (b != 1) {
                        int depth = xmlPullParserNewPullParser.getDepth();
                        while (true) {
                            int next = xmlPullParserNewPullParser.next();
                            if (next == 1 || (next == 3 && xmlPullParserNewPullParser.getDepth() == depth)) {
                                break;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException | XmlPullParserException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1434)).p("Unable to parse messages.xml");
            throw new IOException(e.getMessage());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ZipFile zipFile = this.c;
        if (zipFile == null) {
            return;
        }
        zipFile.close();
    }
}
