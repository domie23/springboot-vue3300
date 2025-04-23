package com.entity.model;

import com.entity.XianshangbaoxiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 线上报修
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XianshangbaoxiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 维修人员
     */
    private Integer weixiurenyuanId;


    /**
     * 报修编号
     */
    private String xianshangbaoxiuUuidNumber;


    /**
     * 报修名称
     */
    private String xianshangbaoxiuName;


    /**
     * 报修类型
     */
    private Integer xianshangbaoxiuTypes;


    /**
     * 报修物品类型
     */
    private Integer xianshangbaoxiuWupinTypes;


    /**
     * 报修照片
     */
    private String xianshangbaoxiuPhoto;


    /**
     * 物品地址
     */
    private String wupinAddress;


    /**
     * 报修内容
     */
    private String baoxiuneirongContent;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报修进程
     */
    private Integer xianshangbaoxiuJinchengTypes;


    /**
     * 维修成果照片
     */
    private String xianshangbaoxiuChengguoPhoto;


    /**
     * 评价类型
     */
    private Integer xianshangbaoxiuPingjiaTypes;


    /**
     * 评价内容
     */
    private String pingjiaContent;


    /**
     * 评价时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date pingjiaTime;


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
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：维修人员
	 */
    public Integer getWeixiurenyuanId() {
        return weixiurenyuanId;
    }


    /**
	 * 设置：维修人员
	 */
    public void setWeixiurenyuanId(Integer weixiurenyuanId) {
        this.weixiurenyuanId = weixiurenyuanId;
    }
    /**
	 * 获取：报修编号
	 */
    public String getXianshangbaoxiuUuidNumber() {
        return xianshangbaoxiuUuidNumber;
    }


    /**
	 * 设置：报修编号
	 */
    public void setXianshangbaoxiuUuidNumber(String xianshangbaoxiuUuidNumber) {
        this.xianshangbaoxiuUuidNumber = xianshangbaoxiuUuidNumber;
    }
    /**
	 * 获取：报修名称
	 */
    public String getXianshangbaoxiuName() {
        return xianshangbaoxiuName;
    }


    /**
	 * 设置：报修名称
	 */
    public void setXianshangbaoxiuName(String xianshangbaoxiuName) {
        this.xianshangbaoxiuName = xianshangbaoxiuName;
    }
    /**
	 * 获取：报修类型
	 */
    public Integer getXianshangbaoxiuTypes() {
        return xianshangbaoxiuTypes;
    }


    /**
	 * 设置：报修类型
	 */
    public void setXianshangbaoxiuTypes(Integer xianshangbaoxiuTypes) {
        this.xianshangbaoxiuTypes = xianshangbaoxiuTypes;
    }
    /**
	 * 获取：报修物品类型
	 */
    public Integer getXianshangbaoxiuWupinTypes() {
        return xianshangbaoxiuWupinTypes;
    }


    /**
	 * 设置：报修物品类型
	 */
    public void setXianshangbaoxiuWupinTypes(Integer xianshangbaoxiuWupinTypes) {
        this.xianshangbaoxiuWupinTypes = xianshangbaoxiuWupinTypes;
    }
    /**
	 * 获取：报修照片
	 */
    public String getXianshangbaoxiuPhoto() {
        return xianshangbaoxiuPhoto;
    }


    /**
	 * 设置：报修照片
	 */
    public void setXianshangbaoxiuPhoto(String xianshangbaoxiuPhoto) {
        this.xianshangbaoxiuPhoto = xianshangbaoxiuPhoto;
    }
    /**
	 * 获取：物品地址
	 */
    public String getWupinAddress() {
        return wupinAddress;
    }


    /**
	 * 设置：物品地址
	 */
    public void setWupinAddress(String wupinAddress) {
        this.wupinAddress = wupinAddress;
    }
    /**
	 * 获取：报修内容
	 */
    public String getBaoxiuneirongContent() {
        return baoxiuneirongContent;
    }


    /**
	 * 设置：报修内容
	 */
    public void setBaoxiuneirongContent(String baoxiuneirongContent) {
        this.baoxiuneirongContent = baoxiuneirongContent;
    }
    /**
	 * 获取：报修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：报修时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报修进程
	 */
    public Integer getXianshangbaoxiuJinchengTypes() {
        return xianshangbaoxiuJinchengTypes;
    }


    /**
	 * 设置：报修进程
	 */
    public void setXianshangbaoxiuJinchengTypes(Integer xianshangbaoxiuJinchengTypes) {
        this.xianshangbaoxiuJinchengTypes = xianshangbaoxiuJinchengTypes;
    }
    /**
	 * 获取：维修成果照片
	 */
    public String getXianshangbaoxiuChengguoPhoto() {
        return xianshangbaoxiuChengguoPhoto;
    }


    /**
	 * 设置：维修成果照片
	 */
    public void setXianshangbaoxiuChengguoPhoto(String xianshangbaoxiuChengguoPhoto) {
        this.xianshangbaoxiuChengguoPhoto = xianshangbaoxiuChengguoPhoto;
    }
    /**
	 * 获取：评价类型
	 */
    public Integer getXianshangbaoxiuPingjiaTypes() {
        return xianshangbaoxiuPingjiaTypes;
    }


    /**
	 * 设置：评价类型
	 */
    public void setXianshangbaoxiuPingjiaTypes(Integer xianshangbaoxiuPingjiaTypes) {
        this.xianshangbaoxiuPingjiaTypes = xianshangbaoxiuPingjiaTypes;
    }
    /**
	 * 获取：评价内容
	 */
    public String getPingjiaContent() {
        return pingjiaContent;
    }


    /**
	 * 设置：评价内容
	 */
    public void setPingjiaContent(String pingjiaContent) {
        this.pingjiaContent = pingjiaContent;
    }
    /**
	 * 获取：评价时间
	 */
    public Date getPingjiaTime() {
        return pingjiaTime;
    }


    /**
	 * 设置：评价时间
	 */
    public void setPingjiaTime(Date pingjiaTime) {
        this.pingjiaTime = pingjiaTime;
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
