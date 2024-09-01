package br.com.mateusandrade.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.mateusandrade.converters.NumberConverter;
import br.com.mateusandrade.exceptions.UnsupportedMathOperationException;
import br.com.mateusandrade.math.SimpleMath;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {
  private SimpleMath math = new SimpleMath();

  @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

    
  @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double multi(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return math.multi(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  
  @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double mean(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @RequestMapping(value = "/sqrt/{number}", method=RequestMethod.GET)
  public Double sqrt(@PathVariable String number) throws Exception{
    if (!NumberConverter.isNumeric(number)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return math.sqrt(NumberConverter.convertToDouble(number));
  }
}
