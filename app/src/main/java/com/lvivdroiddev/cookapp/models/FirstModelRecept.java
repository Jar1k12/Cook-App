package com.lvivdroiddev.cookapp.models;


public class FirstModelRecept extends FirstCourseModel {


    public String receptOfCourseStr;

    public String getReceptOfCourse() {
        return receptOfCourseStr;
    }


    public FirstModelRecept(String nameOfCourseStr, String imageCourseStr, String key, String receptOfCourseStr) {
        super(nameOfCourseStr, imageCourseStr, key, receptOfCourseStr);
        this.receptOfCourseStr = receptOfCourseStr;
    }


    public FirstModelRecept() {

    }
}