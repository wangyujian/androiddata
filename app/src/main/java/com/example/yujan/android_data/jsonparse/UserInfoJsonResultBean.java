package com.example.yujan.android_data.jsonparse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yujan on 2020/4/10.
 */

public class UserInfoJsonResultBean implements Serializable {


    /**
     * name : androiddata
     * url : https://github.com/wangyujian
     * address : {"age":26,"country":"中国"}
     * links : [{"name":"GitHub","url":"https://github.com/wangyujian"},{"name":"CSDN","url":"https://blog.csdn.net/Yujan_2015"}]
     */

    private String name;
    private String url;
    private AddressBean address;
    private List<LinksBean> links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public List<LinksBean> getLinks() {
        return links;
    }

    public void setLinks(List<LinksBean> links) {
        this.links = links;
    }

    public static class AddressBean {
        /**
         * age : 26
         * country : 中国
         */

        private int age;
        private String country;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    public static class LinksBean {
        /**
         * name : GitHub
         * url : https://github.com/wangyujian
         */

        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
