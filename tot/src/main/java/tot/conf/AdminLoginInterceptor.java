package tot.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(AdminLoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String admin = (String) session.getAttribute("admin");

		// 로그인 페이지 요청 시 리디렉션 방지
		String requestURI = request.getRequestURI();
		if (requestURI.equals("/tot/admin/adminLogin")) {
			return true; // 로그인 페이지 요청은 그대로 허용
		}

		logger.info("Interceptor - Session user: {}", admin);

		if (admin == null) {
			logger.info("User not logged in. Redirecting to login page.");
			response.sendRedirect("/tot/admin/adminLogin");
			return false;
		}

		return true;
	}

}
