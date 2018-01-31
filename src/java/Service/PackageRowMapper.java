package Service;

import Model.Package;
import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class PackageRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException {
        Package p = new Package();
	p.setPackageId(rs.getInt(1));
	p.setName(rs.getString(2));
        p.setDescription(rs.getString(3));
        p.setMealCategory(rs.getString(4));
        p.setImageSource(rs.getString(5));
        p.setPrice(rs.getDouble(6));
        p.setIsSpecial(rs.getString(7));
        p.setMealType(rs.getString(8));
	return p;
    }     
}