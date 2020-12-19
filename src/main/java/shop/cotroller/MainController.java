package shop.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.cotroller.session.Session;
import shop.models.Product;
import shop.service.ProductService;
import shop.service.SessionObj;

@RestController
public class MainController {

    @Autowired
    private Session session;
    @Autowired
    private ProductService productService;


    @GetMapping("/catalog")
    public Iterable<Product> getAll(Model model){
        Iterable<Product> list = productService.returnAll();
        model.addAttribute("list",list);
        return list;
    }

    @GetMapping("/catalog/{purpose}")
    public Iterable<Product> filterGender( @PathVariable String purpose, Model model){
        Iterable<Product> list = productService.filterByPurpose(purpose);
        model.addAttribute("list",list);
        return list;
    }

    @PostMapping("/basket")
    public void session(@RequestBody SessionObj sessionObj){
        session.addOrIncrementQuantity(sessionObj);
    }

    @GetMapping("/basket")
    public String getBasket(){
        String json = productService.createJSON(session);
        return json;
    }
}
