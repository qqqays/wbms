package com.shuwang.wbms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.apache.tools.ant.types.selectors.TypeSelector;
import org.hibernate.validator.internal.xml.binding.FieldType;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-27-2017 17:38
 */
@TableName("roles")
public class RoleEntity extends Model<RoleEntity> {

    @TableId(type = IdType.UUID)
    private String id;

    private String roleName;

    private String desc;

    private boolean state;

    private Timestamp createTime;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
