package edu.cuit.robin.campushelper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.cuit.robin.campushelper.commons.util.JsonDataFormatConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ Author      : robin.
 * @ Date        : Created in 11:46 2019/4/9
 * @ Description : TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampusInfo {
    private Integer ciId;

    private Integer userId;

    private String title;

    private String content;

    private String picUrl;

    @JsonFormat(pattern = JsonDataFormatConst.DATA_FORMAT_DAY,timezone = JsonDataFormatConst.DATA_ZONE)
    private Date createTime;

}
