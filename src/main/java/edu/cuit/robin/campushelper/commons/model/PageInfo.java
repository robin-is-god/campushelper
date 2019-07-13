package edu.cuit.robin.campushelper.commons.model;

import lombok.Data;

import java.util.List;

@Data
public class PageInfo<T> {
    private long total;
    private T rows;
    private long totalPage;
}
