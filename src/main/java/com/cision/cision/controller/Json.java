package com.cision.cision.controller;
import lombok.*;



@Data
@Builder
public class Json {

    private long id;

    private String content;

    private String timestamp;

    private long size;

}
