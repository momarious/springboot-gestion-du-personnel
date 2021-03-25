package com.momarious.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Identifiant ou mot de passe incorrect. Veuillez réessayer");

		if (logout != null) {
			model.addAttribute("message", "Vous avez été déconnecté avec succès");
		}

		return "index";
	}
}
