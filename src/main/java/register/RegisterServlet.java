package register;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
    /**
     * @email Maulidabdullahi3@gmail.com
     */

    @WebServlet("/register")
    public class RegisterServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private RegisterDao registerDao;

        public void init() {
            registerDao = new RegisterDao();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            register(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.sendRedirect("register.jsp");
        }

        private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String fullname = request.getParameter("fullname");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            RegisterBean registerbean = new RegisterBean();
            registerbean.setFullName(fullname);
            registerbean.setEmail(email);
            registerbean.setUserName(username);
            registerbean.setPassword(password);

            registerDao.saveRegisterBean(registerbean);

            RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
            dispatcher.forward(request, response);
        }
    }

