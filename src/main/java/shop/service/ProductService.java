package shop.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.cotroller.session.Session;
import shop.models.Product;
import shop.repos.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Iterable<Product> returnAll(){
        return productRepo.findAll();
    }

    public Iterable<Product> filterByPurpose(String purpose){
        return productRepo.findByPurpose(purpose);
    }

    public String createJSON(Session session){
        JSONObject jsonObjectMain = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        if (session.getList().isEmpty()){
            return jsonObjectMain.toString();
        }
        for(SessionObj sessionObj: session.getList()){
            Product product = productRepo.findByArticle(sessionObj.getArticle());
            JSONObject jsonObject = new JSONObject(product);
            jsonObject.put("quantity",String.valueOf(sessionObj.getQuantity()));
            jsonArray.put(jsonObject);
        }
       //jsonObjectMain.put("",jsonArray);
        return
               jsonArray.toString();
               //jsonObjectMain.toString();
    }
}
