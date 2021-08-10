package com.cskaoyan.mall.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Integer[].class)
public class IntegerArrayToJsonHandler implements TypeHandler<Integer[]> {
    ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Integer[] integers, JdbcType jdbcType) throws SQLException {
        String s = objectMapper.writeValueAsString(integers);
        preparedStatement.setString(i, s);
    }

    @SneakyThrows
    @Override
    public Integer[] getResult(ResultSet resultSet, String s) throws SQLException {
        String value = resultSet.getString(s);
        Integer[] integers = objectMapper.readValue(value, Integer[].class);
        return integers;
    }

    @SneakyThrows
    @Override
    public Integer[] getResult(ResultSet resultSet, int i) throws SQLException {
        String value = resultSet.getString(i);
        Integer[] integers = objectMapper.readValue(value, Integer[].class);
        return integers;
    }

    @SneakyThrows
    @Override
    public Integer[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String value = callableStatement.getString(i);
        Integer[] integers = objectMapper.readValue(value, Integer[].class);
        return integers;
    }
}
