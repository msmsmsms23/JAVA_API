package com.example.one.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    @JacksonXmlProperty(localName = "codeNm")
    @JacksonXmlCData
    private String codeNm;

    @JacksonXmlProperty(localName = "kidofcomdtySeCode")
    @JacksonXmlCData
    private String kidofcomdtySeCode;

    @JacksonXmlProperty(localName = "sort")
    @JacksonXmlCData
    private String sort;

    @JacksonXmlProperty(localName = "cntntsNo")
    @JacksonXmlCData
    private String cntntsNo;

    @JacksonXmlProperty(localName = "fileDownUrlInfo")
    @JacksonXmlCData
    private String fileDownUrlInfo;

    @JacksonXmlProperty(localName = "fileName")
    @JacksonXmlCData
    private String fileName;

    @JacksonXmlProperty(localName = "sj")
    @JacksonXmlCData
    private String sj;

    @JacksonXmlProperty(localName = "cn")
    @JacksonXmlCData
    private String cn;

    @JacksonXmlProperty(localName = "kidofcomdtySeCodeNm")
    @JacksonXmlCData
    private String kidofcomdtySeCodeNm;

    @JacksonXmlProperty(localName = "htmlCn")
    @JacksonXmlCData
    private String htmlCn;

    @JacksonXmlProperty(localName = "code")
    @JacksonXmlCData
    private String code;

    @JacksonXmlProperty(localName = "mvpCipNo")
    @JacksonXmlCData
    private String mvpCipNo;

    @JacksonXmlProperty(localName = "mvpClipSj")
    @JacksonXmlCData
    private String mvpClipSj;

    @JacksonXmlProperty(localName = "mvpNo")
    @JacksonXmlCData
    private String mvpNo;

//    @JacksonXmlProperty(localName = "sj2")
//    @JacksonXmlElementWrapper(useWrapping = false)
//    @JacksonXmlCData
//    private String sj2;

    @JacksonXmlProperty(localName = "stdPrdlstCodeNm")
    @JacksonXmlCData
    private String stdPrdlstCodeNm;

    @JacksonXmlProperty(localName = "videoImg")
    @JacksonXmlCData
    private String videoImg;

    @JacksonXmlProperty(localName = "videoLink")
    @JacksonXmlCData
    private String videoLink;

    // String-argument constructor
    public Item(String codeNm) {
        this.codeNm = codeNm;
    }

    // default constructor
    public Item() {
    }
}