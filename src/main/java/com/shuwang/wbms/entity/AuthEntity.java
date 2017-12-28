package com.shuwang.wbms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:21
 */
@TableName("authorities")
public class AuthEntity extends Model<AuthEntity> {

    @TableId
    private String authName;

    private String desc;

    private boolean state;

    @Override
    protected Serializable pkVal(){
        return this.authName;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
