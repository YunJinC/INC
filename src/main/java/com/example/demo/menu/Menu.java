package com.example.demo.menu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String menu_name;
	private int price;

    public Menu() {
        super();
    }

    public Menu(Long id, String menu_name, int price) {
        super();
        this.id = id;
        this.menu_name = menu_name;
        this.price = price;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", menu_name=" + menu_name + ", price=" + price + "]";
	}

}
