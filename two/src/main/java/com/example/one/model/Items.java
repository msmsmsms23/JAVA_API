package com.example.one.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class Items {
    @JacksonXmlProperty(localName = "item")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Item> item;
//    private Integer numOfRows;
//    private Integer pageNo;
//    private Integer totalCount;

    @JacksonXmlProperty(localName = "numOfRows")
    @JacksonXmlCData
    private String numOfRows;

    @JacksonXmlProperty(localName = "pageNo")
    @JacksonXmlCData
    private String pageNo;

    @JacksonXmlProperty(localName = "totalCount")
    @JacksonXmlCData
    private String totalCount;
}

//    @JsonSetter("numOfRows")
//    public void setNumOfRows(Integer numOfRows) {
//        this.numOfRows = numOfRows;
//    }
//
//    @JsonSetter("pageNo")
//    public void setPageNo(Integer pageNo) {
//        this.pageNo = pageNo;
//    }
//
//    @JsonSetter("totalCount")
//    public void setTotalCount(Integer totalCount){
//        this.totalCount = totalCount;
//    }