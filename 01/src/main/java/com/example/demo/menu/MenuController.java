package com.example.demo.menu;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuRepository menuRepository;

	@GetMapping()
	public List<Menu> getAllMenus() {
		return menuRepository.findAll();
	}

	@GetMapping("/{id}")
	public Menu getMenu(@PathVariable Long id) {
		Optional<Menu> menu = menuRepository.findById(id);


		return menu.get();
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		menuRepository.deleteById(id);
	}

	@PostMapping()
	public ResponseEntity<Object> createMenu(@RequestBody Menu menu) {
		Menu savedMenu = menuRepository.save(menu);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedMenu.getMenu_name()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Menu menu, @PathVariable Long id) {

		Optional<Menu> studentOptional = menuRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		menu.setId(id);
		
		menuRepository.save(menu);

		return ResponseEntity.noContent().build();
	}

}
