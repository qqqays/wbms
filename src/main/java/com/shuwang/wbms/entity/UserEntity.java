package com.shuwang.wbms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-27-2017 17:33
 */
@TableName("users")
public class UserEntity extends Model<UserEntity>{

    @TableId(type = IdType.UUID)
    private String id;

    private String userName;

    private String password;

    private boolean state;

    private Timestamp createTime;

    private String desc;

    private String avadar;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAvadar() {
        return avadar;
    }

    public void setAvadar(String avadar) {
        this.avadar = avadar;
    }
}
