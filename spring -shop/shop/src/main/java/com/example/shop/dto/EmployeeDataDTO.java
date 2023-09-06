package com.example.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDataDTO {

    private long idEmployeeData;
    private String loginEmployee;
    private String passwordEmployee;
    private String emailEmployee;
}
