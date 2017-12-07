package com.example.android.qiscus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ifan on 12/7/2017.
 */

public class Products {

    public class Image {

        @SerializedName("full")
        @Expose
        private String full;
        @SerializedName("thumb")
        @Expose
        private String thumb;

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

    }

    public class Main {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("images")
        @Expose
        private List<Image> images = null;
        @SerializedName("reviews")
        @Expose
        private List<Review> reviews = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }

        public List<Review> getReviews() {
            return reviews;
        }

        public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
        }

    }

    public class Review {

        @SerializedName("stars")
        @Expose
        private Integer stars;
        @SerializedName("body")
        @Expose
        private String body;
        @SerializedName("author")
        @Expose
        private String author;

        public Integer getStars() {
            return stars;
        }

        public void setStars(Integer stars) {
            this.stars = stars;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

    }
}
