package com.example.myapplication;

public class Item {
    String name;
    String description;
    String age;
    String person_max;
    int image;

    public Item(String name, String description, String age, String person_max, int image) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.person_max = person_max;
        this.image = image;
    }


//    public item(int age, int person_max, int image) {
//        this.age = age;
//        this.person_max = person_max;
//        this.image = image;
//    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public String getPerson_max() {
        return person_max;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPerson_max(String person_max) {
        this.person_max = person_max;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
