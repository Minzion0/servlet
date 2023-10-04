package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송기능
 * http:/localhost:8080/request-param?username=hello&age=20
 * **/
@WebServlet(name = "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회 시작]");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName-> System.out.println(paramName+"="+request.getParameter(paramName)));
                //                                      쿼리 파라미터어의 키값            키값으로 찾아낸 벨류값

        System.out.println("[전체 파라미터 조회 끝]");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("age = " + age);
        System.out.println("username = " + username);
        System.out.println();

        System.out.println("[이름이같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");

        for (String name : usernames) {
            System.out.println("userName = " + name);
        }

        response.getWriter().write("ok");
    }
}
