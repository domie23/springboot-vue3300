package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 线上报修
 *
 * @author 
 * @email
 */
@TableName("xianshangbaoxiu")
public class XianshangbaoxiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XianshangbaoxiuEntity() {

	}

	public XianshangbaoxiuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 维修人员
     */
    @TableField(value = "weixiurenyuan_id")

    private Integer weixiurenyuanId;


    /**
     * 报修编号
     */
    @TableField(value = "xianshangbaoxiu_uuid_number")

    private String xianshangbaoxiuUuidNumber;


    /**
     * 报修名称
     */
    @TableField(value = "xianshangbaoxiu_name")

    private String xianshangbaoxiuName;


    /**
     * 报修类型
     */
    @TableField(value = "xianshangbaoxiu_types")

    private Integer xianshangbaoxiuTypes;


    /**
     * 报修物品类型
     */
    @TableField(value = "xianshangbaoxiu_wupin_types")

    private Integer xianshangbaoxiuWupinTypes;


    /**
     * 报修照片
     */
    @TableField(value = "xianshangbaoxiu_photo")

    private String xianshangbaoxiuPhoto;


    /**
     * 物品地址
     */
    @TableField(value = "wupin_address")

    private String wupinAddress;


    /**
     * 报修内容
     */
    @TableField(value = "baoxiuneirong_content")

    private String baoxiuneirongContent;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报修进程
     */
    @TableField(value = "xianshangbaoxiu_jincheng_types")

    private Integer xianshangbaoxiuJinchengTypes;


    /**
     * 维修成果照片
     */
    @TableField(value = "xianshangbaoxiu_chengguo_photo")

    private String xianshangbaoxiuChengguoPhoto;


    /**
     * 评价类型
     */
    @TableField(value = "xianshangbaoxiu_pingjia_types")

    private Integer xianshangbaoxiuPingjiaTypes;


    /**
     * 评价内容
     */
    @TableField(value = "pingjia_content")

    private String pingjiaContent;


    /**
     * 评价时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "pingjia_time")

    private Date pingjiaTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：维修人员
	 */
    public Integer getWeixiurenyuanId() {
        return weixiurenyuanId;
    }
    /**
	 * 获取：维修人员
	 */

    public void setWeixiurenyuanId(Integer weixiurenyuanId) {
        this.weixiurenyuanId = weixiurenyuanId;
    }
    /**
	 * 设置：报修编号
	 */
    public String getXianshangbaoxiuUuidNumber() {
        return xianshangbaoxiuUuidNumber;
    }
    /**
	 * 获取：报修编号
	 */

    public void setXianshangbaoxiuUuidNumber(String xianshangbaoxiuUuidNumber) {
        this.xianshangbaoxiuUuidNumber = xianshangbaoxiuUuidNumber;
    }
    /**
	 * 设置：报修名称
	 */
    public String getXianshangbaoxiuName() {
        return xianshangbaoxiuName;
    }
    /**
	 * 获取：报修名称
	 */

    public void setXianshangbaoxiuName(String xianshangbaoxiuName) {
        this.xianshangbaoxiuName = xianshangbaoxiuName;
    }
    /**
	 * 设置：报修类型
	 */
    public Integer getXianshangbaoxiuTypes() {
        return xianshangbaoxiuTypes;
    }
    /**
	 * 获取：报修类型
	 */

    public void setXianshangbaoxiuTypes(Integer xianshangbaoxiuTypes) {
        this.xianshangbaoxiuTypes = xianshangbaoxiuTypes;
    }
    /**
	 * 设置：报修物品类型
	 */
    public Integer getXianshangbaoxiuWupinTypes() {
        return xianshangbaoxiuWupinTypes;
    }
    /**
	 * 获取：报修物品类型
	 */

    public void setXianshangbaoxiuWupinTypes(Integer xianshangbaoxiuWupinTypes) {
        this.xianshangbaoxiuWupinTypes = xianshangbaoxiuWupinTypes;
    }
    /**
	 * 设置：报修照片
	 */
    public String getXianshangbaoxiuPhoto() {
        return xianshangbaoxiuPhoto;
    }
    /**
	 * 获取：报修照片
	 */

    public void setXianshangbaoxiuPhoto(String xianshangbaoxiuPhoto) {
        this.xianshangbaoxiuPhoto = xianshangbaoxiuPhoto;
    }
    /**
	 * 设置：物品地址
	 */
    public String getWupinAddress() {
        return wupinAddress;
    }
    /**
	 * 获取：物品地址
	 */

    public void setWupinAddress(String wupinAddress) {
        this.wupinAddress = wupinAddress;
    }
    /**
	 * 设置：报修内容
	 */
    public String getBaoxiuneirongContent() {
        return baoxiuneirongContent;
    }
    /**
	 * 获取：报修内容
	 */

    public void setBaoxiuneirongContent(String baoxiuneirongContent) {
        this.baoxiuneirongContent = baoxiuneirongContent;
    }
    /**
	 * 设置：报修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：报修时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报修进程
	 */
    public Integer getXianshangbaoxiuJinchengTypes() {
        return xianshangbaoxiuJinchengTypes;
    }
    /**
	 * 获取：报修进程
	 */

    public void setXianshangbaoxiuJinchengTypes(Integer xianshangbaoxiuJinchengTypes) {
        this.xianshangbaoxiuJinchengTypes = xianshangbaoxiuJinchengTypes;
    }
    /**
	 * 设置：维修成果照片
	 */
    public String getXianshangbaoxiuChengguoPhoto() {
        return xianshangbaoxiuChengguoPhoto;
    }
    /**
	 * 获取：维修成果照片
	 */

    public void setXianshangbaoxiuChengguoPhoto(String xianshangbaoxiuChengguoPhoto) {
        this.xianshangbaoxiuChengguoPhoto = xianshangbaoxiuChengguoPhoto;
    }
    /**
	 * 设置：评价类型
	 */
    public Integer getXianshangbaoxiuPingjiaTypes() {
        return xianshangbaoxiuPingjiaTypes;
    }
    /**
	 * 获取：评价类型
	 */

    public void setXianshangbaoxiuPingjiaTypes(Integer xianshangbaoxiuPingjiaTypes) {
        this.xianshangbaoxiuPingjiaTypes = xianshangbaoxiuPingjiaTypes;
    }
    /**
	 * 设置：评价内容
	 */
    public String getPingjiaContent() {
        return pingjiaContent;
    }
    /**
	 * 获取：评价内容
	 */

    public void setPingjiaContent(String pingjiaContent) {
        this.pingjiaContent = pingjiaContent;
    }
    /**
	 * 设置：评价时间
	 */
    public Date getPingjiaTime() {
        return pingjiaTime;
    }
    /**
	 * 获取：评价时间
	 */

    public void setPingjiaTime(Date pingjiaTime) {
        this.pingjiaTime = pingjiaTime;
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

    @Override
    public String toString() {
        return "Xianshangbaoxiu{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", weixiurenyuanId=" + weixiurenyuanId +
            ", xianshangbaoxiuUuidNumber=" + xianshangbaoxiuUuidNumber +
            ", xianshangbaoxiuName=" + xianshangbaoxiuName +
            ", xianshangbaoxiuTypes=" + xianshangbaoxiuTypes +
            ", xianshangbaoxiuWupinTypes=" + xianshangbaoxiuWupinTypes +
            ", xianshangbaoxiuPhoto=" + xianshangbaoxiuPhoto +
            ", wupinAddress=" + wupinAddress +
            ", baoxiuneirongContent=" + baoxiuneirongContent +
            ", insertTime=" + insertTime +
            ", xianshangbaoxiuJinchengTypes=" + xianshangbaoxiuJinchengTypes +
            ", xianshangbaoxiuChengguoPhoto=" + xianshangbaoxiuChengguoPhoto +
            ", xianshangbaoxiuPingjiaTypes=" + xianshangbaoxiuPingjiaTypes +
            ", pingjiaContent=" + pingjiaContent +
            ", pingjiaTime=" + pingjiaTime +
            ", createTime=" + createTime +
        "}";
    }
}
