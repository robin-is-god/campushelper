package edu.cuit.robin.campushelper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.cuit.robin.campushelper.commons.util.JsonDataFormatConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ Author      : robin.
 * @ Date        : Created in 11:38 2019/4/9
 * @ Description : TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LostProperty {
   private Integer pId;

   private Integer userId;

   private String propertyName;

   private String propertyPicture;

   private String detail;

   private String contact;

   @JsonFormat(pattern = JsonDataFormatConst.DATA_FORMAT_SECOND,timezone = JsonDataFormatConst.DATA_ZONE)
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date createTime;

   private Boolean findOrLost;

   private Boolean solve;
}
