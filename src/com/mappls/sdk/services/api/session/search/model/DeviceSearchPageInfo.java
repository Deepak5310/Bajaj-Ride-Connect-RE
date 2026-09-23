package com.mappls.sdk.services.api.session.search.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class DeviceSearchPageInfo {

    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;

    @SerializedName("itemCount")
    @Expose
    private Integer itemCount;

    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;

    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(Integer num) {
        this.totalPages = num;
    }

    public Integer getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(Integer num) {
        this.itemCount = num;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer num) {
        this.currentPage = num;
    }

    public Integer getTotalItems() {
        return this.totalItems;
    }

    public void setTotalItems(Integer num) {
        this.totalItems = num;
    }
}
