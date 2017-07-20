package com.liys.com.gen;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by liys
 * @time 2017-07-19.
 */
@Entity
public class User {
    @Id
    @Property(nameInDb = "STUNUM")
    private Long stuNum;
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "AGE")
    private String age;
    @Property(nameInDb = "is_stu")
    private boolean is_stu;
    @Generated(hash = 896627924)
    public User(Long stuNum, String name, String age, boolean is_stu) {
        this.stuNum = stuNum;
        this.name = name;
        this.age = age;
        this.is_stu = is_stu;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getStuNum() {
        return this.stuNum;
    }
    public void setStuNum(Long stuNum) {
        this.stuNum = stuNum;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public boolean getIs_stu() {
        return this.is_stu;
    }
    public void setIs_stu(boolean is_stu) {
        this.is_stu = is_stu;
    }
}
