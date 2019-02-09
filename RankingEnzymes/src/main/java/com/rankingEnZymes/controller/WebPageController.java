package com.rankingEnZymes.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.rankingEnZymes.model.RegisterBean;
import com.rankingEnZymes.model.UserBean;
import com.rankingEnZymes.service.LoginService;
import com.rankingEnZymes.service.RegisterService;

@ComponentScan(basePackages = "com")
@Controller
public class WebPageController {
	@Autowired
	LoginService loginService;

	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ind() {
		return "about";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable String id) {
		return id;
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.GET)
	public String toLogin(Model model) {
		model.addAttribute("userBean", new UserBean());
		return "landInLogin";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false); // Fetch session object
		if (session != null) // If session is not null
		{
			session.invalidate(); // removes all session attributes bound to the session
			request.setAttribute("errMessage", "You have logged out successfully");
		}
		return "login";
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("landInLogin");
		String userName = request.getParameter("loginUserId");
		String password = request.getParameter("loginPassword");
		if (userName.isEmpty() || userName == null) {

			return new ModelAndView("landInLogin");

		}
		if (password.isEmpty() || password == null) {

			return new ModelAndView("landInLogin");

		}

		if (validate(userName, password)) {
			view.setViewName("home");
		}
		return view;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, Model model) {
		String userName = request.getParameter("registerUserId");
		String password = request.getParameter("registerPassword");
		String name = request.getParameter("registerName");
		String email = request.getParameter("registerEmail");
		if (userName.isEmpty() || userName == null) {

			return new ModelAndView("landInLogin");

		}
		if (password.isEmpty() || password == null) {

			return new ModelAndView("landInLogin");

		}
		if (name.isEmpty() || name == null) {

			return new ModelAndView("landInLogin");

		}
		if (email.isEmpty() || email == null) {

			return new ModelAndView("landInLogin");

		}
		RegisterBean entity = new RegisterBean();
		UserBean userBean = new UserBean();
		userBean.setPassword(password);
		userBean.setUserId(userName);
		model.addAttribute("userBean", userBean);
		model.addAttribute("registerBean", entity);
		entity.setEmail(email);
		entity.setName(name);
		entity.setPassword(password);
		entity.setUserId(userName);
		if (validate(userName, password)) {
			return new ModelAndView("landInLogin");
		} else {
			registerService.save(entity);
			loginService.save(userBean);
			return new ModelAndView("home");
		}
	}

	private boolean validate(String userName, String password) {
		UserBean userBean = new UserBean();
		userBean.setUserId(userName);
		userBean.setPassword(password);
		return loginService.authenticateUser(userBean);
	}

	@RequestMapping(value = "/metadataRest", method = RequestMethod.GET)
	public ModelAndView metadataRest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("landInLogin");
		String userName = request.getParameter("loginUserId");
		String password = request.getParameter("loginPassword");
		if (validate(userName, password)) {
			view.setViewName("homePage");
		}
		return view;
	}

	@RequestMapping(value = "/fetchCAZymesData", method = RequestMethod.GET)
	public ModelAndView fetchCAZymesData(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("landInLogin");
		view.setViewName("home");
		return view;
	}

	@RequestMapping(value = "/fetchFungiData", method = RequestMethod.GET)
	public ModelAndView fetchFungiData(HttpServletRequest request, HttpServletResponse response) {
		String input = request.getParameter("myInput");
		String password = request.getParameter("registerPassword");
		String name = request.getParameter("registerName");
		String email = request.getParameter("registerEmail");
		ModelAndView view = new ModelAndView("landInLogin");
		view.setViewName("home");
		return view;
	}

	@RequestMapping(value = "/cAzymesRest", method = RequestMethod.GET)
	public ModelAndView cAzymesRest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("landInLogin");
		String userName = request.getParameter("loginUserId");
		String password = request.getParameter("loginPassword");
		if (validate(userName, password)) {
			view.setViewName("home");
		}
		return view;
	}

	@RequestMapping(value = "/rankFungiCAZymesRest", method = RequestMethod.GET)
	public ModelAndView rankFungiCAZymesRest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("landInLogin");
		String userName = request.getParameter("loginUserId");
		String password = request.getParameter("loginPassword");
		if (validate(userName, password)) {
			view.setViewName("home");
		}
		return view;
	}

	@RequestMapping(value = "/downloadClassifiers", method = RequestMethod.GET)
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = System.getProperty("user.dir") + "\\Final_CAZymes.xlsx";
		File file = new File(path);
		// File file = new File("/Final_CAZymes.xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		if (!file.exists()) {
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}

		System.out.println("mimetype : " + mimeType);

		response.setContentType(mimeType);

		/*
		 * "Content-Disposition : inline" will show viewable types [like
		 * images/text/pdf/anything viewable by browser] right on browser while
		 * others(zip e.g) will be directly downloaded [may provide save as popup, based
		 * on your browser setting.]
		 */
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

		/*
		 * "Content-Disposition : attachment" will be directly download, may provide
		 * save as popup, based on your browser setting
		 */
		// response.setHeader("Content-Disposition", String.format("attachment;
		// filename=\"%s\"", file.getName()));

		response.setContentLength((int) file.length());

		// Copy bytes from source to destination(outputstream in this example), closes
		// both streams.
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

	@RequestMapping(value = "/downloadFungiSheet", method = RequestMethod.GET)
	public void downloadFungiSheet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String path = System.getProperty("user.dir") + "\\Ranking Fungi_CAZymes.xlsx";
		System.out.println(path);
		File file = new File(path);
		// File file = new File("/Final_CAZymes.xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		if (!file.exists()) {
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}

		System.out.println("mimetype : " + mimeType);

		response.setContentType(mimeType);

		/*
		 * "Content-Disposition : inline" will show viewable types [like
		 * images/text/pdf/anything viewable by browser] right on browser while
		 * others(zip e.g) will be directly downloaded [may provide save as popup, based
		 * on your browser setting.]
		 */
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

		/*
		 * "Content-Disposition : attachment" will be directly download, may provide
		 * save as popup, based on your browser setting
		 */
		// response.setHeader("Content-Disposition", String.format("attachment;
		// filename=\"%s\"", file.getName()));

		response.setContentLength((int) file.length());

		// Copy bytes from source to destination(outputstream in this example), closes
		// both streams.
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

	@RequestMapping(value = "/searchCazymes", method = RequestMethod.GET)
	public String testSearchCazymes() {
		return "rankCAZymes";
	}

	@RequestMapping(value = "/searchFungiCazymes", method = RequestMethod.GET)
	public String testSearchCazymessearchFungiCazymes() {
		return "rankFungiCAZymes";
	}

	@RequestMapping(value = "/pageSearchCazymes", method = RequestMethod.GET)
	public String pageSearchCazymes() {
		return "pageRankCAZymes";
	}

	@RequestMapping(value = "/pageSearchFungiCazymes", method = RequestMethod.GET)
	public String pageSearchFungiCazymes() {
		return "pageRankFungiCAZymes";
	}

	@RequestMapping(value = "/pageSearchCazymes", method = RequestMethod.POST)
	public ModelAndView pageSearchCazymes(HttpServletRequest request, HttpServletResponse response) {
		String searchCriteria = request.getParameter("searchCriteria");
		String cAzymes = request.getParameter("cAzymes");
		System.out.println(searchCriteria);
		System.out.println(cAzymes);
		String json = "";// gson.toJson(employeeService.listEmployeess());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(json);

		return modelAndView;
	}

	@RequestMapping(value = "/pageSearchFungiCazymes", method = RequestMethod.POST)
	public ModelAndView pageSearchFungiCazymes(HttpServletRequest request, HttpServletResponse response) {

		String orderCriteria = request.getParameter("orderCriteria");
		String classifer = request.getParameter("classifer");
		System.out.println(orderCriteria);
		System.out.println(classifer);
		Gson gson = new Gson();
		String json = "";// gson.toJson(employeeService.listEmployeess());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(json);

		return modelAndView;
	}

}