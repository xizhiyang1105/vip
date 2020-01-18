package com.fh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@TableName("pro_vip")
public class Vip  {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String name;
    private String password;
    private String shouji;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date creaDate;
    @TableField(exist = false)
    private String code;
    @TableField(exist = false)
    private int falg;
    @TableField(exist = false)
    private String pwd;
    @TableField(exist = false)
    private String jwt;
    @TableField(exist = false)
    private String item;
    @TableField(exist = false)
    private long shuliang;
    private String userName;
    private String area;
    private Integer sex;
    private Integer zt;

    public long getShuliang() {
        return shuliang;
    }

    public void setShuliang(long shuliang) {
        this.shuliang = shuliang;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public int getFalg() {
        return falg;
    }

    public void setFalg(int falg) {
        this.falg = falg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShouji() {
        return shouji;
    }

    public void setShouji(String shouji) {
        this.shouji = shouji;
    }

    public Date getCreaDate() {
        return creaDate;
    }

    public void setCreaDate(Date creaDate) {
        this.creaDate = creaDate;
    }
}
