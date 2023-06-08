package com.example.one.controller;

import com.example.one.model.Farm;
import com.example.one.model.Response;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/farm")
public class FarmController {

    private Log logger = LogFactory.getLog(this.getClass());

    //---------1번 (품목코드 정보)
//    @GetMapping("/get")
//    @ResponseBody
//    public Response getXX(@RequestParam String apiKey) throws Exception {
//
//        //apiKey "20230601JKDXVD39FWGMF0PJBPWMA"
//        //kidofcomdtySeCode  "210004"
//
////        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleGrpList"
////                + "?apiKey=" + apiKey
////                + "&kidofcomdtySeCode=" + kidofcomdtySeCode;
//
//        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleGrpList"
//                + "?apiKey=" + apiKey;
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        String xml =  restTemplate.getForObject(url, String.class);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        Response response = xmlMapper.readValue(xml, Response.class);
//        return response;
//    }


    //---------2번 (농작업일정 목록)
//    @GetMapping("/get")
//    @ResponseBody
//    public Response getXX(@RequestParam String apiKey,String kidofcomdtySeCode) throws Exception {
//
//        //apiKey "20230601JKDXVD39FWGMF0PJBPWMA"
//        //kidofcomdtySeCode  "210004"
//
////        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleLst"
////                + "?apiKey=" + apiKey
////                + "&kidofcomdtySeCode=" + kidofcomdtySeCode;
//
//        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleLst"
//                + "?apiKey=" + apiKey
//                + "&kidofcomdtySeCode=" + kidofcomdtySeCode;
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        String xml =  restTemplate.getForObject(url, String.class);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        Response response = xmlMapper.readValue(xml, Response.class);
//        return response;
//    }

    //---------3번 (농작업일정 상세 정보 목록)
    @GetMapping("/get")
    @ResponseBody
    public Response getXX(@RequestParam String cntntsNo,String apiKey) throws Exception {

        //apiKey "20230601JKDXVD39FWGMF0PJBPWMA"
        //kidofcomdtySeCode  "210004"

//        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleDtl"
//                + "?apiKey=" + apiKey
//                + "&kidofcomdtySeCode=" + kidofcomdtySeCode;

        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleDtl"
                + "?cntntsNo=" + cntntsNo
                + "&apiKey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        String xml =  restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);
        return response;
    }

    //---------4번 (농작업일정 달력 목록)
//    @GetMapping("/get")
//    @ResponseBody
//    public Response getXX(@RequestParam String cntntsNo,String apiKey) throws Exception {
//
//        //apiKey "20230601JKDXVD39FWGMF0PJBPWMA"
//        //kidofcomdtySeCode  "210004"
//
////        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleEraInfoLst"
////                + "?apiKey=" + apiKey
////                + "&kidofcomdtySeCode=" + kidofcomdtySeCode;
//
//        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleEraInfoLst"
//                + "?cntntsNo=" + cntntsNo
//                + "&apiKey=" + apiKey;
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        String xml = restTemplate.getForObject(url, String.class);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        Response response = xmlMapper.readValue(xml, Response.class);
//        return response;
//    }
}
