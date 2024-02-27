package com.example.helloworld.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "buildingsupdated")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Building {

    @Id
    private Integer buildingid;
    @JsonIgnore
    private String location;
    private String businesstype;
    private String businessid;
    @JsonIgnore
    private String buildingtype;
    private String maxoccupancy;
    @JdbcTypeCode(SqlTypes.JSON)
    @JsonIgnore
    private List<Integer> units;

}