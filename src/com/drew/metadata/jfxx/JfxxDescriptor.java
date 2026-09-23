package com.drew.metadata.jfxx;

import com.drew.metadata.TagDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class JfxxDescriptor extends TagDescriptor<JfxxDirectory> {
    public JfxxDescriptor(JfxxDirectory jfxxDirectory) {
        super(jfxxDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i == 5) {
            return getExtensionCodeDescription();
        }
        return super.getDescription(i);
    }

    public String getExtensionCodeDescription() {
        Integer integer = ((JfxxDirectory) this._directory).getInteger(5);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 16) {
            return "Thumbnail coded using JPEG";
        }
        if (iIntValue == 17) {
            return "Thumbnail stored using 1 byte/pixel";
        }
        if (iIntValue == 19) {
            return "Thumbnail stored using 3 bytes/pixel";
        }
        return "Unknown extension code " + integer;
    }
}
