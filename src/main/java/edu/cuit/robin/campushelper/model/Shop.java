package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author      : robin.
 * @ Date        : Created in 15:32 2019/4/7
 * @ Description : TODO
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Shop {
    private Integer sId;

    private Integer userId;

    private String shopName;

    private float shopScore;

    private String shopDescription;

    private Boolean enable;
}
