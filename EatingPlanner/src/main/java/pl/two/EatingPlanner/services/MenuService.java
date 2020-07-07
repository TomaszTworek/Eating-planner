package pl.two.EatingPlanner.services;

import org.springframework.stereotype.Service;
import pl.two.EatingPlanner.models.Menu;
import pl.two.EatingPlanner.repository.MenuRepository;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }

    public Menu findByName(String name) {
        return menuRepository.findByName(name);
    }
}
