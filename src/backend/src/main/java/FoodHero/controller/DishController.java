package FoodHero.controller;

import FoodHero.model.Dish;
import FoodHero.service.Dish.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:13000")
@RequestMapping("/dish")
public class DishController {
    @Autowired
    DishService dishService;

    @PostMapping(value = "/")
    public ResponseEntity<Object> createProduct(@RequestBody Dish dish) {
        dishService.createDish(dish);
        return new ResponseEntity<>("Dish created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody Dish dish) {
        dishService.updateDish(dish);
        return new ResponseEntity<>("Dish updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        dishService.deleteDish(id);
        return new ResponseEntity<>("Dish deleted successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> getDish(@PathVariable("id") int id) {
        Optional<Dish> dish = dishService.getDish(id);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<Object> getDishes() {
        return new ResponseEntity<>(dishService.getDishes(), HttpStatus.OK);
    }
}