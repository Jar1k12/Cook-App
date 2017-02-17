package com.lvivdroiddev.cookapp.models;


public class FirstCourseModel {

    public String nameOfCourseStr;
    public String imageCourseStr;
    public String key;


    public FirstCourseModel() {

    }

    public String getKey() {
        return key;
    }


    public FirstCourseModel(String nameOfCourseStr, String imageCourseStr, String key, String receptOfCourseStr) {
        this.nameOfCourseStr = nameOfCourseStr;
        this.imageCourseStr = imageCourseStr;
        this.key = key;

    }


}
