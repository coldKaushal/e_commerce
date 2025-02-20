package com.practice.e_commerce.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "Asset")
@ToString
public class Asset {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;
    private String assetName;
    private Long assetCount;

}
