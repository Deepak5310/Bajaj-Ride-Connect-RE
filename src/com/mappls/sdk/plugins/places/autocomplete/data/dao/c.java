package com.mappls.sdk.plugins.places.autocomplete.data.dao;

import androidx.room.SharedSQLiteStatement;
import com.mappls.sdk.plugins.places.autocomplete.data.SearchHistoryDatabase;

/* JADX INFO: loaded from: classes4.dex */
final class c extends SharedSQLiteStatement {
    c(SearchHistoryDatabase searchHistoryDatabase) {
        super(searchHistoryDatabase);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM searchhistory";
    }
}
