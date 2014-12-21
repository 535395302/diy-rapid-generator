package com.model;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by tian on 14/12/21.
 */
@Resource
public class CitizenInfo implements Serializable{

    //private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer age;
    private Date birthDay;

    public CitizenInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
