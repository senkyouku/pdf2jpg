package com.ourhours.tool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor qianxu
 * @create 2018-04-25 下午5:20
 */


@RestController
@RequestMapping("/pdf2jpg")
public class MainController {

    @RequestMapping("/exec")
    @ResponseBody
    public String exec(String source,String target) {
        try {
//			String source = "/data/local/fastdfs_data/storage/images/data/data/00/81/invoice.pdf";
//			String target = "/data/local/fastdfs_data/storage/images/data/data/00/81/invoice.pdf__.jpg";
            Process p = Runtime.getRuntime().exec("/data/local/bins/pdf2jpg.sh "+source+" "+target);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String ret = reader.readLine();
            System.out.println(ret);
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return "ok";
    }
}
