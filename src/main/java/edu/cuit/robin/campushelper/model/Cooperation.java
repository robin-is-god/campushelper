package edu.cuit.robin.campushelper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.cuit.robin.campushelper.commons.util.JsonDataFormatConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ Author      : robin.
 * @ Date        : Created in 11:44 2019/4/9
 * @ Description : TODO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cooperation {
    private Integer cooId;

    private Integer userId;

    private String title;

    private String content;

    private String contact;

    private String picUrl;

    @JsonFormat(pattern = JsonDataFormatConst.DATA_FORMAT_SECOND,timezone = JsonDataFormatConst.DATA_ZONE)
    private Date createTime;

    private Boolean solve;
}
