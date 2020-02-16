package com.example.blogging.Model;

public class Post {
    String _id, user_id, status, image, name, category;

    public Post(String status,String image, String name, String category) {

        this.user_id = user_id;
        this.status = status;
        this.image = image;
        this.name = name;
        this.category = category;
    }

    public Post(String status, String category) {
        this.status = status;
        this.category = category;
    }

    public Post() {

    }

    public String get_id() {
        return _id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
