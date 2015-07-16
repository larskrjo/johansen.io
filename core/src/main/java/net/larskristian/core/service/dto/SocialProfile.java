package net.larskristian.core.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Lars K. Johansen
 */
public class SocialProfile {

    public static class Picture {

        public static class Data {

            private String url;

            @JsonProperty("is_silhouette")
            private boolean isSilhouette;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isSilhouette() {
                return isSilhouette;
            }

            public void setIsSilhouette(boolean isSilhouette) {
                this.isSilhouette = isSilhouette;
            }
        }

        private Data data;

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    private String email;

    private String firstName;

    private String lastName;

    private Picture picture;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

}
