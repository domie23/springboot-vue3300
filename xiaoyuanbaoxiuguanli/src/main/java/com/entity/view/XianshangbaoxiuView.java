package com.entity.view;

import com.entity.XianshangbaoxiuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 线上报修
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xianshangbaoxiu")
public class XianshangbaoxiuView extends XianshangbaoxiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 报修类型的值
		*/
		private String xianshangbaoxiuValue;
		/**
		* 报修物品类型的值
		*/
		private String xianshangbaoxiuWupinValue;
		/**
		* 报修进程的值
		*/
		private String xianshangbaoxiuJinchengValue;
		/**
		* 评价类型的值
		*/
		private String xianshangbaoxiuPingjiaValue;



		//级联表 weixiurenyuan
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

		//级联表 xuesheng
			/**
			* 学号
			*/
			private String xueshengUuidNumber;
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;

	public XianshangbaoxiuView() {

	}

	public XianshangbaoxiuView(XianshangbaoxiuEntity xianshangbaoxiuEntity) {
		try {
			BeanUtils.copyProperties(this, xianshangbaoxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 报修类型的值
			*/
			public String getXianshangbaoxiuValue() {
				return xianshangbaoxiuValue;
			}
			/**
			* 设置： 报修类型的值
			*/
			public void setXianshangbaoxiuValue(String xianshangbaoxiuValue) {
				this.xianshangbaoxiuValue = xianshangbaoxiuValue;
			}
			/**
			* 获取： 报修物品类型的值
			*/
			public String getXianshangbaoxiuWupinValue() {
				return xianshangbaoxiuWupinValue;
			}
			/**
			* 设置： 报修物品类型的值
			*/
			public void setXianshangbaoxiuWupinValue(String xianshangbaoxiuWupinValue) {
				this.xianshangbaoxiuWupinValue = xianshangbaoxiuWupinValue;
			}
			/**
			* 获取： 报修进程的值
			*/
			public String getXianshangbaoxiuJinchengValue() {
				return xianshangbaoxiuJinchengValue;
			}
			/**
			* 设置： 报修进程的值
			*/
			public void setXianshangbaoxiuJinchengValue(String xianshangbaoxiuJinchengValue) {
				this.xianshangbaoxiuJinchengValue = xianshangbaoxiuJinchengValue;
			}
			/**
			* 获取： 评价类型的值
			*/
			public String getXianshangbaoxiuPingjiaValue() {
				return xianshangbaoxiuPingjiaValue;
			}
			/**
			* 设置： 评价类型的值
			*/
			public void setXianshangbaoxiuPingjiaValue(String xianshangbaoxiuPingjiaValue) {
				this.xianshangbaoxiuPingjiaValue = xianshangbaoxiuPingjiaValue;
			}











				//级联表的get和set weixiurenyuan

					/**
					* 获取： 工号
					*/
					public String getWeixiurenyuanUuidNumber() {
						return weixiurenyuanUuidNumber;
					}
					/**
					* 设置： 工号
					*/
					public void setWeixiurenyuanUuidNumber(String weixiurenyuanUuidNumber) {
						this.weixiurenyuanUuidNumber = weixiurenyuanUuidNumber;
					}

					/**
					* 获取： 维修人员姓名
					*/
					public String getWeixiurenyuanName() {
						return weixiurenyuanName;
					}
					/**
					* 设置： 维修人员姓名
					*/
					public void setWeixiurenyuanName(String weixiurenyuanName) {
						this.weixiurenyuanName = weixiurenyuanName;
					}

					/**
					* 获取： 维修人员手机号
					*/
					public String getWeixiurenyuanPhone() {
						return weixiurenyuanPhone;
					}
					/**
					* 设置： 维修人员手机号
					*/
					public void setWeixiurenyuanPhone(String weixiurenyuanPhone) {
						this.weixiurenyuanPhone = weixiurenyuanPhone;
					}

					/**
					* 获取： 维修人员身份证号
					*/
					public String getWeixiurenyuanIdNumber() {
						return weixiurenyuanIdNumber;
					}
					/**
					* 设置： 维修人员身份证号
					*/
					public void setWeixiurenyuanIdNumber(String weixiurenyuanIdNumber) {
						this.weixiurenyuanIdNumber = weixiurenyuanIdNumber;
					}

					/**
					* 获取： 维修人员头像
					*/
					public String getWeixiurenyuanPhoto() {
						return weixiurenyuanPhoto;
					}
					/**
					* 设置： 维修人员头像
					*/
					public void setWeixiurenyuanPhoto(String weixiurenyuanPhoto) {
						this.weixiurenyuanPhoto = weixiurenyuanPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getWeixiurenyuanEmail() {
						return weixiurenyuanEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setWeixiurenyuanEmail(String weixiurenyuanEmail) {
						this.weixiurenyuanEmail = weixiurenyuanEmail;
					}

					/**
					* 获取： 擅长
					*/
					public String getWeixiurenyuanShanchang() {
						return weixiurenyuanShanchang;
					}
					/**
					* 设置： 擅长
					*/
					public void setWeixiurenyuanShanchang(String weixiurenyuanShanchang) {
						this.weixiurenyuanShanchang = weixiurenyuanShanchang;
					}

					/**
					* 获取： 维修人员介绍
					*/
					public String getWeixiurenyuanContent() {
						return weixiurenyuanContent;
					}
					/**
					* 设置： 维修人员介绍
					*/
					public void setWeixiurenyuanContent(String weixiurenyuanContent) {
						this.weixiurenyuanContent = weixiurenyuanContent;
					}





				//级联表的get和set xuesheng

					/**
					* 获取： 学号
					*/
					public String getXueshengUuidNumber() {
						return xueshengUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setXueshengUuidNumber(String xueshengUuidNumber) {
						this.xueshengUuidNumber = xueshengUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}




}
