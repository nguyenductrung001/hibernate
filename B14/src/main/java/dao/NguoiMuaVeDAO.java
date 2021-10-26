package dao;

import dto.NguoiMuaVeDto;
import entity.NguoiMuaVe;

import java.util.ArrayList;
import java.util.List;

public interface NguoiMuaVeDAO {
    List<NguoiMuaVe> getAll();

    NguoiMuaVe findById(int id);

    boolean addNew(List<NguoiMuaVe> nguoiMuaVes);

    boolean updateNguoiMuaVe(NguoiMuaVe nguoiMuaVe);

    boolean deleteNguoiMuaVe(NguoiMuaVe nguoiMuaVe);

    List<NguoiMuaVeDto> getAllNguoiMuaVeDto();
}
