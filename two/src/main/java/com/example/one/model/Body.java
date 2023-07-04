package com.example.one.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Body {
    private Items items;
    private Item item;
//    private Integer numOfRows;
//    private Integer pageNo;
//    private Integer totalCount;

    @JsonSetter("item")
    public void setItem(Item item) {
        this.item = item;
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
}