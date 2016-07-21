package ${basePkg}.${business}.${task};

import com.ewandian.b2b2c.gl.arap.domain.po.base.ApMaster;
import com.ewandian.b2b2c.gl.arap.validation.IValidation;
import org.springframework.validation.Errors;

/**
 * <b>${desc}</b> 校验服务<br/>
 * @author Tian
 * @version 1.0
 * @date ${now?string("yyyy-MM-dd")}
 */
public class ${business?cap_first}${task?cap_first}Validation extends AbstBaseValidation implements IValidation<${entityType}> {
    private static final Logger logger = LoggerFactory.getLogger(${business?cap_first}${task?cap_first}Validation.class);

    /**
     * @param entity 被校验对象
     * @return errors 错误信息
     */
    @Override
    public Errors validate(${entityType} entity) {
        return null;
    }
}
