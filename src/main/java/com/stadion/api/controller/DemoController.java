package com.stadion.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class DemoController {
	@GetMapping(path="/")
	public String RootController()
	{
		return "root page";
	}
	@GetMapping(path="/index")
	public int IndexController()
	{
		return 10;
	}

	@ApiOperation(
	        value = "value?"
	        , notes = "tips?.")
	@RequestMapping(value ="/demo", method = RequestMethod.GET)
	public String DemoController()
	{
		return "demo page";
	}

}
