package com.bajajconnect.wifi.model;

/* JADX INFO: loaded from: classes3.dex */
public class SearchResultsTFTModel {
    private SearchResultModel searchResultModel;
    private FourDimensionalTouchPoint touchPoint;

    public SearchResultsTFTModel(FourDimensionalTouchPoint fourDimensionalTouchPoint, SearchResultModel searchResultModel) {
        this.touchPoint = fourDimensionalTouchPoint;
        this.searchResultModel = searchResultModel;
    }

    public SearchResultModel getSearchResultModel() {
        return this.searchResultModel;
    }

    public void setSearchResultModel(SearchResultModel searchResultModel) {
        this.searchResultModel = searchResultModel;
    }

    public FourDimensionalTouchPoint getTouchPoint() {
        return this.touchPoint;
    }

    public void setTouchPoint(FourDimensionalTouchPoint fourDimensionalTouchPoint) {
        this.touchPoint = fourDimensionalTouchPoint;
    }
}
