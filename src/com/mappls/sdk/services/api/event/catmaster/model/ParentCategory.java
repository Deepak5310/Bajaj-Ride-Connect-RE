package com.mappls.sdk.services.api.event.catmaster.model;

import android.net.Uri;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ParentCategory {

    @SerializedName("childCategories")
    @Expose
    private List<ChildCategory> childCategories;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("iconBaseUrl")
    @Expose
    private String iconBaseUrl;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
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

    public List<ChildCategory> getChildCategories() {
        return this.childCategories;
    }

    public void setChildCategories(List<ChildCategory> list) {
        this.childCategories = list;
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
