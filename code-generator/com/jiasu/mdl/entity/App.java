package com.jiasu.mdl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class App implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String carNo;

    private Integer vehicleQueuingNumber;

    private String cChnlName;

    private String bindCompany;

    private String whName;

    private String goodsName;

    private Double bachNumberWeight;

    private Integer isCar;

    private LocalDateTime createTime;

    private String operatingMan;

    private Integer isRead;

    private Integer customsId;

    private String createUser;


}
