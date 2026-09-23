package com.drew.metadata.jfif;

import androidx.core.view.MotionEventCompat;
import com.drew.metadata.TagDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class JfifDescriptor extends TagDescriptor<JfifDirectory> {
    public JfifDescriptor(JfifDirectory jfifDirectory) {
        super(jfifDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i == 5) {
            return getImageVersionDescription();
        }
        if (i == 10) {
            return getImageResYDescription();
        }
        if (i == 7) {
            return getImageResUnitsDescription();
        }
        if (i == 8) {
            return getImageResXDescription();
        }
        return super.getDescription(i);
    }

    public String getImageVersionDescription() {
        Integer integer = ((JfifDirectory) this._directory).getInteger(5);
        if (integer == null) {
            return null;
        }
        return String.format("%d.%d", Integer.valueOf((integer.intValue() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), Integer.valueOf(integer.intValue() & 255));
    }

    public String getImageResYDescription() {
        Integer integer = ((JfifDirectory) this._directory).getInteger(10);
        if (integer == null) {
            return null;
        }
        return String.format("%d dot%s", integer, integer.intValue() == 1 ? "" : "s");
    }

    public String getImageResXDescription() {
        Integer integer = ((JfifDirectory) this._directory).getInteger(8);
        if (integer == null) {
            return null;
        }
        return String.format("%d dot%s", integer, integer.intValue() == 1 ? "" : "s");
    }

    public String getImageResUnitsDescription() {
        Integer integer = ((JfifDirectory) this._directory).getInteger(7);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "none";
        }
        if (iIntValue == 1) {
            return "inch";
        }
        if (iIntValue == 2) {
            return "centimetre";
        }
        return "unit";
    }
}
