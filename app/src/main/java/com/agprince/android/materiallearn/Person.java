package com.agprince.android.materiallearn;

import android.os.Parcel;
import android.os.Parcelable;


public class Person  implements Parcelable{
    private String name;
    private int age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name); // 写入name
        dest.writeInt(age);  //写入年龄
    }
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            Person person = new Person();
            person.name=in.readString(); //读取名字
            person.age =in.readInt(); //读取年龄

            return person;
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

}
