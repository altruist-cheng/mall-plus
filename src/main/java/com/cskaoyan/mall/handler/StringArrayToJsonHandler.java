package com.cskaoyan.mall.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@MappedTypes(String[].class)
public class StringArrayToJsonHandler implements TypeHandler<String[]> {
    ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType){
        String s = objectMapper.writeValueAsString(strings);
        preparedStatement.setString(i, s);
    }

    @SneakyThrows
    @Override
    public String[] getResult(ResultSet resultSet, String s){
        String value = resultSet.getString(s);
        String[] strings = objectMapper.readValue(value, String[].class);
        return strings;
    }

    @SneakyThrows
    @Override
    public String[] getResult(ResultSet resultSet, int i) {
        String value = resultSet.getString(i);
        String[] strings = objectMapper.readValue(value, String[].class);
        return strings;
    }

    @SneakyThrows
    @Override
    public String[] getResult(CallableStatement callableStatement, int i){
        String value = callableStatement.getString(i);
        String[] strings = objectMapper.readValue(value, String[].class);
        return strings;
    }
}
