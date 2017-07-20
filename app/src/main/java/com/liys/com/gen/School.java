package com.liys.com.gen;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by liys
 * @time 2017-07-19.
 */
@Entity
public class School {
    @Id
    @Property(nameInDb = "ID")
    private Long id;
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "ADDRESS")
    private String address;
    @Generated(hash = 1364625397)
    public School(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    @Generated(hash = 1579966795)
    public School() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
