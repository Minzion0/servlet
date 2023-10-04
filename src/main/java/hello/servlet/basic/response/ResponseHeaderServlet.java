package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    //응답 셋팅
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);//성공 200과 같다

        //[response-header]
        response.setHeader("Content-Type","text/plain;charset=utf-8");
        response.setHeader("Cache-Control","no-cach,no-store,must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setHeader("my-header","hello");

        //header 쿠키
        cookie(response);
        //타입
        content(response);

        redirect(response);

        //response.getWriter().write("ok");


    }
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }
    /**리다이렉트**/
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

   //     response.setStatus(HttpServletResponse.SC_FOUND); //302
     //   response.setHeader("Location", "/basic/hello-form.html");

         response.sendRedirect("/basic/hello-form.html");
         //위 처럼 따로 따로 선언 하는것이 아니라 sendRedirect 로 돌아가기 원하는 주소만 적어주면 redirect로 이동할수있다
    }
}
