package com.drew.metadata.iptc;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class IptcReader implements JpegSegmentMetadataReader {
    private static final byte IptcMarkerByte = 28;

    @Override // com.drew.imaging.jpeg.JpegSegmentMetadataReader
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.APPD);
    }

    @Override // com.drew.imaging.jpeg.JpegSegmentMetadataReader
    public void readJpegSegments(Iterable<byte[]> iterable, Metadata metadata, JpegSegmentType jpegSegmentType) {
        for (byte[] bArr : iterable) {
            if (bArr.length != 0 && bArr[0] == 28) {
                extract(new SequentialByteArrayReader(bArr), metadata, bArr.length);
            }
        }
    }

    public void extract(SequentialReader sequentialReader, Metadata metadata, long j) {
        extract(sequentialReader, metadata, j, null);
    }

    public void extract(SequentialReader sequentialReader, Metadata metadata, long j, Directory directory) {
        IptcDirectory iptcDirectory = new IptcDirectory();
        metadata.addDirectory(iptcDirectory);
        if (directory != null) {
            iptcDirectory.setParent(directory);
        }
        int i = 0;
        while (i < j) {
            try {
                short uInt8 = sequentialReader.getUInt8();
                int i2 = i + 1;
                if (uInt8 != 28) {
                    if (i2 != j) {
                        iptcDirectory.addError("Invalid IPTC tag marker at offset " + i + ". Expected '0x" + Integer.toHexString(28) + "' but got '0x" + Integer.toHexString(uInt8) + "'.");
                        return;
                    }
                    return;
                }
                if (i + 5 > j) {
                    iptcDirectory.addError("Too few bytes remain for a valid IPTC tag");
                    return;
                }
                try {
                    short uInt9 = sequentialReader.getUInt8();
                    short uInt10 = sequentialReader.getUInt8();
                    int uInt16 = sequentialReader.getUInt16();
                    if (uInt16 > 32767) {
                        uInt16 = ((uInt16 & 32767) << 16) | sequentialReader.getUInt16();
                        i2 = i + 3;
                    }
                    int i3 = uInt16;
                    i = i2 + 4 + i3;
                    if (i > j) {
                        iptcDirectory.addError("Data for tag extends beyond end of IPTC segment");
                        return;
                    } else {
                        try {
                            processTag(sequentialReader, iptcDirectory, uInt9, uInt10, i3);
                        } catch (IOException unused) {
                            iptcDirectory.addError("Error processing IPTC tag");
                            return;
                        }
                    }
                } catch (IOException unused2) {
                    iptcDirectory.addError("IPTC data segment ended mid-way through tag descriptor");
                    return;
                }
            } catch (IOException unused3) {
                iptcDirectory.addError("Unable to read starting byte of IPTC tag");
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0049  */
    /* JADX WARN: Code duplicated, block: B:29:0x004c  */
    private void processTag(SequentialReader sequentialReader, Directory directory, int i, int i2, int i3) throws IOException {
        Charset charsetForName;
        StringValue stringValue;
        StringValue[] stringValueArr;
        int i4 = (i << 8) | i2;
        if (i3 == 0) {
            directory.setString(i4, "");
            return;
        }
        if (i4 == 256 || i4 == 278) {
            if (i3 >= 2) {
                int uInt16 = sequentialReader.getUInt16();
                sequentialReader.skip(i3 - 2);
                directory.setInt(i4, uInt16);
                return;
            }
        } else {
            if (i4 == 346) {
                byte[] bytes = sequentialReader.getBytes(i3);
                String strConvertISO2022CharsetToJavaCharset = Iso2022Converter.convertISO2022CharsetToJavaCharset(bytes);
                if (strConvertISO2022CharsetToJavaCharset == null) {
                    strConvertISO2022CharsetToJavaCharset = new String(bytes);
                }
                directory.setString(i4, strConvertISO2022CharsetToJavaCharset);
                return;
            }
            if (i4 == 378 || i4 == 512) {
                if (i3 >= 2) {
                    int uInt17 = sequentialReader.getUInt16();
                    sequentialReader.skip(i3 - 2);
                    directory.setInt(i4, uInt17);
                    return;
                }
            } else if (i4 == 522) {
                directory.setInt(i4, sequentialReader.getUInt8());
                sequentialReader.skip(i3 - 1);
                return;
            } else if (i4 == 582) {
                if (i3 >= 2) {
                    int uInt18 = sequentialReader.getUInt16();
                    sequentialReader.skip(i3 - 2);
                    directory.setInt(i4, uInt18);
                    return;
                }
            }
        }
        String string = directory.getString(IptcDirectory.TAG_CODED_CHARACTER_SET);
        if (string != null) {
            try {
                charsetForName = Charset.forName(string);
            } catch (Throwable unused) {
                charsetForName = null;
            }
        } else {
            charsetForName = null;
        }
        if (string != null) {
            stringValue = sequentialReader.getStringValue(i3, charsetForName);
        } else {
            byte[] bytes2 = sequentialReader.getBytes(i3);
            Charset charsetGuessCharSet = Iso2022Converter.guessCharSet(bytes2);
            stringValue = charsetGuessCharSet != null ? new StringValue(bytes2, charsetGuessCharSet) : new StringValue(bytes2, null);
        }
        if (directory.containsTag(i4)) {
            StringValue[] stringValueArray = directory.getStringValueArray(i4);
            if (stringValueArray == null) {
                stringValueArr = new StringValue[1];
            } else {
                StringValue[] stringValueArr2 = new StringValue[stringValueArray.length + 1];
                System.arraycopy(stringValueArray, 0, stringValueArr2, 0, stringValueArray.length);
                stringValueArr = stringValueArr2;
            }
            stringValueArr[stringValueArr.length - 1] = stringValue;
            directory.setStringValueArray(i4, stringValueArr);
            return;
        }
        directory.setStringValue(i4, stringValue);
    }
}
