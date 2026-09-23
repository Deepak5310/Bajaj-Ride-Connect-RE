package com.mappls.sdk.maps.widgets.indoor;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class Floor {
    private String internalName;
    private String name;
    private Integer number;

    public Floor(Integer num, String str, String str2) {
        this.number = num;
        this.name = str;
        this.internalName = str2;
    }

    public static boolean areSameFloor(Floor floor, Integer num) {
        return (floor == null && num == null) || (floor != null && floor.getNumber().equals(num));
    }

    public static boolean areSameFloor(Integer num, Floor floor) {
        return (num == null && floor == null) || (floor != null && floor.getNumber().equals(num));
    }

    public Integer getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public String getInternalName() {
        return this.internalName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Floor.class != obj.getClass()) {
            return false;
        }
        Floor floor = (Floor) obj;
        return this.number.equals(floor.number) && this.name.equals(floor.name);
    }

    public int hashCode() {
        return Objects.hash(this.number, this.name);
    }
}
