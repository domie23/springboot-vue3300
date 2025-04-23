package com.entity.model;

import com.entity.WeixiurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 维修人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeixiurenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 工号
     */
    private String weixiurenyuanUuidNumber;


    /**
     * 维修人员姓名
     */
    private String weixiurenyuanName;


    /**
     * 维修人员手机号
     */
    private String weixiurenyuanPhone;


    /**
     * 维修人员身份证号
     */
    private String weixiurenyuanIdNumber;


    /**
     * 维修人员头像
     */
    private String weixiurenyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String weixiurenyuanEmail;


    /**
     * 擅长
     */
    private String weixiurenyuanShanchang;


    /**
     * 维修人员介绍
     */
    private String weixiurenyuanContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：工号
	 */
    public String getWeixiurenyuanUuidNumber() {
        return weixiurenyuanUuidNumber;
    }


    /**
	 * 设置：工号
	 */
    public void setWeixiurenyuanUuidNumber(String weixiurenyuanUuidNumber) {
        this.weixiurenyuanUuidNumber = weixiurenyuanUuidNumber;
    }
    /**
	 * 获取：维修人员姓名
	 */
    public String getWeixiurenyuanName() {
        return weixiurenyuanName;
    }


    /**
	 * 设置：维修人员姓名
	 */
    public void setWeixiurenyuanName(String weixiurenyuanName) {
        this.weixiurenyuanName = weixiurenyuanName;
    }
    /**
	 * 获取：维修人员手机号
	 */
    public String getWeixiurenyuanPhone() {
        return weixiurenyuanPhone;
    }


    /**
	 * 设置：维修人员手机号
	 */
    public void setWeixiurenyuanPhone(String weixiurenyuanPhone) {
        this.weixiurenyuanPhone = weixiurenyuanPhone;
    }
    /**
	 * 获取：维修人员身份证号
	 */
    public String getWeixiurenyuanIdNumber() {
        return weixiurenyuanIdNumber;
    }


    /**
	 * 设置：维修人员身份证号
	 */
    public void setWeixiurenyuanIdNumber(String weixiurenyuanIdNumber) {
        this.weixiurenyuanIdNumber = weixiurenyuanIdNumber;
    }
    /**
	 * 获取：维修人员头像
	 */
    public String getWeixiurenyuanPhoto() {
        return weixiurenyuanPhoto;
    }


    /**
	 * 设置：维修人员头像
	 */
    public void setWeixiurenyuanPhoto(String weixiurenyuanPhoto) {
        this.weixiurenyuanPhoto = weixiurenyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getWeixiurenyuanEmail() {
        return weixiurenyuanEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setWeixiurenyuanEmail(String weixiurenyuanEmail) {
        this.weixiurenyuanEmail = weixiurenyuanEmail;
    }
    /**
	 * 获取：擅长
	 */
    public String getWeixiurenyuanShanchang() {
        return weixiurenyuanShanchang;
    }


    /**
	 * 设置：擅长
	 */
    public void setWeixiurenyuanShanchang(String weixiurenyuanShanchang) {
        this.weixiurenyuanShanchang = weixiurenyuanShanchang;
    }
    /**
	 * 获取：维修人员介绍
	 */
    public String getWeixiurenyuanContent() {
        return weixiurenyuanContent;
    }


    /**
	 * 设置：维修人员介绍
	 */
    public void setWeixiurenyuanContent(String weixiurenyuanContent) {
        this.weixiurenyuanContent = weixiurenyuanContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
