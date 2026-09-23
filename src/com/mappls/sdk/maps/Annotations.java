package com.mappls.sdk.maps;

import com.mappls.sdk.maps.annotations.Annotation;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
interface Annotations {
    List<Annotation> obtainAll();

    Annotation obtainBy(long j);

    void removeAll();

    void removeBy(long j);

    void removeBy(Annotation annotation);

    void removeBy(List<? extends Annotation> list);
}
