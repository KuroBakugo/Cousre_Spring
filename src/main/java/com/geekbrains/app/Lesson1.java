package com.geekbrains.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "Lesson1", urlPatterns = "/les")
public class Lesson1 extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(Lesson1.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Молоко", 30));
        products.add(new Product(2, "Кефир", 40));
        products.add(new Product(3, "Сметана", 30));
        products.add(new Product(4, "Хлеб", 31));
        products.add(new Product(5, "Молоко", 41));
        products.add(new Product(6, "Кефир", 30));
        products.add(new Product(7, "Сметана", 356));
        products.add(new Product(8, "Хлеб", 3012));
        products.add(new Product(9, "Молоко", 3011));
        products.add(new Product(10, "Молоко", 3045));
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            Product product = products.get(i);
            resp.getWriter().printf("<h1>Продукт: " + product.getId() + " " + product.getTitle() + " " + product.getCost() +  "</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}