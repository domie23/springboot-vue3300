<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='weixiurenyuan' && sessionTable !='xuesheng'">
                    <el-form-item class="select" v-if="type!='info'"  label="维修人员" prop="weixiurenyuanId">
                        <el-select v-model="ruleForm.weixiurenyuanId" :disabled="ro.weixiurenyuanId" filterable placeholder="请选择维修人员" @change="weixiurenyuanChange">
                            <el-option
                                    v-for="(item,index) in weixiurenyuanOptions"
                                    v-bind:key="item.id"
                                    :label="item.weixiurenyuanName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="!(sessionTable =='weixiurenyuan' && type!='info') && !(sessionTable =='xuesheng' && type!='info') ">
                    <el-form-item class="input" v-if="type!='info'"  label="工号" prop="weixiurenyuanUuidNumber">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanUuidNumber"
                                  placeholder="工号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="工号" prop="weixiurenyuanUuidNumber">
                            <el-input v-model="ruleForm.weixiurenyuanUuidNumber"
                                      placeholder="工号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="!(sessionTable =='weixiurenyuan' && type!='info') && !(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="维修人员姓名" prop="weixiurenyuanName">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanName"
                                  placeholder="维修人员姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="维修人员姓名" prop="weixiurenyuanName">
                            <el-input v-model="ruleForm.weixiurenyuanName"
                                      placeholder="维修人员姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="!(sessionTable =='weixiurenyuan' && type!='info') && !(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="维修人员手机号" prop="weixiurenyuanPhone">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanPhone"
                                  placeholder="维修人员手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="维修人员手机号" prop="weixiurenyuanPhone">
                            <el-input v-model="ruleForm.weixiurenyuanPhone"
                                      placeholder="维修人员手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="!(sessionTable =='weixiurenyuan' && type!='info') && !(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="维修人员身份证号" prop="weixiurenyuanIdNumber">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanIdNumber"
                                  placeholder="维修人员身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="维修人员身份证号" prop="weixiurenyuanIdNumber">
                            <el-input v-model="ruleForm.weixiurenyuanIdNumber"
                                      placeholder="维修人员身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="!(sessionTable =='weixiurenyuan' && type!='info') && !(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.weixiurenyuanPhoto" label="维修人员头像" prop="weixiurenyuanPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (weixiurenyuanForm.weixiurenyuanPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.weixiurenyuanPhoto" label="维修人员头像" prop="weixiurenyuanPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.weixiurenyuanPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="!(sessionTable =='weixiurenyuan' && type!='info') && !(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="weixiurenyuanEmail">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanEmail"
                                  placeholder="电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="电子邮箱" prop="weixiurenyuanEmail">
                            <el-input v-model="ruleForm.weixiurenyuanEmail"
                                      placeholder="电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="!(sessionTable =='weixiurenyuan' && type!='info') && !(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="擅长" prop="weixiurenyuanShanchang">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanShanchang"
                                  placeholder="擅长" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="擅长" prop="weixiurenyuanShanchang">
                            <el-input v-model="ruleForm.weixiurenyuanShanchang"
                                      placeholder="擅长" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng' && sessionTable !='weixiurenyuan'">
                    <el-form-item class="select" v-if="type!='info'"  label="学生" prop="xueshengId">
                        <el-select v-model="ruleForm.xueshengId" :disabled="ro.xueshengId" filterable placeholder="请选择学生" @change="xueshengChange">
                            <el-option
                                    v-for="(item,index) in xueshengOptions"
                                    v-bind:key="item.id"
                                    :label="item.xueshengName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="!(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="学号" prop="xueshengUuidNumber">
                        <el-input v-model="xueshengForm.xueshengUuidNumber"
                                  placeholder="学号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学号" prop="xueshengUuidNumber">
                            <el-input v-model="ruleForm.xueshengUuidNumber"
                                      placeholder="学号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="!(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生姓名" prop="xueshengName">
                        <el-input v-model="xueshengForm.xueshengName"
                                  placeholder="学生姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生姓名" prop="xueshengName">
                            <el-input v-model="ruleForm.xueshengName"
                                      placeholder="学生姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="!(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生手机号" prop="xueshengPhone">
                        <el-input v-model="xueshengForm.xueshengPhone"
                                  placeholder="学生手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生手机号" prop="xueshengPhone">
                            <el-input v-model="ruleForm.xueshengPhone"
                                      placeholder="学生手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="!(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生身份证号" prop="xueshengIdNumber">
                        <el-input v-model="xueshengForm.xueshengIdNumber"
                                  placeholder="学生身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生身份证号" prop="xueshengIdNumber">
                            <el-input v-model="ruleForm.xueshengIdNumber"
                                      placeholder="学生身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="!(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.xueshengPhoto" label="学生头像" prop="xueshengPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (xueshengForm.xueshengPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.xueshengPhoto" label="学生头像" prop="xueshengPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.xueshengPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="!(sessionTable =='xuesheng' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="xueshengEmail">
                        <el-input v-model="xueshengForm.xueshengEmail"
                                  placeholder="电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="电子邮箱" prop="xueshengEmail">
                            <el-input v-model="ruleForm.xueshengEmail"
                                      placeholder="电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="xueshengId" name="xueshengId" type="hidden">
            <input id="weixiurenyuanId" name="weixiurenyuanId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报修编号" prop="xianshangbaoxiuUuidNumber">
                       <el-input v-model="ruleForm.xianshangbaoxiuUuidNumber"
                                 placeholder="报修编号" clearable  :readonly="ro.xianshangbaoxiuUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="报修编号" prop="xianshangbaoxiuUuidNumber">
                           <el-input v-model="ruleForm.xianshangbaoxiuUuidNumber"
                                     placeholder="报修编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报修名称" prop="xianshangbaoxiuName">
                       <el-input v-model="ruleForm.xianshangbaoxiuName"
                                 placeholder="报修名称" clearable  :readonly="ro.xianshangbaoxiuName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="报修名称" prop="xianshangbaoxiuName">
                           <el-input v-model="ruleForm.xianshangbaoxiuName"
                                     placeholder="报修名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="报修类型" prop="xianshangbaoxiuTypes">
                        <el-select v-model="ruleForm.xianshangbaoxiuTypes" :disabled="ro.xianshangbaoxiuTypes" placeholder="请选择报修类型">
                            <el-option
                                v-for="(item,index) in xianshangbaoxiuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="报修类型" prop="xianshangbaoxiuValue">
                        <el-input v-model="ruleForm.xianshangbaoxiuValue"
                            placeholder="报修类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="报修物品类型" prop="xianshangbaoxiuWupinTypes">
                        <el-select v-model="ruleForm.xianshangbaoxiuWupinTypes" :disabled="ro.xianshangbaoxiuWupinTypes" placeholder="请选择报修物品类型">
                            <el-option
                                v-for="(item,index) in xianshangbaoxiuWupinTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="报修物品类型" prop="xianshangbaoxiuWupinValue">
                        <el-input v-model="ruleForm.xianshangbaoxiuWupinValue"
                            placeholder="报修物品类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.xianshangbaoxiuPhoto" label="报修照片" prop="xianshangbaoxiuPhoto">
                        <file-upload
                            tip="点击上传报修照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.xianshangbaoxiuPhoto?ruleForm.xianshangbaoxiuPhoto:''"
                            @change="xianshangbaoxiuPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.xianshangbaoxiuPhoto" label="报修照片" prop="xianshangbaoxiuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.xianshangbaoxiuPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="物品地址" prop="wupinAddress">
                       <el-input v-model="ruleForm.wupinAddress"
                                 placeholder="物品地址" clearable  :readonly="ro.wupinAddress"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="物品地址" prop="wupinAddress">
                           <el-input v-model="ruleForm.wupinAddress"
                                     placeholder="物品地址" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info' && sessionTable !='weixiurenyuan'"  label="报修内容" prop="baoxiuneirongContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.baoxiuneirongContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.baoxiuneirongContent" label="报修内容" prop="baoxiuneirongContent">
                            <span v-html="ruleForm.baoxiuneirongContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="!(sessionTable =='xuesheng' && type!='info') && !(sessionTable =='weixiurenyuan' && type!='info')  ">
                    <el-form-item class="select" v-if="type!='info'"  label="报修进程" prop="xianshangbaoxiuJinchengTypes">
                        <el-select v-model="ruleForm.xianshangbaoxiuJinchengTypes" :disabled="ro.xianshangbaoxiuJinchengTypes" placeholder="请选择报修进程">
                            <el-option
                                v-for="(item,index) in xianshangbaoxiuJinchengTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="报修进程" prop="xianshangbaoxiuJinchengValue">
                        <el-input v-model="ruleForm.xianshangbaoxiuJinchengValue"
                            placeholder="报修进程" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if=" !(sessionTable =='xuesheng' && type!='info') ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.xianshangbaoxiuChengguoPhoto" label="维修成果照片" prop="xianshangbaoxiuChengguoPhoto">
                        <file-upload
                            tip="点击上传维修成果照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.xianshangbaoxiuChengguoPhoto?ruleForm.xianshangbaoxiuChengguoPhoto:''"
                            @change="xianshangbaoxiuChengguoPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.xianshangbaoxiuChengguoPhoto" label="维修成果照片" prop="xianshangbaoxiuChengguoPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.xianshangbaoxiuChengguoPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="!(sessionTable =='xuesheng' && type!='info') &&!(sessionTable =='weixiurenyuan' && type!='info')  ">
                    <el-form-item class="select" v-if="type!='info'"  label="评价类型" prop="xianshangbaoxiuPingjiaTypes">
                        <el-select v-model="ruleForm.xianshangbaoxiuPingjiaTypes" :disabled="ro.xianshangbaoxiuPingjiaTypes" placeholder="请选择评价类型">
                            <el-option
                                v-for="(item,index) in xianshangbaoxiuPingjiaTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'" v-if="!(sessionTable =='xuesheng' && type!='info') &&!(sessionTable =='weixiurenyuan' && type!='info')  ">
                        <el-form-item class="input" label="评价类型" prop="xianshangbaoxiuPingjiaValue">
                        <el-input v-model="ruleForm.xianshangbaoxiuPingjiaValue"
                            placeholder="评价类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24" v-if="!(sessionTable =='xuesheng' && type!='info') &&!(sessionTable =='weixiurenyuan' && type!='info')  ">
                    <el-form-item v-if="type!='info'"  label="评价内容" prop="pingjiaContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.pingjiaContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.pingjiaContent" label="评价内容" prop="pingjiaContent">
                            <span v-html="ruleForm.pingjiaContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="!(sessionTable =='xuesheng' && type!='info') &&!(sessionTable =='weixiurenyuan' && type!='info')  ">
                    <el-form-item v-if="type!='info'"  class="input" label="评价时间" prop="pingjiaTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.pingjiaTime"
                                type="datetime"
                                placeholder="评价时间"
                                :disabled="ro.pingjiaTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.pingjiaTime" label="评价时间" prop="pingjiaTime">
                            <span v-html="ruleForm.pingjiaTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                weixiurenyuanForm: {},
                xueshengForm: {},
                ro:{
                    xueshengId: false,
                    weixiurenyuanId: false,
                    xianshangbaoxiuUuidNumber: false,
                    xianshangbaoxiuName: false,
                    xianshangbaoxiuTypes: false,
                    xianshangbaoxiuWupinTypes: false,
                    xianshangbaoxiuPhoto: false,
                    wupinAddress: false,
                    baoxiuneirongContent: false,
                    insertTime: false,
                    xianshangbaoxiuJinchengTypes: false,
                    xianshangbaoxiuChengguoPhoto: false,
                    xianshangbaoxiuPingjiaTypes: false,
                    pingjiaContent: false,
                    pingjiaTime: false,
                },
                ruleForm: {
                    xueshengId: '',
                    weixiurenyuanId: '',
                    xianshangbaoxiuUuidNumber: new Date().getTime(),
                    xianshangbaoxiuName: '',
                    xianshangbaoxiuTypes: '',
                    xianshangbaoxiuWupinTypes: '',
                    xianshangbaoxiuPhoto: '',
                    wupinAddress: '',
                    baoxiuneirongContent: '',
                    insertTime: '',
                    xianshangbaoxiuJinchengTypes: '',
                    xianshangbaoxiuChengguoPhoto: '',
                    xianshangbaoxiuPingjiaTypes: '',
                    pingjiaContent: '',
                    pingjiaTime: '',
                },
                xianshangbaoxiuTypesOptions : [],
                xianshangbaoxiuWupinTypesOptions : [],
                xianshangbaoxiuJinchengTypesOptions : [],
                xianshangbaoxiuPingjiaTypesOptions : [],
                weixiurenyuanOptions : [],
                xueshengOptions : [],
                rules: {
                   xueshengId: [
                              { required: true, message: '学生不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   weixiurenyuanId: [
                              { required: true, message: '维修人员不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xianshangbaoxiuUuidNumber: [
                              { required: true, message: '报修编号不能为空', trigger: 'blur' },
                          ],
                   xianshangbaoxiuName: [
                              { required: true, message: '报修名称不能为空', trigger: 'blur' },
                          ],
                   xianshangbaoxiuTypes: [
                              { required: true, message: '报修类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xianshangbaoxiuWupinTypes: [
                              { required: true, message: '报修物品类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xianshangbaoxiuPhoto: [
                              { required: true, message: '报修照片不能为空', trigger: 'blur' },
                          ],
                   wupinAddress: [
                              { required: true, message: '物品地址不能为空', trigger: 'blur' },
                          ],
                   baoxiuneirongContent: [
                              { required: true, message: '报修内容不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '报修时间不能为空', trigger: 'blur' },
                          ],
                   xianshangbaoxiuJinchengTypes: [
                              { required: true, message: '报修进程不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xianshangbaoxiuChengguoPhoto: [
                              { required: true, message: '维修成果照片不能为空', trigger: 'blur' },
                          ],
                   xianshangbaoxiuPingjiaTypes: [
                              { required: true, message: '评价类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   pingjiaContent: [
                              { required: true, message: '评价内容不能为空', trigger: 'blur' },
                          ],
                   pingjiaTime: [
                              { required: true, message: '评价时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role == "维修人员"){


                       this.ro.xianshangbaoxiuUuidNumber = true;
                       this.ro.xianshangbaoxiuName = true;
                       this.ro.xianshangbaoxiuTypes = true;
                       this.ro.xianshangbaoxiuWupinTypes = true;
                       this.ro.xianshangbaoxiuPhoto = true;
                       this.ro.wupinAddress = true;
                       this.ro.baoxiuneirongContent = true;
                       this.ro.insertTime = true;
                       this.ro.xianshangbaoxiuJinchengTypes = true;
                       this.ro.xianshangbaoxiuPingjiaTypes = true;
                       this.ro.pingjiaContent = true;
                       this.ro.pingjiaTime = true;
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xianshangbaoxiu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xianshangbaoxiuTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xianshangbaoxiu_wupin_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xianshangbaoxiuWupinTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xianshangbaoxiu_jincheng_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xianshangbaoxiuJinchengTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xianshangbaoxiu_pingjia_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xianshangbaoxiuPingjiaTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `weixiurenyuan/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.weixiurenyuanOptions = data.data.list;
            }
         });
         this.$http({
             url: `xuesheng/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.xueshengOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            weixiurenyuanChange(id){
                this.$http({
                    url: `weixiurenyuan/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.weixiurenyuanForm = data.data;
                    }
                });
            },
            xueshengChange(id){
                this.$http({
                    url: `xuesheng/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueshengForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `xianshangbaoxiu/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.weixiurenyuanChange(data.data.weixiurenyuanId)
                        _this.xueshengChange(data.data.xueshengId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`xianshangbaoxiu/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.xianshangbaoxiuCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.xianshangbaoxiuCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            xianshangbaoxiuPhotoUploadChange(fileUrls){
                this.ruleForm.xianshangbaoxiuPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },
            xianshangbaoxiuChengguoPhotoUploadChange(fileUrls){
                this.ruleForm.xianshangbaoxiuChengguoPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

