package com.mhelrigo.data.forecast.datasource.local.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class ConditionDatabaseEntity {
    private int conditionId;
    private int code;
    private String icon;
    private String text;
    private Type type;

    public ConditionDatabaseEntity() {
    }

    public ConditionDatabaseEntity(int code, String icon, String text, Type type) {
        this.code = code;
        this.icon = icon;
        this.text = text;
        this.type = type;
    }

    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        HOURLY,
        DAILY
    }
}
