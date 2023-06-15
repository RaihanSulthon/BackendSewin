package com.Sewin.Sewin3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Sewin.Sewin3.Model.Tailor;
import com.Sewin.Sewin3.Service.TailorService;

@Controller
public class TailorController {
	
	private TailorService tailorService;

	public TailorController(TailorService tailorService) {
		super();
		this.tailorService = tailorService;
	}
	
	@GetMapping("/tailors")
	public String listTailors(Model model) {
		model.addAttribute("tailors", tailorService.getAllTailors());
		return "Tailor";
	}
	
	@GetMapping("/tailors/new")
	public String createTailorForm(Model model) {
		Tailor tailor = new Tailor();
		model.addAttribute("tailor", tailor);
		return "Tailor_create";
	}
	
	@PostMapping("/tailors")
	public String saveTailor(@ModelAttribute("tailor") Tailor tailor) {
		tailorService.saveTailor(tailor);
		return "redirect:/tailors";
	}
	
	@GetMapping("/tailors/edit/{id}")
	public String editTailorForm(@PathVariable Long id, Model model) {
		model.addAttribute("tailor", tailorService.getTailorById(id));
		return "Tailor_edit";
	}

	@PostMapping("/tailors/{id}")
	public String updateTailor(@PathVariable Long id,
			@ModelAttribute("tailor") Tailor tailor,
			Model model) {
		Tailor existingTailor = tailorService.getTailorById(id);
		existingTailor.setId(id);
		existingTailor.setFirstName(tailor.getFirstName());
		existingTailor.setLastName(tailor.getLastName());
		existingTailor.setEmail(tailor.getEmail());
		existingTailor.setAddress(tailor.getAddress());
		existingTailor.setPhoneNumber(tailor.getPhoneNumber());
		tailorService.updateTailor(existingTailor);
		return "redirect:/tailors";
	}
	
	@GetMapping("/tailors/{id}")
	public String deleteTailor(@PathVariable Long id) {
		tailorService.deleteTailorById(id);
		return "redirect:/tailors";
	}
	
}
