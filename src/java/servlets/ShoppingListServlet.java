
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author meeye
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("username");
        String action = request.getParameter("action");
        
        if (action != null)   {
            switch (action) {
                case "register":
                    register(request, response);
                    break;
                case "add":
                    addItems(request, response);
                    break;
                case "delete":
                    deleteItems(request, response);
                    break;
                case "logout":
                    logout(request, response);
                    break;
            }
        } else if (username != null) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            
        } else  {
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request, response);
        
    }
    
    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException     {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        ArrayList<String> items = new ArrayList<String>();
        
        session.setAttribute("items", items);
        session.setAttribute("username", username);
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException     {
        
        HttpSession session = request.getSession();
        
        session.invalidate();
        session = request.getSession();
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

    }
    
    private void addItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException     {
        
        HttpSession session = request.getSession();
        
        String item = request.getParameter("item");
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        
        items.add(item);

        session.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
    
    private void deleteItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        
        HttpSession session = request.getSession();
        
        try {
            String basket = request.getParameter("basket");
            int index = Integer.parseInt(basket);

            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            items.remove(index);

            session.setAttribute("items", items);

        } catch(NullPointerException e) {
            
        } finally   {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
  
    }
 
}
