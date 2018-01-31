package Service;

import Model.ServiceArea;
import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class ServiceAreaRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException {
        ServiceArea s = new ServiceArea();
	s.setAreaId(rs.getInt(1));
	s.setName(rs.getString(2));
        s.setAreaCode(rs.getInt(3));
        s.setPackageId(rs.getInt(4));
        s.setTaxRate(rs.getDouble(5));
	return s;
    }     
}