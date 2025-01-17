package com.service.authorization.registeredClient

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class RegisteredClientController(
        private val registeredClientService: RegisteredClientService
) {
    @GetMapping("/register-clients")
    fun getView(model: Model): String {
        model.addAttribute("clients", registeredClientService.getAllBy().map { it.toView() })
        return "register-client/main"
    }

    @GetMapping("/register-clients/{id}")
    fun getDetailView(@PathVariable id: String, model: Model): String {
        model.addAttribute("client", registeredClientService.getBy(id).toDetalView())
        return "register-client/detail"
    }
}