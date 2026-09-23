package com.drew.metadata.pcx;

import com.drew.imaging.ImageProcessingException;
import com.drew.lang.SequentialReader;
import com.drew.metadata.Metadata;

/* JADX INFO: loaded from: classes3.dex */
public class PcxReader {
    public void extract(SequentialReader sequentialReader, Metadata metadata) {
        sequentialReader.setMotorolaByteOrder(false);
        PcxDirectory pcxDirectory = new PcxDirectory();
        metadata.addDirectory(pcxDirectory);
        try {
            if (sequentialReader.getInt8() != 10) {
                throw new ImageProcessingException("Invalid PCX identifier byte");
            }
            pcxDirectory.setInt(1, sequentialReader.getInt8());
            if (sequentialReader.getInt8() != 1) {
                throw new ImageProcessingException("Invalid PCX encoding byte");
            }
            pcxDirectory.setInt(2, sequentialReader.getUInt8());
            pcxDirectory.setInt(3, sequentialReader.getUInt16());
            pcxDirectory.setInt(4, sequentialReader.getUInt16());
            pcxDirectory.setInt(5, sequentialReader.getUInt16());
            pcxDirectory.setInt(6, sequentialReader.getUInt16());
            pcxDirectory.setInt(7, sequentialReader.getUInt16());
            pcxDirectory.setInt(8, sequentialReader.getUInt16());
            pcxDirectory.setByteArray(9, sequentialReader.getBytes(48));
            sequentialReader.skip(1L);
            pcxDirectory.setInt(10, sequentialReader.getUInt8());
            pcxDirectory.setInt(11, sequentialReader.getUInt16());
            int uInt16 = sequentialReader.getUInt16();
            if (uInt16 != 0) {
                pcxDirectory.setInt(12, uInt16);
            }
            int uInt17 = sequentialReader.getUInt16();
            if (uInt17 != 0) {
                pcxDirectory.setInt(13, uInt17);
            }
            int uInt18 = sequentialReader.getUInt16();
            if (uInt18 != 0) {
                pcxDirectory.setInt(14, uInt18);
            }
        } catch (Exception e) {
            pcxDirectory.addError("Exception reading PCX file metadata: " + e.getMessage());
        }
    }
}
