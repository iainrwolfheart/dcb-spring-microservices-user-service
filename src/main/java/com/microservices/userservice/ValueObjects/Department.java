package com.microservices.userservice.ValueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private ObjectId departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
