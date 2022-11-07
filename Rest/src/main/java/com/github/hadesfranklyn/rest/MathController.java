package com.github.hadesfranklyn.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.hadesfranklyn.rest.exception.UnsupportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);

		return sum;
	}

	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		Double subtraction = convertToDouble(numberOne) - convertToDouble(numberTwo);

		return subtraction;
	}

	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		Double multiplication = convertToDouble(numberOne) * convertToDouble(numberTwo);

		return multiplication;
	}

	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);

		return division;
	}

	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		Double mean = convertToDouble(numberOne) + convertToDouble(numberTwo) / 2;

		return mean;
	}

	@RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("numberOne") String numberOne) throws Exception {
		if (!isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		Double squareRoot = (Double) Math.sqrt(convertToDouble(numberOne));

		return squareRoot;
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		String number = strNumber.replaceAll(",", ".");

		if (isNumeric(number))
			return Double.parseDouble(number);

		return 1D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
