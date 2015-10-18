package each.usp.ach2006.eler;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.CoffeeMaker;
import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.AmountOfRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.DuplicatedRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InsufficientAmountOfMoneyException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InventoryException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.RecipeException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest {
	
	/* Segundo especifica��o:
	 * Na classe CoffeeMakerTest devem ser escritos os casos de teste para testar as opera��es para adicionar receita,
	 * apagar receita, adicionar ingredientes, verificar quantidade de ingredientes, fazer caf� e obter receitas.
	 */
	
	/* Classes a serem testadas:
	 * 
	 * boolean addRecipe(Recipe r) throws InvalidValueException
	 * 
	 * boolean deleteRecipe(String recipeName) throws RecipeException
	 * 
	 * void addCoffeeInventory(int amtCoffee) throws InvalidValueException
	 * 
	 * void addMilkInventory(int amtMilk) throws InvalidValueException
	 * 
	 * void addSugarInventory(int amtSugar) throws InvalidValueException
	 * 
	 * void addChocolateInventory(int amtChocolate) throws InvalidValueException
	 * 
	 * int checkCoffeeInventory()
	 * 
	 * int checkMilkInventory()
	 * 
	 * int checkSugarInventory()
	 * 
	 * int checkChocolateInventory()
	 * 
	 * int makeCoffee(String recipeName, int amtPaid) throws RecipeException, 
	 * InsufficientAmountOfMoneyException, InventoryException
	 * 
	 * Vector<Recipe> getRecipes()
	 * 
	 * Classes de equival�ncia:
	 * 
	 * Valores limites:
	 * 
	 * Casos de teste:
	 * 
	 */
	
	private CoffeeMaker CM;
	private Recipe receitaValida1;
	private Recipe receitaValida2;
	private Recipe receitaValida3;
	private Recipe receitaValida4;
	private Recipe receitaNomeRepetido1;
	private Recipe receitaIngradientesRepetidos1;
	
	@Before
	public void setUp() throws Exception {
		CM = new CoffeeMaker();
		receitaValida1 = new Recipe("Cafe",50,4,0,1,0);
		receitaValida2 = new Recipe("Chocolate Quente",75,0,3,1,3);
		receitaValida3 = new Recipe("Chocolate Frio",55,0,3,1,3);
		receitaValida4 = new Recipe("Cafe Fraco",25,1,0,0,0);
		receitaNomeRepetido1 = new Recipe("Cafe Extra",50,5,1,2,1);
		receitaIngradientesRepetidos1 = new Recipe("Cafe",50,4,0,1,0);
	}
	
	
	/* Testes para addRecipe - INICIO */
	
	@Test
	public void testaInsereUmaReceita() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(receitaValida1);
		assertTrue(ok);
	}

	@Test
	public void testaInsereQuatroReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(receitaValida1);
		ok = CM.addRecipe(receitaValida2);
		ok = CM.addRecipe(receitaValida3);
		ok = CM.addRecipe(receitaValida4);
		assertTrue(ok);
	}
	
	@Test
	public void testaInsereReceitaInvalida() throws AmountOfRecipeException, DuplicatedRecipeException{
		
	}
	
	/* Testes para addRecipe - FIM */
	
	
	/* Testes para deleteRecipe - INICIO */
	
	@Test
	public void testaRemoveReceitaValida() throws RecipeException, AmountOfRecipeException, DuplicatedRecipeException{
		CM.addRecipe(receitaValida1);
		boolean ok = CM.deleteRecipe("Cafe");
		assertEquals(true, ok);
	}
	
	@Test
	public void testaRemoveReceitaInvalida() throws AmountOfRecipeException, DuplicatedRecipeException, RecipeException{
		CM.addRecipe(receitaValida1);
		boolean ok = CM.deleteRecipe("Chocolate Quente");
		assertEquals(false, ok);
	}
	
	/* Testes para deleteRecipe - FIM */
	
	
	/* Testes para addCoffeeInventory - INICIO */
	
	@Test
	public void testaRepoeCafeValido() throws InvalidValueException{
		CM.addCoffeeInventory(1);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeCafeInvalido() throws InvalidValueException{
		CM.addCoffeeInventory(81);
	}
	
	/* Testes para addCoffeeInventory - FIM */
	
	
	/* Testes para addMilkInventory - INICIO */
	
	@Test
	public void testaRepoeLeiteValido() throws InvalidValueException{
		CM.addCoffeeInventory(1);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeLeiteInvalido() throws InvalidValueException{
		CM.addCoffeeInventory(81);
	}
	
	/* Testes para addMilkInventory - FIM */
	
	
	/* Testes para addSugarInventory - INICIO */
	
	@Test
	public void testaRepoeAcucarValido() throws InvalidValueException{
		CM.addCoffeeInventory(1);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeAcucarInvalido() throws InvalidValueException{
		CM.addCoffeeInventory(81);
	}
	
	/* Testes para addSugarInventory - FIM */
	
	
	/* Testes para addChocolateInventory - INICIO */
	
	@Test
	public void testaRepoeChocolateValido() throws InvalidValueException{
		CM.addCoffeeInventory(1);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeChocolateInvalido() throws InvalidValueException{
		CM.addCoffeeInventory(81);
	}
	
	/* Testes para addChocolateInventory - FIM */
	

	/* Testes para checkCoffeeInventory - INICIO */
	
	@Test
	public void testaInventorioCafe() throws Exception{
		int qtdCafe = CM.checkCoffeeInventory();
		assertEquals(20, qtdCafe);
	}
	
	/* Testes para checkCoffeeInventory - FIM */
	
	
	/* Testes para checkMilkInventory - INICIO */
	
	@Test
	public void testaInventorioLeite() throws Exception{
		int qtdCafe = CM.checkCoffeeInventory();
		assertEquals(20, qtdCafe);
	}
	
	/* Testes para checkMilkInventory - FIM */
	
	
	/* Testes para checkSugarInventory - INICIO */
	
	@Test
	public void testaInventorioAcucar() throws Exception{
		int qtdCafe = CM.checkCoffeeInventory();
		assertEquals(20, qtdCafe);
	}
	
	/* Testes para checkSugarInventory - FIM */
	
	
	/* Testes para checkChocolateInventory - INICIO */
	
	@Test
	public void testaInventorioChocolate() throws Exception{
		int qtdCafe = CM.checkCoffeeInventory();
		assertEquals(20, qtdCafe);
	}
	
	/* Testes para checkChocolateInventory - FIM */
	

	/* Testes para makeCoffee - INICIO */
	
	@Test
	public void testaFazerCafeSemTroco() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaValida1);
		int troco = CM.makeCoffee("Cafe", 50);
		assertEquals(0, troco);
	}
	
	@Test
	public void testaFazerCafeComTroco() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaValida1);
		int troco = CM.makeCoffee("Cafe", 100);
		assertEquals(50, troco);
	}
	
	@Test (expected = RecipeException.class)
	public void testaFazerCafeReceitaInexistente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaValida1);
		CM.makeCoffee("Chocolate Quente", 50);
	}

	@Test (expected = InsufficientAmountOfMoneyException.class)
	public void testaFazerCafeDinheiroInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaValida1);
		CM.makeCoffee("Cafe", 10);
	}

	@Test (expected = InventoryException.class)
	public void testaFazerCafeInventorioInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaValida4);
		/* Aqui utiliza-se a receitaValida4 para que seja possivel testar o valor limite 21 */
		for(int i = 0; i < 20; i++){
			CM.makeCoffee("Cafe Fraco", 25);
		}
	}
	
	/* Testes para makeCoffee - INICIO */
	
	
	
	/* Testes para makeCoffee - FIM */
	
	
	/* Testes para getRecipes - INICIO */
	
	
	
	/* Testes para getRecipes - FIM */

}