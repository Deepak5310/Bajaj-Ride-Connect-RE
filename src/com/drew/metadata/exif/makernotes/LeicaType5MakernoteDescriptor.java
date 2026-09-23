package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class LeicaType5MakernoteDescriptor extends TagDescriptor<LeicaType5MakernoteDirectory> {
    public LeicaType5MakernoteDescriptor(LeicaType5MakernoteDirectory leicaType5MakernoteDirectory) {
        super(leicaType5MakernoteDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i == 1037) {
            return getExposureModeDescription();
        }
        return super.getDescription(i);
    }

    public String getExposureModeDescription() {
        byte[] byteArray = ((LeicaType5MakernoteDirectory) this._directory).getByteArray(1037);
        if (byteArray == null || byteArray.length < 4) {
            return null;
        }
        String str = String.format("%d %d %d %d", Byte.valueOf(byteArray[0]), Byte.valueOf(byteArray[1]), Byte.valueOf(byteArray[2]), Byte.valueOf(byteArray[3]));
        if (str.equals("0 0 0 0")) {
            return "Program AE";
        }
        if (str.equals("1 0 0 0")) {
            return "Aperture-priority AE";
        }
        if (str.equals("1 1 0 0")) {
            return "Aperture-priority AE (1)";
        }
        if (str.equals("2 0 0 0")) {
            return "Shutter speed priority AE";
        }
        if (str.equals("3 0 0 0")) {
            return "Manual";
        }
        return String.format("Unknown (%s)", str);
    }
}
