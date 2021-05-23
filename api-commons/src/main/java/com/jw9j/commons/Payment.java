package com.jw9j.commons;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment implements Serializable {
    private int id;
    private String serial;
}
