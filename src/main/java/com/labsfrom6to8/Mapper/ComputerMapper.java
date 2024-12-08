package com.labsfrom6to8.Mapper;

import com.labsfrom6to8.Model.Computer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ComputerMapper {

    @Insert("INSERT INTO computers (brand, model, processor, ram, storage, is_available) VALUES (#{brand}, #{model}, #{processor}, #{ram}, #{storage}, #{isAvailable})")
    void insertComputer(Computer computer);

    @Update("UPDATE computers SET brand = #{brand}, model = #{model}, processor = #{processor}, ram = #{ram}, storage = #{storage}, is_available = #{isAvailable} WHERE id = #{id}")
    void updateComputer(Computer computer);

    @Select("SELECT * FROM computers")
    @Results({
            @Result(property = "isAvailable", column = "is_available")
    })
    List<Computer> selectAllComputers();

    @Delete("DELETE FROM computers WHERE id = #{id}")
    void deleteComputer(Long id);
}
