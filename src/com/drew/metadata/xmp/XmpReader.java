package com.drew.metadata.xmp;

import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPIterator;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.XMPMetaFactory;
import com.adobe.internal.xmp.impl.ByteBuffer;
import com.adobe.internal.xmp.options.ParseOptions;
import com.adobe.internal.xmp.properties.XMPPropertyInfo;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class XmpReader implements JpegSegmentMetadataReader {
    private static final String ATTRIBUTE_EXTENDED_XMP = "xmpNote:HasExtendedXMP";
    private static final int EXTENDED_XMP_GUID_LENGTH = 32;
    private static final int EXTENDED_XMP_INT_LENGTH = 4;
    private static final ParseOptions PARSE_OPTIONS = new ParseOptions().setXMPNodesToLimit(Collections.singletonMap("photoshop:DocumentAncestors", 1000));
    private static final String SCHEMA_XMP_NOTES = "http://ns.adobe.com/xmp/note/";
    private static final String XMP_EXTENSION_JPEG_PREAMBLE = "http://ns.adobe.com/xmp/extension/\u0000";
    private static final String XMP_JPEG_PREAMBLE = "http://ns.adobe.com/xap/1.0/\u0000";

    @Override // com.drew.imaging.jpeg.JpegSegmentMetadataReader
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.APP1);
    }

    @Override // com.drew.imaging.jpeg.JpegSegmentMetadataReader
    public void readJpegSegments(Iterable<byte[]> iterable, Metadata metadata, JpegSegmentType jpegSegmentType) {
        byte[] bArrProcessExtendedXMPChunk = null;
        String extendedXMPGUID = null;
        for (byte[] bArr : iterable) {
            if (bArr.length >= 29 && (XMP_JPEG_PREAMBLE.equalsIgnoreCase(new String(bArr, 0, 29)) || "XMP".equalsIgnoreCase(new String(bArr, 0, 3)))) {
                int length = bArr.length - 29;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 29, bArr2, 0, length);
                extract(bArr2, metadata);
                extendedXMPGUID = getExtendedXMPGUID(metadata);
            } else if (extendedXMPGUID != null && bArr.length >= 35 && XMP_EXTENSION_JPEG_PREAMBLE.equalsIgnoreCase(new String(bArr, 0, 35))) {
                bArrProcessExtendedXMPChunk = processExtendedXMPChunk(metadata, bArr, extendedXMPGUID, bArrProcessExtendedXMPChunk);
            }
        }
        if (bArrProcessExtendedXMPChunk != null) {
            extract(bArrProcessExtendedXMPChunk, metadata);
        }
    }

    public void extract(byte[] bArr, Metadata metadata) {
        extract(bArr, metadata, (Directory) null);
    }

    public void extract(byte[] bArr, Metadata metadata, Directory directory) {
        extract(bArr, 0, bArr.length, metadata, directory);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0016 A[Catch: XMPException -> 0x0029, TryCatch #0 {XMPException -> 0x0029, blocks: (B:6:0x000c, B:8:0x000f, B:10:0x0025, B:9:0x0016), top: B:18:0x000c }] */
    public void extract(byte[] bArr, int i, int i2, Metadata metadata, Directory directory) {
        XMPMeta fromBuffer;
        XmpDirectory xmpDirectory = new XmpDirectory();
        if (directory != null) {
            xmpDirectory.setParent(directory);
        }
        if (i == 0) {
            try {
                if (i2 == bArr.length) {
                    fromBuffer = XMPMetaFactory.parseFromBuffer(bArr, PARSE_OPTIONS);
                } else {
                    fromBuffer = XMPMetaFactory.parse(new ByteBuffer(bArr, i, i2).getByteStream(), PARSE_OPTIONS);
                }
                xmpDirectory.setXMPMeta(fromBuffer);
            } catch (XMPException e) {
                xmpDirectory.addError("Error processing XMP data: " + e.getMessage());
            }
        } else {
            fromBuffer = XMPMetaFactory.parse(new ByteBuffer(bArr, i, i2).getByteStream(), PARSE_OPTIONS);
            xmpDirectory.setXMPMeta(fromBuffer);
        }
        if (xmpDirectory.isEmpty()) {
            return;
        }
        metadata.addDirectory(xmpDirectory);
    }

    public void extract(String str, Metadata metadata) {
        extract(str, metadata, (Directory) null);
    }

    public void extract(StringValue stringValue, Metadata metadata) {
        extract(stringValue.getBytes(), metadata, (Directory) null);
    }

    public void extract(String str, Metadata metadata, Directory directory) {
        XmpDirectory xmpDirectory = new XmpDirectory();
        if (directory != null) {
            xmpDirectory.setParent(directory);
        }
        try {
            xmpDirectory.setXMPMeta(XMPMetaFactory.parseFromString(str, PARSE_OPTIONS));
        } catch (XMPException e) {
            xmpDirectory.addError("Error processing XMP data: " + e.getMessage());
        }
        if (xmpDirectory.isEmpty()) {
            return;
        }
        metadata.addDirectory(xmpDirectory);
    }

    private static String getExtendedXMPGUID(Metadata metadata) {
        Iterator it2 = metadata.getDirectoriesOfType(XmpDirectory.class).iterator();
        while (it2.hasNext()) {
            try {
                XMPIterator it3 = ((XmpDirectory) it2.next()).getXMPMeta().iterator("http://ns.adobe.com/xmp/note/", null, null);
                if (it3 != null) {
                    while (it3.hasNext()) {
                        XMPPropertyInfo xMPPropertyInfo = (XMPPropertyInfo) it3.next();
                        if (ATTRIBUTE_EXTENDED_XMP.equals(xMPPropertyInfo.getPath())) {
                            return xMPPropertyInfo.getValue();
                        }
                    }
                }
            } catch (XMPException unused) {
            }
        }
        return null;
    }

    private static byte[] processExtendedXMPChunk(Metadata metadata, byte[] bArr, String str, byte[] bArr2) {
        int length = bArr.length;
        if (length >= 75) {
            try {
                SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
                sequentialByteArrayReader.skip(35);
                if (str.equals(sequentialByteArrayReader.getString(32))) {
                    int uInt32 = (int) sequentialByteArrayReader.getUInt32();
                    int uInt33 = (int) sequentialByteArrayReader.getUInt32();
                    if (bArr2 == null) {
                        bArr2 = new byte[uInt32];
                    }
                    if (bArr2.length == uInt32) {
                        System.arraycopy(bArr, 75, bArr2, uInt33, length - 75);
                    } else {
                        XmpDirectory xmpDirectory = new XmpDirectory();
                        xmpDirectory.addError(String.format("Inconsistent length for the Extended XMP buffer: %d instead of %d", Integer.valueOf(uInt32), Integer.valueOf(bArr2.length)));
                        metadata.addDirectory(xmpDirectory);
                    }
                }
            } catch (IOException e) {
                XmpDirectory xmpDirectory2 = new XmpDirectory();
                xmpDirectory2.addError(e.getMessage());
                metadata.addDirectory(xmpDirectory2);
            }
        }
        return bArr2;
    }
}
