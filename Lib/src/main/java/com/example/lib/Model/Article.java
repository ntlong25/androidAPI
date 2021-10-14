package com.example.lib.Model;

import java.io.Serializable;

public class Article implements Serializable {
    private String message;
    private Data[] data;

    public String getMessage() {
        return message;
    }

    public Data[] getData() {
        return data;
    }

    public class Data implements Serializable {
        private String createdAt;

        private String groupName;

        private String imageUrl;

        private String __v;

        private String _id;

        private String title;

        private String content;

        private String updatedAt;

        public String getCreatedAt() {
            return createdAt;
        }

        public String getGroupName() {
            return groupName;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public String get__v() {
            return __v;
        }

        public String get_id() {
            return _id;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }
    }
}
