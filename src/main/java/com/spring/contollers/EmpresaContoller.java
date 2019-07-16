package com.spring.contollers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.EmpresaDTO;
import com.spring.responses.Response;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaContoller {

	@GetMapping(value = "/{nome}")
	public String mGet(@PathVariable("nome") String nome) {
		return ResponseEntity.ok("Sucesso").toString();
	}

	@PostMapping
	public ResponseEntity<Response<EmpresaDTO>> cadastrar(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult result) {
		Response<EmpresaDTO> response = new Response<EmpresaDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDTO.setId(1L);
		response.setData(empresaDTO);
		
		return ResponseEntity.ok(response);
	}
}
