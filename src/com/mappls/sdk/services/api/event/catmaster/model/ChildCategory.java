package com.mappls.sdk.services.api.event.catmaster.model;

import android.net.Uri;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ChildCategory {

    @SerializedName("desc")
    @Expose
    private Object desc;

    @SerializedName("expiry_in_hours")
    @Expose
    private double expiryInHours;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("iconBaseUrl")
    @Expose
    private String iconBaseUrl;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("subChildCategories")
    @Expose
    private List<ChildCategory> subChildCategories;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public Object getDesc() {
        return this.desc;
    }

    public void setDesc(Object obj) {
        this.desc = obj;
    }

    public double getExpiryInHours() {
        return this.expiryInHours;
    }

    public void setExpiryInHours(double d) {
        this.expiryInHours = d;
    }

    public List<ChildCategory> getSubChildCategories() {
        return this.subChildCategories;
    }

    public void setSubChildCategories(List<ChildCategory> list) {
        this.subChildCategories = list;
    }

    public String getCategoryIcon(String str) {
        String str2 = this.iconBaseUrl;
        if (str2 == null) {
            str2 = "";
        }
        return Uri.parse(str2).buildUpon().appendPath("0").appendPath(SystemMediaRouteProvider.PACKAGE_NAME).appendPath(str).appendPath("drawable-" + MapplsUtils.getDensityName()).appendPath(this.icon).build().toString();
    }

    public String getCategoryIcon(String str, int i) {
        String str2 = this.iconBaseUrl;
        if (str2 == null) {
            str2 = "";
        }
        return Uri.parse(str2).buildUpon().appendPath("" + i).appendPath(SystemMediaRouteProvider.PACKAGE_NAME).appendPath(str).appendPath("drawable-" + MapplsUtils.getDensityName()).appendPath(this.icon).build().toString();
    }
}
