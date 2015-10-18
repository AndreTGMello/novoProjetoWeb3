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
		receitaValida4 = new Recipe("Cafe Frio",55,5,0,1,0);
		receitaNomeRepetido1 = new Recipe("Cafe Extra",50,5,1,2,1);
		receitaIngradientesRepetidos1 = new Recipe("Cafe",50,4,0,1,0);
	}
	
	
	/* Testes para addRecipe - INICIO */
	
	@Test
	public void testaInsereUmaReceita() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(receitaValida1);
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
		boolean ok = CM.addRecipe(receitaValida1);
		ok = CM.addRecipe(receitaValida2);
		ok = CM.addRecipe(receitaValida3);
		ok = CM.addRecipe(receitaValida4);
		assertTrue(ok);
	}
	
	/* Testes para addRecipe - FIM */
	
	@Test
	public void testaRemoveReceitaValida() throws AmountOfRecipeException, DuplicatedRecipeException{
		
	}
	
	@Test
	public void testaRemoveReceitaInvalida() throws AmountOfRecipeException, DuplicatedRecipeException{
		
	}
	
	@Test
	public void testaInsereReceitaInvalida() throws AmountOfRecipeException, DuplicatedRecipeException{
		
	}
	

	
	
	
}