package com.example.blogging.Model;

public class PostResponse {
    String _id, category,status,image;
    Usermodel user_id;

    public PostResponse(String _id, String category, String status, String image, Usermodel user_id) {
        this._id = _id;
        this.category = category;
        this.status = status;
        this.image = image;
        this.user_id = user_id;
    }

    public String get_id() {
        return _id;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public Usermodel getUser_id() {
        return user_id;
    }
}
