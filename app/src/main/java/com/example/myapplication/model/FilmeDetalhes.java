package com.example.myapplication.model;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FilmeDetalhes {

    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("budget")
    private Long budget;
    @SerializedName("genres")
    private List<Genero> generos;
    @SerializedName("id")
    private Long id;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("poster_path")
    private Object posterPath;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("revenue")
    private Long revenue;
    @SerializedName("runtime")
    private Long runtime;
    @SerializedName("status")
    private String status;
    @SerializedName("title")
    private String title;
    @SerializedName("vote_average")
    private Double voteAverage;

   public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        backdropPath = backdropPath;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        budget = budget;
    }

    public List<Genero> getGenres() {
        return generos;
    }

    public void setGenres(List<Genero> genres) {
        generos = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

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

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Object getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(Object posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        releaseDate = releaseDate;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        revenue = revenue;
    }

    public Long getRuntime() {
        return runtime;
    }

    public void setRuntime(Long runtime) {
        runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        voteAverage = voteAverage;
    }
}
