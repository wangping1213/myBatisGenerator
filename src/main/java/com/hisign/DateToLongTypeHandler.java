package com.hisign;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 将数据库中的Date转为java中的Long类型
 * @author Administrator
 *
 */
public class DateToLongTypeHandler extends BaseTypeHandler<Long> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			Long parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ps.setTimestamp(i, new Timestamp(parameter));
	}

	@Override
	public Long getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		// TODO Auto-generated method stub
		Timestamp sqlTimestamp = rs.getTimestamp(columnName);
	    if (sqlTimestamp != null) {
	      return sqlTimestamp.getTime();
	    }
	    return null;
	}

	@Override
	public Long getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		Timestamp sqlTimestamp = rs.getTimestamp(columnIndex);
	    if (sqlTimestamp != null) {
	      return sqlTimestamp.getTime();
	    }
	    return null;
	}

	@Override
	public Long getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		Timestamp sqlTimestamp = cs.getTimestamp(columnIndex);
	    if (sqlTimestamp != null) {
	      return sqlTimestamp.getTime();
	    }
	    return null;
	}

	 
}