package br.com.mateusandrade;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;
import br.com.mateusandrade.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {
  private final AtomicLong counter = new AtomicLong();
  
  @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return convertToDouble(numberOne) + convertToDouble(numberTwo);
  }

    
  @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return convertToDouble(numberOne) - convertToDouble(numberTwo);
  }

  @RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double multi(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return convertToDouble(numberOne) * convertToDouble(numberTwo);
  }

  
  @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return convertToDouble(numberOne) / convertToDouble(numberTwo);
  }

  @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double mean(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
    if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
  }

  @RequestMapping(value = "/sqrt/{number}", method=RequestMethod.GET)
  public Double sqrt(@PathVariable String number) throws Exception{
    if (!isNumeric(number)){
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return Math.sqrt(convertToDouble(number));
  }

  private Double convertToDouble(String strNumber) {
    if(strNumber == null) return 0D;
    String number = strNumber.replaceAll(",", ".");
    if (isNumeric(number)) return Double.parseDouble(number);
    return 0D;
  }

  private boolean isNumeric(String strNumber) {
    if(strNumber == null) return false;
    String number = strNumber.replaceAll(",", ".");

    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
  }
}
