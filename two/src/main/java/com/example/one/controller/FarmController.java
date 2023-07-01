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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080/farm/get")
@RestController
@RequestMapping("/farm")
public class FarmController {

    private Log logger = LogFactory.getLog(this.getClass());

    @GetMapping("/get")
    @ApiOperation(value = "(1)품목코드 정보 조회")
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
    @ApiOperation(value = "(2)농작업일정 목록 정보 조회")
    @ResponseBody
    public Map<String, Object> getSubItems(@RequestParam String apiKey,@RequestParam String kidofcomdtySeCode) throws Exception {
        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleLst"
                + "?apiKey=" + apiKey
                + "&kidofcomdtySeCode=" + kidofcomdtySeCode;

        RestTemplate restTemplate = new RestTemplate();
        String xml = restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);

        List<String> sjList = response.getBody().getItems().stream()
                .map(Item::getSj)
                .collect(Collectors.toList());

        List<String> cntntsNoList = response.getBody().getItems().stream()
                .map(Item::getCntntsNo)
                .collect(Collectors.toList());

        Map<String, Object> result1 = new HashMap<>();
        result1.put("sjList", sjList);
        result1.put("cntntsNoList", cntntsNoList);

        return result1;

    }

    @GetMapping("/getDetail")
    @ApiOperation(value = "(3) 농작업 상세기능 명세")
    @ResponseBody
    public List<String> getDetail(@RequestParam String cntntsNo,@RequestParam String apiKey) throws Exception {

        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleDtl"
                + "?cntntsNo=" + cntntsNo
                + "&apiKey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String xml =  restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);

        List<String> cnList = Collections.singletonList(response.getBody().getItem().getCn());

        return cnList;
    }

    @GetMapping("/getCalendar")
    @ApiOperation(value = "(4) 농작업일정 시기 정보 조회 상세기능 명세")
    @ResponseBody
    public List<String> getCalendar(@RequestParam String cntntsNo,@RequestParam String apiKey) throws Exception {
        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleEraInfoLst"
                + "?cntntsNo=" + cntntsNo
                + "&apiKey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String xml = restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);

        List<String> htmlCnList = response.getBody().getItems().stream()
                .map(Item::getHtmlCn)
                .collect(Collectors.toList());

        return htmlCnList;
    }

    @GetMapping("/lecture")
    @ApiOperation(value = "(5) 주제별 짧은 기술 동영상 목록")
    @ResponseBody
    public Map<String, Object> lecture(@RequestParam String apiKey) throws Exception {


        String url = "http://api.nongsaro.go.kr/service/lectureDicMvp/lectureDicMvpList"
                + "?apiKey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        String xml = restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);

        List<String> lectureCodeNmList = response.getBody().getItems().stream()
                .map(Item::getLectureCodeNm)
                .collect(Collectors.toList());


        Map<String, Object> result2 = new HashMap<>();
        result2.put("lectureCodeNmList", lectureCodeNmList);

        return result2;
    }
}