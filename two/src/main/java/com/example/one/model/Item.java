package com.example.one.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // 변수의 값이 없어도 오류가 발생하지 않도록 함
@JacksonXmlRootElement(localName="item")
public class Item {
    //---------1번 (품목코드 정보)
    @JacksonXmlProperty(localName = "codeNm")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String codeNm;

    @JacksonXmlProperty(localName = "kidofcomdtySeCode")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String kidofcomdtySeCode;

    @JacksonXmlProperty(localName = "sort")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String sort;

    //---------2번 (농작업일정 목록)

    @JacksonXmlProperty(localName = "cntntsNo")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String cntntsNo;

    @JacksonXmlProperty(localName = "fileDownUrlInfo")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String fileDownUrlInfo;

    @JacksonXmlProperty(localName = "fileName")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String fileName;

    @JacksonXmlProperty(localName = "sj")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String sj;

    //---------3번 (농작업일정 상세 정보 목록)
    @JacksonXmlProperty(localName = "cn")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String cn;

    @JacksonXmlProperty(localName = "kidofcomdtySeCodeNm")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String kidofcomdtySeCodeNm;

    //---------4번 (농작업일정 달력 목록)
    @JacksonXmlProperty(localName = "htmlCn")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String htmlCn;

}
