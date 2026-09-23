package com.spotify.android.appremote.api;

import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.ListItem;
import com.spotify.protocol.types.ListItems;

/* JADX INFO: loaded from: classes4.dex */
public interface ContentApi {

    public interface ContentType {
        public static final String AUTOMOTIVE = "automotive";
        public static final String DEFAULT = "default";
        public static final String FITNESS = "fitness";
        public static final String NAVIGATION = "navigation";
        public static final String SLEEP = "sleep";
        public static final String WAKE = "wake";
    }

    CallResult<ListItems> getChildrenOfItem(ListItem listItem, int i, int i2);

    CallResult<ListItems> getRecommendedContentItems(String str);

    CallResult<Empty> playContentItem(ListItem listItem);
}
