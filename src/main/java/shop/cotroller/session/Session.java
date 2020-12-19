package shop.cotroller.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import shop.service.SessionObj;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Component
public class Session {
 private List<SessionObj> list = new ArrayList<>();

    public Session() {
    }

    private void addSessionObj(SessionObj sessionObj){
        list.add(sessionObj);
    }

    public void addOrIncrementQuantity(SessionObj checkObj){
        if (list.contains(checkObj)){
            int id = list.indexOf(checkObj);
            int quantity =  list.get(id).getQuantity();
            list.get(id).setQuantity(quantity + 1);
        }else{
            addSessionObj(checkObj);
        }
    }

    public List<SessionObj> getList() {
        return list;
    }

    public void setList(List<SessionObj> list) {
        this.list = list;
    }

}
