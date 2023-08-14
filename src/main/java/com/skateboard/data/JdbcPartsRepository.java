package com.skateboard.data;

import com.skateboard.DTO.Parts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository //데이터 엑세스 관련 스테레오 액세스 타입 지정으로 웹 MVC 컨트롤러임을 표시.
public class JdbcPartsRepository implements PartsRepository{
    //PartsRepository interface를 implements하여 메소드를 구현.(@Override)

    //JdbcPartsRepository 에서 사용 할 JdbcTemplate 인스턴스
    private JdbcTemplate jdbc;

    /*
    @Repository로 인하여 JdbcPartsRepository가 Bean에 등록이 된다면
    해당 Bean을 Autowired하여 자동 주입해준다.
    */
    @Autowired
    public JdbcPartsRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Parts> findAll() {
        /*
        쿼리문을 호출하고 리턴 받는 방법을 지정한다.
        JdbcTemplate.query 메서드에 첫 번째 인자로 호출 할 쿼리문을 기입하고,
        두 번째 인자로 리턴 받을 ResultSet을 맵핑할 오브젝트를 지정한다.
        현재는 mapRowToParts 라는 메서드를 생성하여 Parts DTO에 맵핑 될 수 있게 지정하였다.
        java8 에서의 메서드 참조와 lamda를 이용하여 mapRowToParts를 return하는게 간단하다.
        */
        return jdbc.query("select id, name, type from Parts",
                this::mapRowToParts);
    }

    @Override
    public Parts findById(String id) {
        /*
        findAll() 메서드에서 호출한 JdbcTemplate.query와 다르게
        JdbcTemplate.queryForObject를 호출한 이유는 findById는 ID값을 인자로 넘겨
        하나의 결과 값을 가져올 것이기 때문이다.
        3번째 인재로 준 id는 실행될 쿼리문에 ?에 해당하는 위치에 참조된다.
        JdbcTemplate.query는 여러개의 값을 가져올 때 사용한다.
        */
        return jdbc.queryForObject(
                "select id, name, type from Parts where id = ?",
                this::mapRowToParts, id);
    }

    @Override
    public Parts save(Parts parts) {
        jdbc.update(
        "insert into parts (id, name, type) values(?,?,?)",
            parts.getId(),
            parts.getName(),
            parts.getType().toString());
        return parts;
    }

    //쿼리 조회 후 받아올 Map 형태의 ResultSet을 DTO에 맞게 맵핑해주는 역할.
    private Parts mapRowToParts(ResultSet rs,int rowNum) throws SQLException {
        return new Parts(
                rs.getString("id"),
                rs.getString("name"),
                Parts.Type.valueOf(rs.getString("type"))
        );
    }
}
