package shop.service;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SessionObj {

    private String article;
    private int quantity;

    public SessionObj() {
        quantity = 1;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionObj that = (SessionObj) o;
        return Objects.equals(article, that.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, quantity);
    }

    @Override
    public String toString() {
        return "SessionObj{" +
                "article='" + article + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
