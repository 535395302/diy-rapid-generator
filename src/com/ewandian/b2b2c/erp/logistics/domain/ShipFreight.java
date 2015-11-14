package com.ewandian.b2b2c.erp.logistics.domain;

import diy.annos.MaxLength;
import diy.annos.Remark;

import java.math.BigDecimal;

/**
 * @author Tian
 * @version 1.0
 * @date 2015-10-20 11:03
 */
public class ShipFreight {
    @Remark("ID")@MaxLength(40)
    private String id;
    @Remark("发货单号")@MaxLength(15)
    private String shipOrder;
    @Remark("运费细项编号")@MaxLength(15)
    private String itemId;
    @Remark("费用")
    private BigDecimal fee;
}
