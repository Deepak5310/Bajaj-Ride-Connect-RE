package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzlx;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AuthorAttributions implements Parcelable {
    public static AuthorAttributions newInstance(List<AuthorAttribution> list) {
        return new zzaq(zzlx.zzj(list));
    }

    public abstract List<AuthorAttribution> asList();
}
