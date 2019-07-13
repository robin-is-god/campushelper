package edu.cuit.robin.campushelper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.cuit.robin.campushelper.commons.util.JsonDataFormatConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author      : robin.
 * @ Date        : Created in 11:48 2019/4/9
 * @ Description : TODO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AroundInfo {
    private Integer aiId;

    private Integer userId;
    
    private String type;
    
    private String title;

    private String contact;

    private String content;

    private String picUrl;

    @JsonFormat(pattern = JsonDataFormatConst.DATA_FORMAT_DAY,timezone = JsonDataFormatConst.DATA_ZONE)
    private String createTime;
}
