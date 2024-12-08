package com.labsfrom6to8.Service;

import com.labsfrom6to8.Mapper.ComputerMapper;
import com.labsfrom6to8.Model.Computer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {

    private final ComputerMapper computerMapper;

    public ComputerService(ComputerMapper computerMapper) {
        this.computerMapper = computerMapper;
    }

    public void addComputer(Computer computer) {
        computerMapper.insertComputer(computer);
    }

    public void updateComputer(Computer computer) {
        computerMapper.updateComputer(computer);
    }

    public List<Computer> getAllComputers() {
        return computerMapper.selectAllComputers();
    }

    public void deleteComputerById(Long id) {
        computerMapper.deleteComputer(id);
    }
}
