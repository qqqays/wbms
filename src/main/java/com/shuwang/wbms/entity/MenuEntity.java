package com.shuwang.wbms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Qays
 * @createTime 2017/11/25 16:38
 */

@TableName("menu")
public class MenuEntity extends Model<MenuEntity> {

    @TableId(type = IdType.UUID)
    private String id;

    private String menuName;

    private String pid;

    private String url;

    private String icon;

    private int sort;

    private int deep;

    private String code;

    private int display;

    private String resource;

    private boolean hasSub;

    private String bannerImg;

    private boolean active;

    private String contentType;

    @Override
    protected Serializable pkVal(){
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public boolean isHasSub() {
        return hasSub;
    }

    public void setHasSub(boolean hasSub) {
        this.hasSub = hasSub;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
