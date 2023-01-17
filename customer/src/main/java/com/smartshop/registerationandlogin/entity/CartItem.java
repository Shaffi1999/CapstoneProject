package com.smartshop.registerationandlogin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@NoArgsConstructor
@Entity
@AllArgsConstructor
public class CartItem {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private int productId;
private int price;
private String productName;
@ManyToOne(cascade = CascadeType.MERGE)
@JoinColumn(name = "USER_ID" ,referencedColumnName  ="userId")
private User user;
private int quantity;




}

