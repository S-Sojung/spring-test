package shop.mtcoding.test.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoradRepository { // CRUD
    public int insert(@Param("title") String title, @Param("userId") int userId);

    public List<Board> findAll();

    public Board findById(int id);

    public int updateById(@Param("title") int title);

    public int deleteById(int id);
}
