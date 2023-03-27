package dev.wpei.typehandler.entity.typehandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.wpei.typehandler.domain.Representative;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@MappedTypes(List.class)
@Alias("RepresentativeTypeHandler")
public class RepresentativeTypeHandler extends BaseTypeHandler<List<Representative>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Representative> parameter, JdbcType jdbcType) throws SQLException {

        ObjectMapper mapper = new ObjectMapper();
        try {
            String result = mapper.writeValueAsString(parameter);
            ps.setString(i, result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Representative> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (value == null) return null;
        return Representative.of(value);
    }

    @Override
    public List<Representative> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if (value == null) return null;
        return Representative.of(value);
    }

    @Override
    public List<Representative> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if (value == null) return null;
        return Representative.of(value);
    }
}

