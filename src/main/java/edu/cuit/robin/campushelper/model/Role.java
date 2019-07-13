package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author      : robin.
 * @ Date        : Created in 15:29 2019/4/7
 * @ Description : TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer rId;

    private String rName;

    private String description;
}
