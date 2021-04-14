package com.codeyancy.cn.controller;

import com.codeyancy.cn.utils.http.AxiosResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Zjy
 * @date 2021/4/12 23:21
 */
@RestController
@RequestMapping("common")
public class CommonController {


    //员工头像上传
    @PostMapping("upload")
    public AxiosResult<String> uploadAvatar(@RequestBody Map<String,String> map){
        String base64 = map.get("base64");

        System.out.println(base64);

        return AxiosResult.success(base64);
    }


}
