package edu.neu.csye7374.Models;

/**
 * Base class to represent a Player's profile
 * Implemented Builder design pattern to build the Player's profile
 */
public class UserProfile implements Cloneable{
    int id;
    String userName;
    String email;

    public UserProfile(int id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID='" + this.id + '\'' +
                ", UserName='" + this.userName + '\'' +
                ", Email='" + this.email + '\'';
    }

    public UserProfile clone() {
        try {
            return (UserProfile) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static class UserProfileBuilder {
        int id;
        String userName;
        String email;

        public UserProfileBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserProfileBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserProfileBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(id, userName, email);
        }
    }
}


