package tech.zafrani.companionforpubg.models;


import android.support.annotation.NonNull;

import java.io.Serializable;

public class NewsItem implements Serializable{
    @NonNull
    private final String title;
    @NonNull
    private final String type;
    @NonNull
    private final String date;
    @NonNull
    private final String description;
    @NonNull
    private final String linkSrc;
    @NonNull
    private final String imgSrc;

    public NewsItem(@NonNull final String title,
                    @NonNull final String type,
                    @NonNull final String date,
                    @NonNull final String description,
                    @NonNull final String linkSrc,
                    @NonNull final String imgSrc) {
        this.title = title;
        this.type = type;
        this.date = date;
        this.description = description;
        this.linkSrc = linkSrc;
        this.imgSrc = imgSrc;
    }

    @NonNull
    public String getTitle() {
        return title;
    }
    @NonNull
    public String getType() {
        return type;
    }
    @NonNull
    public String getDate() {
        return date;
    }
    @NonNull
    public String getDescription() {
        return description;
    }
    @NonNull
    public String getLinkSrc() {
        return linkSrc;
    }
    @NonNull
    public String getImgSrc() {
        return imgSrc;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", linkSrc='" + linkSrc + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }
}
