package com.example.one.controller;

import com.example.one.model.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;

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

        List<Item> item = response.getBody().getItems().getItem();

        List<String> codeNms = item.stream()
                .map(Item::getCodeNm)
                .collect(Collectors.toList());

        List<String> kidofcomdtySeCode = item.stream()
                .map(Item::getKidofcomdtySeCode)
                .collect(Collectors.toList());

        Map<String, Object> result = new HashMap<>();
        result.put("codeNms", codeNms);
        result.put("kidofcomdtySeCode", kidofcomdtySeCode);

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

        List<Item> item = response.getBody().getItems().getItem();

        List<String> sjList = item.stream()
                .map(Item::getSj)
                .collect(Collectors.toList());

        List<String> cntntsNoList = item.stream()
                .map(Item::getCntntsNo)
                .collect(Collectors.toList());

        Map<String, Object> result1 = new HashMap<>();
        result1.put("sjList", sjList);
        result1.put("cntntsNoList", cntntsNoList);

        return result1;

    }

    //---------3번 (농작업일정 상세 정보 목록)
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

        List<Item> item = response.getBody().getItems().getItem();

        List<String> htmlCnList = item.stream()
                .map(Item::getHtmlCn)
                .collect(Collectors.toList());

        return htmlCnList;
    }

    @GetMapping("/searchCode")
    @ApiOperation(value = "2-(1) 품목 분류 목록")
    @ResponseBody
    public Map<String, Object> searchCode(@RequestParam String apiKey) throws Exception {
        String url = "http://api.nongsaro.go.kr/service/curationMvp/mainCategoryList"
                + "?apiKey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String xml = restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);

        Body body = response.getBody();
        List<Item> item = response.getBody().getItems().getItem();

        List<String> code = item.stream()
                .map(Item::getCode)
                .collect(Collectors.toList());

        Map<String, Object> lecturemv = new HashMap<>();

        List<String> codeNm = item.stream()
                .map(Item::getCodeNm)
                .collect(Collectors.toList());

        lecturemv.put("code", code);
        lecturemv.put("codeNm", codeNm);

        return lecturemv;
    }

//    @GetMapping("/lecture")
//    @ApiOperation(value = "2-(2) 주제별 짧은 기술 동영상 목록")
//    @ResponseBody
//    public Map<String, Object> lecture(@RequestParam String apiKey) throws Exception {
//        String url = "http://api.nongsaro.go.kr/service/curationMvp/curationMvpList"
//                + "?apiKey=" + apiKey;
//
//        RestTemplate restTemplate = new RestTemplate();
//        String xml = restTemplate.getForObject(url, String.class);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        Response response = xmlMapper.readValue(xml, Response.class);
//
//        Body body = response.getBody();
//        List<Item> item = body.getItems().getItem();
//
//        List<String> mvpCipNo = item.stream()
//                .filter(Objects::nonNull)
//                .map(Item::getMvpCipNo)
//                .collect(Collectors.toList());
//
//        List<String> mvpClipSj = item.stream()
//                .filter(Objects::nonNull)
//                .map(Item::getMvpClipSj)
//                .collect(Collectors.toList());
//
//        List<String> mvpNo = item.stream()
//                .filter(Objects::nonNull)
//                .map(Item::getMvpNo)
//                .collect(Collectors.toList());
//
//        List<String> sj = item.stream()
//                .filter(Objects::nonNull)
//                .map(Item::getSj)
//                .collect(Collectors.toList());
//
//        List<String> stdPrdlstCodeNm = item.stream()
//                .filter(Objects::nonNull)
//                .map(Item::getStdPrdlstCodeNm)
//                .collect(Collectors.toList());
//
//        List<String> videoImg = item.stream()
//                .filter(Objects::nonNull)
//                .map(Item::getVideoImg)
//                .collect(Collectors.toList());
//
//        List<String> videoLink = item.stream()
//                .filter(Objects::nonNull)
//                .map(Item::getVideoLink)
//                .collect(Collectors.toList());
//
//        Map<String, Object> lecturelist = new HashMap<>();
//        lecturelist.put("mvpCipNo", mvpCipNo);
//        lecturelist.put("mvpClipSj", mvpClipSj);
//        lecturelist.put("mvpNo", mvpNo);
//        lecturelist.put("sj", sj);
//        lecturelist.put("stdPrdlstCodeNm", stdPrdlstCodeNm);
//        lecturelist.put("videoImg", videoImg);
//        lecturelist.put("videoLink", videoLink);
//        lecturelist.put("numOfRows", body.getItems().getNumOfRows());
//        lecturelist.put("pageNo", body.getItems().getPageNo());
//        lecturelist.put("totalCount", body.getItems().getTotalCount());
//
//        return lecturelist;
//    }
    @GetMapping("/lecture")
    @ApiOperation(value = "2-(2) 주제별 짧은 기술 동영상 목록")
    @ResponseBody
    public Map<String, Object> lecture(@RequestParam String apiKey, String mainCategory) throws Exception {
        String url = "http://api.nongsaro.go.kr/service/curationMvp/curationMvpList"
                + "?apiKey=" + apiKey
                + "&mainCategory=" + mainCategory;

        RestTemplate restTemplate = new RestTemplate();
        String xml = restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);

        Body body = response.getBody();
        List<Item> item = body.getItems().getItem();

        List<String> mvpCipNo = item.stream()
                .filter(Objects::nonNull)
                .map(Item::getMvpCipNo)
                .collect(Collectors.toList());

        List<String> mvpClipSj = item.stream()
                .filter(Objects::nonNull)
                .map(Item::getMvpClipSj)
                .collect(Collectors.toList());

        List<String> mvpNo = item.stream()
                .filter(Objects::nonNull)
                .map(Item::getMvpNo)
                .collect(Collectors.toList());

        List<String> sj = item.stream()
                .filter(Objects::nonNull)
                .map(Item::getSj)
                .collect(Collectors.toList());

        List<String> stdPrdlstCodeNm = item.stream()
                .filter(Objects::nonNull)
                .map(Item::getStdPrdlstCodeNm)
                .collect(Collectors.toList());

        List<String> videoImg = item.stream()
                .filter(Objects::nonNull)
                .map(Item::getVideoImg)
                .collect(Collectors.toList());

        List<String> videoLink = item.stream()
                .filter(Objects::nonNull)
                .map(Item::getVideoLink)
                .collect(Collectors.toList());

        Map<String, Object> lecturelist = new HashMap<>();
        lecturelist.put("mvpCipNo", mvpCipNo);
        lecturelist.put("mvpClipSj", mvpClipSj);
        lecturelist.put("mvpNo", mvpNo);
        lecturelist.put("sj", sj);
        lecturelist.put("stdPrdlstCodeNm", stdPrdlstCodeNm);
        lecturelist.put("videoImg", videoImg);
        lecturelist.put("videoLink", videoLink);
        lecturelist.put("numOfRows", body.getItems().getNumOfRows());
        lecturelist.put("pageNo", body.getItems().getPageNo());
        lecturelist.put("totalCount", body.getItems().getTotalCount());

        return lecturelist;
    }

}