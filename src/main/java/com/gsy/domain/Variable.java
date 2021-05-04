package com.gsy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Variable {

    private int ID;
    private int type;
    private String value;
}
