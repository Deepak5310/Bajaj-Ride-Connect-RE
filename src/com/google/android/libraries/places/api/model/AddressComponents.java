package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AddressComponents implements Parcelable {
    public static AddressComponents newInstance(List<AddressComponent> list) {
        return new zzam(list);
    }

    public abstract List<AddressComponent> asList();
}
