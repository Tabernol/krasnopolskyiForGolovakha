package com.krasnopolskyi.krasnopolskyiforgolovakha.data;

import com.krasnopolskyi.krasnopolskyiforgolovakha.entity.MyNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MyNumberRepositoryImpl implements MyNumberRepository {
    private final String GET_COUNT = "SELECT count FROM my_number WHERE id =1";
    private final String UPDATE_COUNTER = "UPDATE my_number SET count = ? WHERE id = 1";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<MyNumber> getCount() {
        MyNumber myNumber = new MyNumber();
        return Optional.ofNullable(jdbcTemplate.query(GET_COUNT, (rs) -> {
            rs.next();
            myNumber.setCount(rs.getInt("count"));
            myNumber.setId(rs.getInt("id"));
            return myNumber;
        }));
    }

    @Override
    public void saveCounter(Integer count) {
        jdbcTemplate.update(UPDATE_COUNTER, (ps -> ps.setInt(1, count)));
    }
}
