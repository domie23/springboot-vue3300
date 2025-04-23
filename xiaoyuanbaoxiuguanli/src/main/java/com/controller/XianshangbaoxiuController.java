
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
 * 线上报修
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xianshangbaoxiu")
public class XianshangbaoxiuController {
    private static final Logger logger = LoggerFactory.getLogger(XianshangbaoxiuController.class);

    @Autowired
    private XianshangbaoxiuService xianshangbaoxiuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private WeixiurenyuanService weixiurenyuanService;
    @Autowired
    private XueshengService xueshengService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永不会进入");
//        else if("维修人员".equals(role))
//            params.put("weixiurenyuanId",request.getSession().getAttribute("userId"));
//        else if("学生".equals(role))
//            params.put("xueshengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xianshangbaoxiuService.queryPage(params);

        //字典表数据转换
        List<XianshangbaoxiuView> list =(List<XianshangbaoxiuView>)page.getList();
        for(XianshangbaoxiuView c:list){
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
        XianshangbaoxiuEntity xianshangbaoxiu = xianshangbaoxiuService.selectById(id);
        if(xianshangbaoxiu !=null){
            //entity转view
            XianshangbaoxiuView view = new XianshangbaoxiuView();
            BeanUtils.copyProperties( xianshangbaoxiu , view );//把实体数据重构到view中

                //级联表
                WeixiurenyuanEntity weixiurenyuan = weixiurenyuanService.selectById(xianshangbaoxiu.getWeixiurenyuanId());
                if(weixiurenyuan != null){
                    BeanUtils.copyProperties( weixiurenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWeixiurenyuanId(weixiurenyuan.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(xianshangbaoxiu.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
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
    public R save(@RequestBody XianshangbaoxiuEntity xianshangbaoxiu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xianshangbaoxiu:{}",this.getClass().getName(),xianshangbaoxiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role)){
            xianshangbaoxiu.setXianshangbaoxiuJinchengTypes(1);
            xianshangbaoxiu.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        else if("维修人员".equals(role))
            xianshangbaoxiu.setWeixiurenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XianshangbaoxiuEntity> queryWrapper = new EntityWrapper<XianshangbaoxiuEntity>()
            .eq("xuesheng_id", xianshangbaoxiu.getXueshengId())
            .eq("weixiurenyuan_id", xianshangbaoxiu.getWeixiurenyuanId())
            .eq("xianshangbaoxiu_uuid_number", xianshangbaoxiu.getXianshangbaoxiuUuidNumber())
            .eq("xianshangbaoxiu_name", xianshangbaoxiu.getXianshangbaoxiuName())
            .eq("xianshangbaoxiu_types", xianshangbaoxiu.getXianshangbaoxiuTypes())
            .eq("xianshangbaoxiu_wupin_types", xianshangbaoxiu.getXianshangbaoxiuWupinTypes())
            .eq("wupin_address", xianshangbaoxiu.getWupinAddress())
            .eq("xianshangbaoxiu_jincheng_types", xianshangbaoxiu.getXianshangbaoxiuJinchengTypes())
            .eq("xianshangbaoxiu_pingjia_types", xianshangbaoxiu.getXianshangbaoxiuPingjiaTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XianshangbaoxiuEntity xianshangbaoxiuEntity = xianshangbaoxiuService.selectOne(queryWrapper);
        if(xianshangbaoxiuEntity==null){
            xianshangbaoxiu.setInsertTime(new Date());
            xianshangbaoxiu.setCreateTime(new Date());
            xianshangbaoxiuService.insert(xianshangbaoxiu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XianshangbaoxiuEntity xianshangbaoxiu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xianshangbaoxiu:{}",this.getClass().getName(),xianshangbaoxiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xianshangbaoxiu.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("维修人员".equals(role)){
            xianshangbaoxiu.setWeixiurenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            xianshangbaoxiu.setXianshangbaoxiuJinchengTypes(3);
        }
        //根据字段查询是否有相同数据
        Wrapper<XianshangbaoxiuEntity> queryWrapper = new EntityWrapper<XianshangbaoxiuEntity>()
            .notIn("id",xianshangbaoxiu.getId())
            .andNew()
            .eq("xuesheng_id", xianshangbaoxiu.getXueshengId())
            .eq("weixiurenyuan_id", xianshangbaoxiu.getWeixiurenyuanId())
            .eq("xianshangbaoxiu_uuid_number", xianshangbaoxiu.getXianshangbaoxiuUuidNumber())
            .eq("xianshangbaoxiu_name", xianshangbaoxiu.getXianshangbaoxiuName())
            .eq("xianshangbaoxiu_types", xianshangbaoxiu.getXianshangbaoxiuTypes())
            .eq("xianshangbaoxiu_wupin_types", xianshangbaoxiu.getXianshangbaoxiuWupinTypes())
            .eq("wupin_address", xianshangbaoxiu.getWupinAddress())
            .eq("xianshangbaoxiu_jincheng_types", xianshangbaoxiu.getXianshangbaoxiuJinchengTypes())
            .eq("xianshangbaoxiu_pingjia_types", xianshangbaoxiu.getXianshangbaoxiuPingjiaTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XianshangbaoxiuEntity xianshangbaoxiuEntity = xianshangbaoxiuService.selectOne(queryWrapper);
        if("".equals(xianshangbaoxiu.getXianshangbaoxiuPhoto()) || "null".equals(xianshangbaoxiu.getXianshangbaoxiuPhoto())){
                xianshangbaoxiu.setXianshangbaoxiuPhoto(null);
        }
        if("".equals(xianshangbaoxiu.getXianshangbaoxiuChengguoPhoto()) || "null".equals(xianshangbaoxiu.getXianshangbaoxiuChengguoPhoto())){
                xianshangbaoxiu.setXianshangbaoxiuChengguoPhoto(null);
        }
        if(xianshangbaoxiuEntity==null){
            xianshangbaoxiuService.updateById(xianshangbaoxiu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 接受工单
    */
    @RequestMapping("/jieshou")
    public R jieshou(@RequestParam("id") Integer id, HttpServletRequest request){

        logger.debug("jieshou:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(!"维修人员".equals(role))
            return R.error("当前登录账户不是维修人员,不能执行接受工单操作");
        XianshangbaoxiuEntity xianshangbaoxiuEntity = xianshangbaoxiuService.selectById(id);
        if(xianshangbaoxiuEntity == null)
            return R.error("查不到线上报修记录");

        if(xianshangbaoxiuEntity.getWeixiurenyuanId() != null)
            return R.error("该报修记录已经有维修人员了,你是怎么进来的呀");
        xianshangbaoxiuEntity.setWeixiurenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        xianshangbaoxiuEntity.setXianshangbaoxiuJinchengTypes(2);
        xianshangbaoxiuService.updateById(xianshangbaoxiuEntity);
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xianshangbaoxiuService.deleteBatchIds(Arrays.asList(ids));
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
            List<XianshangbaoxiuEntity> xianshangbaoxiuList = new ArrayList<>();//上传的东西
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
                            XianshangbaoxiuEntity xianshangbaoxiuEntity = new XianshangbaoxiuEntity();
//                            xianshangbaoxiuEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xianshangbaoxiuEntity.setWeixiurenyuanId(Integer.valueOf(data.get(0)));   //维修人员 要改的
//                            xianshangbaoxiuEntity.setXianshangbaoxiuUuidNumber(data.get(0));                    //报修编号 要改的
//                            xianshangbaoxiuEntity.setXianshangbaoxiuName(data.get(0));                    //报修名称 要改的
//                            xianshangbaoxiuEntity.setXianshangbaoxiuTypes(Integer.valueOf(data.get(0)));   //报修类型 要改的
//                            xianshangbaoxiuEntity.setXianshangbaoxiuWupinTypes(Integer.valueOf(data.get(0)));   //报修物品类型 要改的
//                            xianshangbaoxiuEntity.setXianshangbaoxiuPhoto("");//详情和图片
//                            xianshangbaoxiuEntity.setWupinAddress(data.get(0));                    //物品地址 要改的
//                            xianshangbaoxiuEntity.setBaoxiuneirongContent("");//详情和图片
//                            xianshangbaoxiuEntity.setInsertTime(date);//时间
//                            xianshangbaoxiuEntity.setXianshangbaoxiuJinchengTypes(Integer.valueOf(data.get(0)));   //报修进程 要改的
//                            xianshangbaoxiuEntity.setXianshangbaoxiuChengguoPhoto("");//详情和图片
//                            xianshangbaoxiuEntity.setXianshangbaoxiuPingjiaTypes(Integer.valueOf(data.get(0)));   //评价类型 要改的
//                            xianshangbaoxiuEntity.setPingjiaContent("");//详情和图片
//                            xianshangbaoxiuEntity.setPingjiaTime(sdf.parse(data.get(0)));          //评价时间 要改的
//                            xianshangbaoxiuEntity.setCreateTime(date);//时间
                            xianshangbaoxiuList.add(xianshangbaoxiuEntity);


                            //把要查询是否重复的字段放入map中
                                //报修编号
                                if(seachFields.containsKey("xianshangbaoxiuUuidNumber")){
                                    List<String> xianshangbaoxiuUuidNumber = seachFields.get("xianshangbaoxiuUuidNumber");
                                    xianshangbaoxiuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xianshangbaoxiuUuidNumber = new ArrayList<>();
                                    xianshangbaoxiuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xianshangbaoxiuUuidNumber",xianshangbaoxiuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报修编号
                        List<XianshangbaoxiuEntity> xianshangbaoxiuEntities_xianshangbaoxiuUuidNumber = xianshangbaoxiuService.selectList(new EntityWrapper<XianshangbaoxiuEntity>().in("xianshangbaoxiu_uuid_number", seachFields.get("xianshangbaoxiuUuidNumber")));
                        if(xianshangbaoxiuEntities_xianshangbaoxiuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XianshangbaoxiuEntity s:xianshangbaoxiuEntities_xianshangbaoxiuUuidNumber){
                                repeatFields.add(s.getXianshangbaoxiuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报修编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xianshangbaoxiuService.insertBatch(xianshangbaoxiuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
