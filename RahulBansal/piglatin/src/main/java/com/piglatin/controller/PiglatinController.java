package com.piglatin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piglatin.service.PigLatinService;

@RestController()
public class PiglatinController {

	@Autowired
	private PigLatinService pigLatinService;

	@RequestMapping(value = "/piglatin", method = RequestMethod.GET)
	public ResponseEntity<String> translateInLatin(@RequestParam(required = true) String sentence) {
		return new ResponseEntity<String>(pigLatinService.translateInLatin(sentence), HttpStatus.OK);
	}

}
