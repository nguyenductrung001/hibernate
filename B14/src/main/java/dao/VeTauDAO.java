package dao;

import dto.NguoiMuaVeDto;
import dto.VeTauDTO;
import entity.NguoiMuaVe;
import entity.VeTau;

import java.util.ArrayList;
import java.util.List;

public interface VeTauDAO {
    List<VeTau> getAll();

    VeTau findById(int id);

    boolean addNew(List<VeTau> veTaus);

    boolean updateVeTau(VeTau veTau);

    boolean deleteVeTau(VeTau veTau);

    List<VeTauDTO> getAllVeTauDTO();
}
