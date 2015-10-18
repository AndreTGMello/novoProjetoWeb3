package each.usp.ach2006.eler;

import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import static org.junit.Assert.assertEquals;

public class RecipeTest {
	/* Testa a criação de uma receita */
	
	/* Segundo especificação:
	 * Na classe RecipeTest devem ser escritos os casos de teste para testar as operações da
	 * classe Recipe. Em particular, deve-se testar apenas a criação de uma receita por meio de seu construtor.
	 */
	public RecipeTest() {
		
	}
	
	/* Testes para construtor - INICIO*/
	@Test (expected = InvalidValueException.class)
	public void testeNomeVazio() throws InvalidValueException {
		Recipe receita = new Recipe("",50,4,3,1,5);
		assertEquals(50,receita.getPrice());
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testePrecoNulo() throws InvalidValueException {
		Recipe receita = new Recipe("Coffee",0,4,3,1,5);
		assertEquals(0,receita.getPrice());
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testePrecoNegativo() throws InvalidValueException {
		Recipe receita = new Recipe("Coffee",-10,4,3,1,5);
		assertEquals(-10,receita.getPrice());
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testeAmtCoffeeNegativo() throws InvalidValueException {
		Recipe receita = new Recipe ("Coffee",50,-4,3,1,5);
		assertEquals(-4,receita.getAmtCoffee());
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testeAmtMilkNegativo() throws InvalidValueException {
		Recipe receita = new Recipe ("Coffee",50,4,-1,1,5);
		assertEquals(-1,receita.getAmtMilk());
	}
	
	@Test (expected = InvalidValueException.class)
	public void testeAmtSugarNegativo() throws InvalidValueException {
		Recipe receita = new Recipe ("Coffee",50,4,1,-3,5);
		assertEquals(-3,receita.getAmtSugar());
	}
	
	@Test (expected = InvalidValueException.class)
	public void testeAmtChocolateNegativo() throws InvalidValueException {
		Recipe receita = new Recipe ("Coffee",50,4,1,3,-4);
		assertEquals(-4,receita.getAmtChocolate());
	}
	
	@Test 
	public void testeSemCafe() throws InvalidValueException {
		Recipe receita = new Recipe ("Coffee",50,0,1,3,5);
		assertEquals(50,receita.getPrice());
	}
	
	@Test 
	public void testeSemLeite() throws InvalidValueException {
		Recipe receita = new Recipe ("Coffee",50,4,0,3,5);
		assertEquals(50,receita.getPrice());
	}
	
	@Test 
	public void testeSemAcucar() throws InvalidValueException {
		Recipe receita = new Recipe ("Coffee",50,4,1,0,5);
		assertEquals(50,receita.getPrice());
	}
	
	@Test 
	public void testeSemChocolate() throws InvalidValueException {
		Recipe receita = new Recipe ("Coffee",50,4,1,3,0);
		assertEquals(50,receita.getPrice());
	}
	
	@Test
	public void testeSemDoisIngredientes() throws InvalidValueException{
		Recipe receita = new Recipe("Coffee",50,4,0,1,0);
		//Se não lançar exceção é porque a receita foi criada
		assertEquals(50,receita.getPrice());
	}
	
	@Test 
	public void testeSemTresIngredientes() throws InvalidValueException{
		Recipe receita = new Recipe("Coffee",50,0,0,1,0);
		assertEquals(50,receita.getPrice());
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testeNenhumIngrediente() throws InvalidValueException {
		Recipe receita = new Recipe("Coffee",50,0,0,0,0);
		assertEquals(50,receita.getPrice());
	}
	/* Testes para construtor - FIM */
}