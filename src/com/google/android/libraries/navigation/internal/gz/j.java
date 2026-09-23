package com.google.android.libraries.navigation.internal.gz;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public static int a(DataInput dataInput) throws IOException {
        int unsignedByte = dataInput.readUnsignedByte();
        if (unsignedByte < 128) {
            return unsignedByte;
        }
        int unsignedByte2 = dataInput.readUnsignedByte();
        int i = (unsignedByte & 127) | ((unsignedByte2 & 127) << 7);
        if (unsignedByte2 < 128) {
            return i;
        }
        int unsignedByte3 = dataInput.readUnsignedByte();
        int i2 = i | ((unsignedByte3 & 127) << 14);
        if (unsignedByte3 < 128) {
            return i2;
        }
        int unsignedByte4 = dataInput.readUnsignedByte();
        int i3 = i2 | ((unsignedByte4 & 127) << 21);
        if (unsignedByte4 < 128) {
            return i3;
        }
        int unsignedByte5 = dataInput.readUnsignedByte();
        int i4 = i3 | ((unsignedByte5 & 127) << 28);
        if (unsignedByte5 >= 128) {
            while (unsignedByte5 >= 128) {
                unsignedByte5 = dataInput.readUnsignedByte();
            }
        }
        return i4;
    }
}
