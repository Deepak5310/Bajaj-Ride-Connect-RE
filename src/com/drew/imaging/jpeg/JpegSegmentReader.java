package com.drew.imaging.jpeg;

import com.drew.lang.SequentialReader;
import com.drew.lang.StreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class JpegSegmentReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte MARKER_EOI = -39;
    private static final byte SEGMENT_IDENTIFIER = -1;
    private static final byte SEGMENT_SOS = -38;

    public static JpegSegmentData readSegments(File file, Iterable<JpegSegmentType> iterable) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                JpegSegmentData segments = readSegments(new StreamReader(fileInputStream2), iterable);
                fileInputStream2.close();
                return segments;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JpegSegmentData readSegments(SequentialReader sequentialReader, Iterable<JpegSegmentType> iterable) throws IOException, JpegProcessingException {
        HashSet hashSet;
        int uInt16 = sequentialReader.getUInt16();
        if (uInt16 != 65496) {
            throw new JpegProcessingException("JPEG data is expected to begin with 0xFFD8 (ÿØ) not 0x" + Integer.toHexString(uInt16));
        }
        if (iterable != null) {
            hashSet = new HashSet();
            Iterator<JpegSegmentType> it2 = iterable.iterator();
            while (it2.hasNext()) {
                hashSet.add(Byte.valueOf(it2.next().byteValue));
            }
        } else {
            hashSet = null;
        }
        HashSet hashSet2 = hashSet;
        JpegSegmentData jpegSegmentData = new JpegSegmentData();
        while (true) {
            byte int8 = sequentialReader.getInt8();
            byte int9 = sequentialReader.getInt8();
            while (true) {
                if (int8 == -1 && int9 != -1 && int9 != 0) {
                    break;
                }
                byte b = int9;
                int9 = sequentialReader.getInt8();
                int8 = b;
            }
            if (int9 == -38 || int9 == -39) {
                return jpegSegmentData;
            }
            int uInt17 = sequentialReader.getUInt16() - 2;
            if (uInt17 < 0) {
                throw new JpegProcessingException("JPEG segment size would be less than zero");
            }
            if (hashSet2 == null || hashSet2.contains(Byte.valueOf(int9))) {
                jpegSegmentData.addSegment(int9, sequentialReader.getBytes(uInt17));
            } else if (!sequentialReader.trySkip(uInt17)) {
                return jpegSegmentData;
            }
        }
    }

    private JpegSegmentReader() throws Exception {
        throw new Exception("Not intended for instantiation.");
    }
}
