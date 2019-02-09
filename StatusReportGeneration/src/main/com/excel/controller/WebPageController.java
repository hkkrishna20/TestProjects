package com.excel.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@ComponentScan(basePackages = "com")
@Controller
public class WebPageController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ind() {
		return "login";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable String id) {
		return id;
	}
	
	@RequestMapping(value = "sendMail", method = RequestMethod.POST)
	void send(@RequestParam String toEmail, @RequestParam String ccEmail, @RequestParam String bccEmail,
			@RequestParam String fileName) throws IOException {
		if (toEmail == null)
			toEmail = "";
		if (ccEmail == null)
			ccEmail = "";
		if (bccEmail == null)
			bccEmail = "";
		if (ccEmail.trim().isEmpty() && bccEmail.trim().isEmpty() && toEmail.trim().isEmpty()) {
			return;
		}
		final String username = "encommpoc@gmail.com";
		final String password = "thunderhead";
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.googlemail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			String[] bccListArray = bccEmail.split(";");
			String[] ccListArray = ccEmail.split(";");
			String[] toListArray = toEmail.split(";");
			List<String> cclist = Arrays.asList(ccListArray);
			List<String> bcclist = Arrays.asList(bccListArray);
			List<String> tolist = Arrays.asList(bccListArray);

			if (!(ccEmail.trim().isEmpty())) {
				if (ccListArray != null && cclist.size() > 0) {
					final Address[] toCcAddress = new InternetAddress[cclist.size()];
					for (int i = 0; i < toCcAddress.length; i++) {
						toCcAddress[i] = new InternetAddress(cclist.get(i));
					}
					message.addRecipients(Message.RecipientType.CC, toCcAddress);
				}

			}
			if (!(bccEmail.trim().isEmpty())) {
				if (bccListArray != null && bcclist.size() > 0) {
					final Address[] tobCcAddress = new InternetAddress[bcclist.size()];
					for (int i = 0; i < tobCcAddress.length; i++) {
						tobCcAddress[i] = new InternetAddress(bcclist.get(i));
					}
					message.addRecipients(Message.RecipientType.BCC, tobCcAddress);
				}
			}
			if (!(toEmail.trim().isEmpty())) {
				if (toListArray != null && tolist.size() > 0) {
					final Address[] toAddress = new InternetAddress[tolist.size()];
					for (int i = 0; i < toAddress.length; i++) {
						toAddress[i] = new InternetAddress(tolist.get(i));
					}
					message.addRecipients(Message.RecipientType.TO, toAddress);
				}
			}
			message.setFrom(new InternetAddress("encommpoc@gmail.com"));
			message.setSubject("This is the Subject Line!");
			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("\"<h1>This is actual message</h1>\"", "utf-8", "html");
			multipart.addBodyPart(messageBodyPart);
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			if (fileName == null)
				attachmentBodyPart.attachFile(new File("C:\\Users\\Public\\POC Files\\actualFile.pdf"),
						"application/pdf", null);
			else
				attachmentBodyPart.attachFile(new File(fileName), "application/pdf", null);
			multipart.addBodyPart(attachmentBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
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
		return null;
		}

	private boolean validate(String userName, String password) {
		
		return true;
			//	loginService.authenticateUser(userBean);
	}

	

}