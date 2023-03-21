package dev.wpei.typehandler.entity.typehandler;

import dev.wpei.typehandler.domain.Representative;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Representative.class)
@Alias("RepresentativeTypeHandler")
public class RepresentativeTypeHandler extends BaseTypeHandler<Representative> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Representative parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toJson());
    }

    @Override
    public Representative getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (value == null) return null;
        return Representative.of(value);
    }

    @Override
    public Representative getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if (value == null) return null;
        return Representative.of(value);
    }

    @Override
    public Representative getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if (value == null) return null;
        return Representative.of(value);
    }
}

