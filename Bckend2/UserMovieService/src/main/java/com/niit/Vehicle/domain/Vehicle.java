package com.niit.Vehicle.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Vehicle {
    @Id
    private int id;
    private  String title;
    private int price;
    private String description;
    private String category;
    private String image;







}
