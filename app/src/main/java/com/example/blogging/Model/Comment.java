package com.example.blogging.Model;

public class Comment {
    String _id,user_id, comment, post_id;




    public Comment(String _id, String user_id, String comment, String post_id) {
        this._id = _id;
        this.user_id = user_id;
        this.comment = comment;
        this.post_id = post_id;
    }

    public String get_id() {
        return _id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getComment() {
        return comment;
    }

    public String getPost_id() {
        return post_id;
    }
}
