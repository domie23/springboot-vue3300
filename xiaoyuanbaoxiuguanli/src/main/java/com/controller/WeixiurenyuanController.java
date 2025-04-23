
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 维修人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weixiurenyuan")
public class WeixiurenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(WeixiurenyuanController.class);

    @Autowired
    private WeixiurenyuanService weixiurenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private XueshengService xueshengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("维修人员".equals(role))
            params.put("weixiurenyuanId",request.getSession().getAttribute("userId"));
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = weixiurenyuanService.queryPage(params);

        //字典表数据转换
        List<WeixiurenyuanView> list =(List<WeixiurenyuanView>)page.getList();
        for(WeixiurenyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WeixiurenyuanEntity weixiurenyuan = weixiurenyuanService.selectById(id);
        if(weixiurenyuan !=null){
            //entity转view
            WeixiurenyuanView view = new WeixiurenyuanView();
            BeanUtils.copyProperties( weixiurenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiurenyuanEntity weixiurenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weixiurenyuan:{}",this.getClass().getName(),weixiurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WeixiurenyuanEntity> queryWrapper = new EntityWrapper<WeixiurenyuanEntity>()
            .eq("username", weixiurenyuan.getUsername())
            .or()
            .eq("weixiurenyuan_phone", weixiurenyuan.getWeixiurenyuanPhone())
            .or()
            .eq("weixiurenyuan_id_number", weixiurenyuan.getWeixiurenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiurenyuanEntity weixiurenyuanEntity = weixiurenyuanService.selectOne(queryWrapper);
        if(weixiurenyuanEntity==null){
            weixiurenyuan.setCreateTime(new Date());
            weixiurenyuan.setPassword("123456");
            weixiurenyuanService.insert(weixiurenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者维修人员手机号或者维修人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeixiurenyuanEntity weixiurenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,weixiurenyuan:{}",this.getClass().getName(),weixiurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<WeixiurenyuanEntity> queryWrapper = new EntityWrapper<WeixiurenyuanEntity>()
            .notIn("id",weixiurenyuan.getId())
            .andNew()
            .eq("username", weixiurenyuan.getUsername())
            .or()
            .eq("weixiurenyuan_phone", weixiurenyuan.getWeixiurenyuanPhone())
            .or()
            .eq("weixiurenyuan_id_number", weixiurenyuan.getWeixiurenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiurenyuanEntity weixiurenyuanEntity = weixiurenyuanService.selectOne(queryWrapper);
        if("".equals(weixiurenyuan.getWeixiurenyuanPhoto()) || "null".equals(weixiurenyuan.getWeixiurenyuanPhoto())){
                weixiurenyuan.setWeixiurenyuanPhoto(null);
        }
        if(weixiurenyuanEntity==null){
            weixiurenyuanService.updateById(weixiurenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者维修人员手机号或者维修人员身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        weixiurenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<WeixiurenyuanEntity> weixiurenyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WeixiurenyuanEntity weixiurenyuanEntity = new WeixiurenyuanEntity();
//                            weixiurenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //weixiurenyuanEntity.setPassword("123456");//密码
//                            weixiurenyuanEntity.setWeixiurenyuanUuidNumber(data.get(0));                    //工号 要改的
//                            weixiurenyuanEntity.setWeixiurenyuanName(data.get(0));                    //维修人员姓名 要改的
//                            weixiurenyuanEntity.setWeixiurenyuanPhone(data.get(0));                    //维修人员手机号 要改的
//                            weixiurenyuanEntity.setWeixiurenyuanIdNumber(data.get(0));                    //维修人员身份证号 要改的
//                            weixiurenyuanEntity.setWeixiurenyuanPhoto("");//详情和图片
//                            weixiurenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            weixiurenyuanEntity.setWeixiurenyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            weixiurenyuanEntity.setWeixiurenyuanShanchang(data.get(0));                    //擅长 要改的
//                            weixiurenyuanEntity.setWeixiurenyuanContent("");//详情和图片
//                            weixiurenyuanEntity.setCreateTime(date);//时间
                            weixiurenyuanList.add(weixiurenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //工号
                                if(seachFields.containsKey("weixiurenyuanUuidNumber")){
                                    List<String> weixiurenyuanUuidNumber = seachFields.get("weixiurenyuanUuidNumber");
                                    weixiurenyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weixiurenyuanUuidNumber = new ArrayList<>();
                                    weixiurenyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weixiurenyuanUuidNumber",weixiurenyuanUuidNumber);
                                }
                                //维修人员手机号
                                if(seachFields.containsKey("weixiurenyuanPhone")){
                                    List<String> weixiurenyuanPhone = seachFields.get("weixiurenyuanPhone");
                                    weixiurenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> weixiurenyuanPhone = new ArrayList<>();
                                    weixiurenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("weixiurenyuanPhone",weixiurenyuanPhone);
                                }
                                //维修人员身份证号
                                if(seachFields.containsKey("weixiurenyuanIdNumber")){
                                    List<String> weixiurenyuanIdNumber = seachFields.get("weixiurenyuanIdNumber");
                                    weixiurenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weixiurenyuanIdNumber = new ArrayList<>();
                                    weixiurenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("weixiurenyuanIdNumber",weixiurenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<WeixiurenyuanEntity> weixiurenyuanEntities_username = weixiurenyuanService.selectList(new EntityWrapper<WeixiurenyuanEntity>().in("username", seachFields.get("username")));
                        if(weixiurenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiurenyuanEntity s:weixiurenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //工号
                        List<WeixiurenyuanEntity> weixiurenyuanEntities_weixiurenyuanUuidNumber = weixiurenyuanService.selectList(new EntityWrapper<WeixiurenyuanEntity>().in("weixiurenyuan_uuid_number", seachFields.get("weixiurenyuanUuidNumber")));
                        if(weixiurenyuanEntities_weixiurenyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiurenyuanEntity s:weixiurenyuanEntities_weixiurenyuanUuidNumber){
                                repeatFields.add(s.getWeixiurenyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [工号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //维修人员手机号
                        List<WeixiurenyuanEntity> weixiurenyuanEntities_weixiurenyuanPhone = weixiurenyuanService.selectList(new EntityWrapper<WeixiurenyuanEntity>().in("weixiurenyuan_phone", seachFields.get("weixiurenyuanPhone")));
                        if(weixiurenyuanEntities_weixiurenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiurenyuanEntity s:weixiurenyuanEntities_weixiurenyuanPhone){
                                repeatFields.add(s.getWeixiurenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [维修人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //维修人员身份证号
                        List<WeixiurenyuanEntity> weixiurenyuanEntities_weixiurenyuanIdNumber = weixiurenyuanService.selectList(new EntityWrapper<WeixiurenyuanEntity>().in("weixiurenyuan_id_number", seachFields.get("weixiurenyuanIdNumber")));
                        if(weixiurenyuanEntities_weixiurenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiurenyuanEntity s:weixiurenyuanEntities_weixiurenyuanIdNumber){
                                repeatFields.add(s.getWeixiurenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [维修人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weixiurenyuanService.insertBatch(weixiurenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        WeixiurenyuanEntity weixiurenyuan = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("username", username));
        if(weixiurenyuan==null || !weixiurenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(weixiurenyuan.getId(),username, "weixiurenyuan", "维修人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","维修人员");
        r.put("username",weixiurenyuan.getWeixiurenyuanName());
        r.put("tableName","weixiurenyuan");
        r.put("userId",weixiurenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody WeixiurenyuanEntity weixiurenyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<WeixiurenyuanEntity> queryWrapper = new EntityWrapper<WeixiurenyuanEntity>()
            .eq("username", weixiurenyuan.getUsername())
            .or()
            .eq("weixiurenyuan_phone", weixiurenyuan.getWeixiurenyuanPhone())
            .or()
            .eq("weixiurenyuan_id_number", weixiurenyuan.getWeixiurenyuanIdNumber())
            ;
        WeixiurenyuanEntity weixiurenyuanEntity = weixiurenyuanService.selectOne(queryWrapper);
        if(weixiurenyuanEntity != null)
            return R.error("账户或者维修人员手机号或者维修人员身份证号已经被使用");
        weixiurenyuan.setCreateTime(new Date());
        weixiurenyuanService.insert(weixiurenyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        WeixiurenyuanEntity weixiurenyuan = new WeixiurenyuanEntity();
        weixiurenyuan.setPassword("123456");
        weixiurenyuan.setId(id);
        weixiurenyuanService.updateById(weixiurenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        WeixiurenyuanEntity weixiurenyuan = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("username", username));
        if(weixiurenyuan!=null){
            weixiurenyuan.setPassword("123456");
            boolean b = weixiurenyuanService.updateById(weixiurenyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrWeixiurenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        WeixiurenyuanEntity weixiurenyuan = weixiurenyuanService.selectById(id);
        if(weixiurenyuan !=null){
            //entity转view
            WeixiurenyuanView view = new WeixiurenyuanView();
            BeanUtils.copyProperties( weixiurenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
