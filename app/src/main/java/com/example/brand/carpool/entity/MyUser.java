package com.example.brand.carpool.entity;

import cn.bmob.v3.BmobUser;

/*
 @ project: CarPool
 @ package: com.example.brand.carpool.entity
 @ file: MyUser
 @ author : Jingliang Zhang (Brand)
 @ create time: 2018/8/29 3:06
 @ description: user's info
 */
public class MyUser extends BmobUser {
    private int age;
    private boolean sex;
    private String Desc;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
