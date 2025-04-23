package com.entity.vo;

import com.entity.WeixiurenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 维修人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weixiurenyuan")
public class WeixiurenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 工号
     */

    @TableField(value = "weixiurenyuan_uuid_number")
    private String weixiurenyuanUuidNumber;


    /**
     * 维修人员姓名
     */

    @TableField(value = "weixiurenyuan_name")
    private String weixiurenyuanName;


    /**
     * 维修人员手机号
     */

    @TableField(value = "weixiurenyuan_phone")
    private String weixiurenyuanPhone;


    /**
     * 维修人员身份证号
     */

    @TableField(value = "weixiurenyuan_id_number")
    private String weixiurenyuanIdNumber;


    /**
     * 维修人员头像
     */

    @TableField(value = "weixiurenyuan_photo")
    private String weixiurenyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "weixiurenyuan_email")
    private String weixiurenyuanEmail;


    /**
     * 擅长
     */

    @TableField(value = "weixiurenyuan_shanchang")
    private String weixiurenyuanShanchang;


    /**
     * 维修人员介绍
     */

    @TableField(value = "weixiurenyuan_content")
    private String weixiurenyuanContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：工号
	 */
    public String getWeixiurenyuanUuidNumber() {
        return weixiurenyuanUuidNumber;
    }


    /**
	 * 获取：工号
	 */

    public void setWeixiurenyuanUuidNumber(String weixiurenyuanUuidNumber) {
        this.weixiurenyuanUuidNumber = weixiurenyuanUuidNumber;
    }
    /**
	 * 设置：维修人员姓名
	 */
    public String getWeixiurenyuanName() {
        return weixiurenyuanName;
    }


    /**
	 * 获取：维修人员姓名
	 */

    public void setWeixiurenyuanName(String weixiurenyuanName) {
        this.weixiurenyuanName = weixiurenyuanName;
    }
    /**
	 * 设置：维修人员手机号
	 */
    public String getWeixiurenyuanPhone() {
        return weixiurenyuanPhone;
    }


    /**
	 * 获取：维修人员手机号
	 */

    public void setWeixiurenyuanPhone(String weixiurenyuanPhone) {
        this.weixiurenyuanPhone = weixiurenyuanPhone;
    }
    /**
	 * 设置：维修人员身份证号
	 */
    public String getWeixiurenyuanIdNumber() {
        return weixiurenyuanIdNumber;
    }


    /**
	 * 获取：维修人员身份证号
	 */

    public void setWeixiurenyuanIdNumber(String weixiurenyuanIdNumber) {
        this.weixiurenyuanIdNumber = weixiurenyuanIdNumber;
    }
    /**
	 * 设置：维修人员头像
	 */
    public String getWeixiurenyuanPhoto() {
        return weixiurenyuanPhoto;
    }


    /**
	 * 获取：维修人员头像
	 */

    public void setWeixiurenyuanPhoto(String weixiurenyuanPhoto) {
        this.weixiurenyuanPhoto = weixiurenyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getWeixiurenyuanEmail() {
        return weixiurenyuanEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setWeixiurenyuanEmail(String weixiurenyuanEmail) {
        this.weixiurenyuanEmail = weixiurenyuanEmail;
    }
    /**
	 * 设置：擅长
	 */
    public String getWeixiurenyuanShanchang() {
        return weixiurenyuanShanchang;
    }


    /**
	 * 获取：擅长
	 */

    public void setWeixiurenyuanShanchang(String weixiurenyuanShanchang) {
        this.weixiurenyuanShanchang = weixiurenyuanShanchang;
    }
    /**
	 * 设置：维修人员介绍
	 */
    public String getWeixiurenyuanContent() {
        return weixiurenyuanContent;
    }


    /**
	 * 获取：维修人员介绍
	 */

    public void setWeixiurenyuanContent(String weixiurenyuanContent) {
        this.weixiurenyuanContent = weixiurenyuanContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
