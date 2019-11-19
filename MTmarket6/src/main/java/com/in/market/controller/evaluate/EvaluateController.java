package com.in.market.controller.evaluate;

import com.in.market.service.evaluate.EvaluateService;

import com.in.market.util.ResultList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    EvaluateService evaluateService;

    /**
     * 提交评论
     * 返回评论Id
     *@RequestParam("files")MultipartFile[] files,
     */

    @RequestMapping(value = "/evaUpload",method = RequestMethod.POST)
//    Integer evaUser, String evaContent, Integer evaGoods, Integer evaLevel,String userName,String userPhoto
    public ResponseEntity<Integer> evaUpload (@RequestBody String json){
        /*
        如果成功则返回订单
         */
        if(StringUtils.isNotEmpty(json)){
           Integer result=null;
            result=evaluateService.evaUpload(json);
       if(result!=null)
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 通过商品Id查询评论
     */
    @RequestMapping(value = "/queryByGId/{goodsId}",method = RequestMethod.GET)
    public ResponseEntity<ResultList> queryByGId(@PathVariable("goodsId") Integer goodsId){
        ResultList resultList = null;
        if(goodsId!=null){
            resultList=evaluateService.queryByGId(goodsId);
                return ResponseEntity.ok(resultList);
        }
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /***
     *根据用户Id查询所有评论
     */
    @RequestMapping(value = "/queryAllByUId/{userId}")
    public ResponseEntity<ResultList> queryAllByUId(@PathVariable("userId") Integer userId){
        ResultList resultList=null;
        if(userId!=null){
            resultList=evaluateService.queryAllByUId(userId);
            if(resultList!=null)
                return ResponseEntity.ok(resultList);
            else
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * 删除评论
     */
    @RequestMapping(value="/deleteByevaId/{evaId}")
    public ResponseEntity<Void>  deleteByevaId(@PathVariable("evaId") Integer evaId){
//        List<String> list=null;
//        list=evaluateService.queryImasByeId(evaId);
        if(evaluateService.deleteByevaId(evaId)){
//            /**
//             * 调用Util方法删除文件夹中的文件
//             */
//            if(list!=null&&list.size()>0)
//                EvaluateUtil.deleteImages(list);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     *根据eva_State修改评论状态
     *para：json
     *  evaId  evaState:1正常 -1：删除
     */
    @RequestMapping(value ="updateEva",method=RequestMethod.POST)
    public ResponseEntity<Void> updateEva(@RequestBody String json){
        if(StringUtils.isNotEmpty(json)){
            if(evaluateService.updateEva(json)){
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 根据评论程度查询评论
     */
    @RequestMapping(value = "queryBylevel/{evaLevel}",method = RequestMethod.GET)
    public ResponseEntity<ResultList> queryBylevel(@PathVariable Integer evaLevel){
        ResultList resultList=null;
        if(evaLevel!=null){
           resultList= evaluateService.queryBylevel(evaLevel);
           if(resultList!=null){
               return ResponseEntity.ok(resultList);
           }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 好评率
     */
    @RequestMapping("goodpanel")
    public ResponseEntity<String> goodpanel(Integer goodId){
        double result=0;
        result=evaluateService.goodpanel(goodId);
        return ResponseEntity.ok(String.format("%.0f", result*100));
    }
}




//        MultipartFile[] files=null;
    ///评论iD
//    Integer evaId=null;
/**
 * 上传照片
 */
//        List<Evaimg>evaimgs=new ArrayList<>();
//        List<Evaimg> evaimgs=null;
//        if(files!=null){
//            //照片存取的地址
////            String path ="D:\\IDEAJAVA\\ssm__15_MTmarket\\src\\main\\webapp\\images";
//            String path="";
//            for (MultipartFile file:files){
//                Evaimg evaimg=new Evaimg();
//                //将随机数与文件原本名字结合起来
//                    String FileName=new EvaluateUtil().getRandom()+file.getOriginalFilename();
//                    System.out.println(FileName);
//                    //封装上传文件位置的全路径
//               File savefile=new File(path,FileName);
//                try {
//                    file.transferTo(savefile);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                //将评论照片类存到对象中
//                evaimg.setEvaimgName(FileName);
//                evaimg.setEva(evaId);
//                Integer evaimgId=null;
//                evaimg.setEvaimgId(evaimgId);
//                //将照片类放到集合中
//                if(evaimg!=null)
//                    evaimgs.add(evaimg);
//            }
//        }
