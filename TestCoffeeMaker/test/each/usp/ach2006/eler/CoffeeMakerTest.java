package each.usp.ach2006.eler;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.CoffeeMaker;
import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.AmountOfRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.DuplicatedRecipeException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest {
	
	/* Segundo especificação:
	 * Na classe CoffeeMakerTest devem ser escritos os casos de teste para testar as operações para adicionar receita,
	 * apagar receita, adicionar ingredientes, verificar quantidade de ingredientes, fazer café e obter receitas.
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
	 * Classes de equivalência:
	 * 
	 * Valores limites:
	 * 
	 * Casos de teste:
	 * 
	 */
	
	private CoffeeMaker CM;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	
	@Before
	public void setUp() throws Exception {
		CM = new CoffeeMaker();
		r1 = new Recipe("Coffee",50,4,0,1,0);
		r2 = new Recipe("Hot Chocolate",75,0,3,1,3);
		r3 = new Recipe("Cold Chocolate",55,0,3,1,3);
		r4 = new Recipe("Cold Coffee",55,5,0,1,0);
	}
	
	
	/* Testa adicionar uma receita */
	
	@Test
	public void testAddOneRecipe() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(r1);
		assertTrue(ok);
	}
	
//	@Test
//	public void testaInsereDuasReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
//		
//	}
//
//	@Test
//	public void testaInsereTresReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
//		
//	}
//	
	@Test
	public void testaInsereQuatroReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
		
	}
	
	@Test
	public void testaInsereReceitaInvalida() throws AmountOfRecipeException, DuplicatedRecipeException{
		
	}
	
	@Test
	public void testaRemoveReceitaValida() throws AmountOfRecipeException, DuplicatedRecipeException{
		
	}
	
	@Test
	public void testaRemoveReceitaInvalida() throws AmountOfRecipeException, DuplicatedRecipeException{
		
	}
	
	
	
}
