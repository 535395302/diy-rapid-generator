package ${basePkg}.${business}.${task};

import com.ewandian.b2b2c.gl.arap.domain.po.base.ApMaster;

/**
 * <b>${desc} ${task}</b> 服务<br/>
 * @author Tian
 * @version 1.0
 * @date ${now?string("yyyy-MM-dd")}
 */
public class ${business?cap_first}${task?cap_first}Service extends UpdateFromPurchaseService<${entityType},${paramType}> {
    private static final Logger logger = LoggerFactory.getLogger(${business?cap_first}${task?cap_first}Service.class);

    @Override
    public ApMaster execute(${paramType} param) {
        return super.execute(param);
    }
}
