package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ Author      : robin.
 * @ Date        : Created in 14:14 2019/5/10
 * @ Description : TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo {
    private Integer oId;
    
    private Integer suserId;
    
    private Integer buserId;
    
    private Integer gId;
    
    private Integer quantity;
    
    private String seriaNum;
    
    private Integer aId;

    private float total;
    
    private Date createTime;
}
