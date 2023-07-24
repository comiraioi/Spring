package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.Dto.PDto;

public interface PCommand {
	void execute(Model model);
}
