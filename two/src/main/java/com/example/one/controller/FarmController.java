package com.example.one.controller;

import com.example.one.model.Farm;
import com.example.one.model.Item;
import com.example.one.model.Response;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.swagger.annotations.ApiOperation;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080/farm/get")
@RestController
@RequestMapping("/farm")
public class FarmController {

    private Log logger = LogFactory.getLog(this.getClass());

    //---------1번 (품목코드 정보)
//    @GetMapping("/get")
//    @ResponseBody
//    public List<String> getXX(@RequestParam String apiKey) throws Exception {
//        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleGrpList"
//                + "?apiKey=" + apiKey;
//
//        RestTemplate restTemplate = new RestTemplate();
//        String xml = restTemplate.getForObject(url, String.class);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        Response response = xmlMapper.readValue(xml, Response.class);
//
//        List<String> codeNms = response.getBody().getItems().stream()
//                .map(item -> item.getCodeNm())
//                .collect(Collectors.toList());
//
//        return codeNms;
//    }
    @GetMapping("/get")
    @ApiOperation(value = "품목코드 정보 조회")
    @ResponseBody
    public Map<String, Object> getXX(@RequestParam String apiKey) throws Exception {
        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleGrpList"
                + "?apiKey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String xml = restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);

        List<String> codeNms = response.getBody().getItems().stream()
                .map(Item::getCodeNm)
                .collect(Collectors.toList());

        List<String> kidofcomdtySeCodes = response.getBody().getItems().stream()
                .map(Item::getKidofcomdtySeCode)
                .collect(Collectors.toList());

        Map<String, Object> result = new HashMap<>();
        result.put("codeNms", codeNms);
        result.put("kidofcomdtySeCodes", kidofcomdtySeCodes);

        return result;
    }

    @GetMapping("/getSubItems")
    @ResponseBody
    public List<String> getSubItems(@RequestParam String apiKey,@RequestParam String kidofcomdtySeCode) throws Exception {
        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleLst"
                + "?apiKey=" + apiKey
                + "&kidofcomdtySeCode=" + kidofcomdtySeCode;

        RestTemplate restTemplate = new RestTemplate();
        String xml = restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);

        List<String> sjList = response.getBody().getItems().stream()
//                .filter(item -> item.getKidofcomdtySeCode().equalsIgnoreCase(kidofcomdtySeCode))
                .map(Item::getSj)
                .collect(Collectors.toList());

        return sjList;
    }


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
//    @GetMapping("/get")
//    @ResponseBody
//    public Response getXX(@RequestParam String cntntsNo,String apiKey) throws Exception {
//
//        //apiKey "20230601JKDXVD39FWGMF0PJBPWMA"
//        //kidofcomdtySeCode  "210004"
//
////        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleDtl"
////                + "?apiKey=" + apiKey
////                + "&kidofcomdtySeCode=" + kidofcomdtySeCode;
//
//        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleDtl"
//                + "?cntntsNo=" + cntntsNo
//                + "&apiKey=" + apiKey;
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        String xml =  restTemplate.getForObject(url, String.class);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        Response response = xmlMapper.readValue(xml, Response.class);
//        return response;
//    }

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

    //--------- 강의동영상
//    @GetMapping("/get")
//    @ResponseBody
//    public Response getXX(@RequestParam String apiKey) throws Exception {
//
//        //apiKey "20230601JKDXVD39FWGMF0PJBPWMA"
//
////        String url = "http://api.nongsaro.go.kr/service/lectureDicMvp/lectureDicMvpList"
////                + "?apiKey=" + apiKey
//
//        String url = "http://api.nongsaro.go.kr/service/lectureDicMvp/lectureDicMvpList"
//                + "?apiKey=" + apiKey;
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