package com.shuwang.wbms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @author Qays
 * @createTime 2017/11/23 9:53
 */

@TableName("simple_user")
public class SimpleUser extends Model<SimpleUser> {

    @TableId(type = IdType.UUID)
    private String id;

    private String name;

    private int age;

    public SimpleUser() {
    }

    public SimpleUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
    protected Serializable pkVal(){
        return this.id;
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
