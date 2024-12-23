package models;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface KosMapper {

    @Select("SELECT * FROM koss")
    List<Kos> getAllKos();

    @Insert("INSERT INTO koss (nama, alamat, harga, status) VALUES (#{nama}, #{alamat}, #{harga}, #{status})")
    void insertKos(Kos kos);

    @Update("UPDATE koss SET nama = #{nama}, alamat = #{alamat}, harga = #{harga}, status = #{status} WHERE id = #{id}")
    void updateKos(Kos kos);

    @Delete("DELETE FROM koss WHERE id = #{id}")
    void deleteKos(int id);
}
