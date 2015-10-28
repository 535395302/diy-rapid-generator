package cn.org.rapid_framework.generator.provider.java.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import cn.org.rapid_framework.generator.util.typemapping.ActionScriptDataTypesUtils;
import diy.annos.MaxLength;
import diy.annos.Remark;

public class JavaField {
	private Field field;
	private JavaClass clazz; //与field相关联的class

	// TODO javaType --> jdbcType
	private final static Map<String, String> _types = new HashMap<String, String>();
	static {
		_types.put( "java.lang.Byte"		,"TINYINT"		);
		_types.put( "java.lang.Short"		,"SMALLINT"		);
		_types.put( "java.lang.Integer"		,"INTEGER"		);
		_types.put( "int"		,"INTEGER"		);
		_types.put( "java.lang.Long"		,"BIGINT"		);
		_types.put( "java.lang.Float"		,"REAL"			);
		_types.put( "java.lang.Double"		,"DOUBLE"		);
		_types.put( "java.math.BigDecimal"	,"NUMERIC"		);
		_types.put( "java.lang.Boolean"		,"BOOLEAN"		);
		_types.put( "java.lang.String"		,"VARCHAR"		);
		_types.put( "java.util.Date"		,"TIMESTAMP"	);
		_types.put( "java.sql.Date"			,"DATE"			);
		_types.put( "java.sql.Time"			,"TIME"			);
		_types.put( "java.sql.Timestamp"	,"TIMESTAMP"	);
		_types.put( "java.sql.Clob"			,"CLOB"			);
		_types.put( "java.sql.Blob"			,"BLOB"			);
		_types.put( "java.sql.Array"		,"ARRAY"		);
		_types.put( "java.sql.Ref"			,"REF"			);
	}

	public JavaField(Field field, JavaClass clazz) {
		super();
		this.field = field;
		this.clazz = clazz;
	}

	public String getRemark(){
		Remark rk = field.getAnnotation(Remark.class);
		return rk==null ? field.getName() : rk.value();
	}

	public Integer getMaxLength(){
		if(field.getType().equals(String.class)){
			MaxLength rk = field.getAnnotation(MaxLength.class);
			return rk==null ? 99 : rk.value();
		}
		return null;
	}

	public String getFieldName() {
		return field.getName();
	}

	public JavaClass getClazz() {
		return clazz;
	}

	public String getJavaType() {
		return field.getType().getName();
	}

	public String getJdbcType(){
		return _types.keySet().contains(getJavaType()) ? _types.get(getJavaType()) : getJavaType();
	}

	public String getAsType() {
		return ActionScriptDataTypesUtils.getPreferredAsType(getJavaType());
	}

	public Annotation[] getAnnotations() {
		return field.getAnnotations();
	}

	public boolean getIsDateTimeField() {
		return  getJavaType().equalsIgnoreCase("java.util.Date")
				|| getJavaType().equalsIgnoreCase("java.sql.Date")
				|| getJavaType().equalsIgnoreCase("java.sql.Timestamp")
				|| getJavaType().equalsIgnoreCase("java.sql.Time");
	}
	
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((field == null) ? 0 : field.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JavaField other = (JavaField) obj;
        if (field == null) {
            if (other.field != null)
                return false;
        } else if (!field.equals(other.field))
            return false;
        return true;
    }

    public String toString() {
		return "JavaClass:"+clazz+" JavaField:"+getFieldName();
	}
}
