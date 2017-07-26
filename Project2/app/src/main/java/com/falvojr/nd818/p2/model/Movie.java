package com.falvojr.nd818.p2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Movie entity from TMDb API.
 * <p>
 * Created by falvojr on 6/4/17.
 */
public class Movie implements Parcelable {

    public enum Sort {
        POPULAR,
        TOP_RATED
    }

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("release_date")
    private Date releaseDate;

    @SerializedName("runtime")
    private Integer duration;

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.originalTitle);
        dest.writeString(this.overview);
        dest.writeString(this.posterPath);
        dest.writeValue(this.voteAverage);
        dest.writeLong(this.releaseDate != null ? this.releaseDate.getTime() : -1);
        dest.writeValue(this.duration);
    }

    public Movie() {
        super();
    }

    protected Movie(Parcel in) {
        this.originalTitle = in.readString();
        this.overview = in.readString();
        this.posterPath = in.readString();
        this.voteAverage = (Double) in.readValue(Double.class.getClassLoader());
        long tmpReleaseDate = in.readLong();
        this.releaseDate = tmpReleaseDate == -1 ? null : new Date(tmpReleaseDate);
        this.duration = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
