package com.labsfrom6to8.Controller;

import com.labsfrom6to8.Model.Computer;
import com.labsfrom6to8.Service.ComputerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computers")
@Tag(name = "Computer API", description = "API для управления компьютерами")
public class ComputerController {

    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @PostMapping
    @Operation(summary = "Добавить новый компьютер", description = "Добавляет новый компьютер в систему")
    public void addComputer(@RequestBody Computer computer) {
        computerService.addComputer(computer);
    }

    @PutMapping
    @Operation(summary = "Обновить компьютер", description = "Обновляет информацию о компьютере")
    public void updateComputer(@RequestBody Computer computer) {
        computerService.updateComputer(computer);
    }

    @GetMapping
    @Operation(summary = "Получить список всех компьютеров", description = "Возвращает список всех компьютеров в системе")
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить компьютер", description = "Удаляет компьютер по его идентификатору")
    public void deleteComputer(@PathVariable Long id) {
        computerService.deleteComputerById(id);
    }
}
