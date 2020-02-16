package com.example.blogging.Model;

public class CommentResponse {
    String _id, comment,image;
    Usermodel user_id;
    Post post_id;

    public CommentResponse(String _id, String comment, Usermodel user_id, Post post_id) {
        this._id = _id;
        this.comment = comment;
        this.user_id = user_id;
        this.image = image;
        this.post_id = post_id;
    }

    public String get_id() {
        return _id;
    }

    public String getComment() {
        return comment;
    }

    public Usermodel getUser_id() {
        return user_id;
    }

    public Post getPost_id() {
        return post_id;
    }

    public String getImage() {
        return image;
    }
}
