package each.usp.ach2006.eler;

import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
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
	 */
	
	private CoffeeMaker CM;
	private Recipe receitaValida1;
	private Recipe receitaValida2;
	private Recipe receitaValida3;
	private Recipe receitaValida4;
	private Recipe receitaNomeRepetido1;
	private Recipe receitaIngradientesRepetidos1;
	private Recipe receitaTestaInventarioCafe;
	private Recipe receitaTestaInventarioLeite;
	private Recipe receitaTestaInventarioAcucar;
	private Recipe receitaTestaInventarioChocolate;
	private int troco;
	
	@Before
	public void setUp() throws Exception {
		CM = new CoffeeMaker();
		receitaValida1 = new Recipe("Cafe",50,4,1,1,1);
		receitaValida2 = new Recipe("Chocolate Quente",75,1,3,1,3);
		receitaValida3 = new Recipe("Chocolate Frio",55,1,3,2,3);
		receitaValida4 = new Recipe("Cafe Fraco",25,1,1,1,1);
		receitaNomeRepetido1 = new Recipe("Cafe",50,5,1,2,1);
		receitaIngradientesRepetidos1 = new Recipe("Cafe Extra",50,4,1,1,1);
	
		/* Observação:
		 * Impossivel criar reeita com quantidade de açucar = 0.
		 */
		
		receitaTestaInventarioCafe = new Recipe ("Cafe Puro",1,1,0,1,0);
		receitaTestaInventarioLeite = new Recipe ("Leite Puro",1,0,1,1,0);
		receitaTestaInventarioAcucar = new Recipe ("Acucar Puro",1,0,0,1,0);
		receitaTestaInventarioChocolate = new Recipe ("Cafe Chocolate",1,0,0,1,1);
		troco = 0;
	}
	
	
	/* Testes para addRecipe - INICIO */
		
	@Test
	public void testaInsereUmaReceita() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(receitaValida1);
		assertTrue(ok);
	}

	@Test (expected = AmountOfRecipeException.class)
	public void testaInsereQuatroReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(receitaValida1);
		ok = CM.addRecipe(receitaValida2);
		ok = CM.addRecipe(receitaValida3);
		ok = CM.addRecipe(receitaValida4);
		assertEquals(false, ok);
	}
	
	@Test (expected = DuplicatedRecipeException.class)
	public void testaInsereReceitaNomeDuplicado() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(receitaValida1);
		ok = CM.addRecipe(receitaNomeRepetido1);
		assertTrue(ok);
	}
	
	@Test (expected = DuplicatedRecipeException.class)
	public void testaInsereReceitaIngredientesRepetidos() throws AmountOfRecipeException, DuplicatedRecipeException{
		boolean ok = CM.addRecipe(receitaValida1);
		ok = CM.addRecipe(receitaIngradientesRepetidos1);
		assertTrue(ok);
	}
	
	/* Testes para addRecipe - FIM */
	
	
	/* Testes para deleteRecipe - INICIO */
	
	@Test
	public void testaRemoveReceitaValida() throws RecipeException, AmountOfRecipeException, DuplicatedRecipeException{
		CM.addRecipe(receitaValida1);
		boolean ok = CM.deleteRecipe(CM.getRecipes().get(0).getName());
		assertEquals(true, ok);
	}
	
	@Test (expected = RecipeException.class)
	public void testaRemoveReceitaInvalida() throws AmountOfRecipeException, DuplicatedRecipeException, RecipeException{
		CM.addRecipe(receitaValida1);
		boolean ok = CM.deleteRecipe("Chocolate Quente");
		assertEquals(false, ok);
	}
	
	/* Testes para deleteRecipe - FIM */
	
	
	/* Testes para addCoffeeInventory - INICIO */
	
	@Test
	public void testaRepoeCafeValido() throws InvalidValueException{
		CM.addCoffeeInventory(100-CM.checkCoffeeInventory());
		int qtdCafe = CM.checkChocolateInventory();
		assertEquals(100, qtdCafe);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeCafeInvalido() throws InvalidValueException{
		CM.addCoffeeInventory(101-CM.checkCoffeeInventory());
	}
	
	/* Testes para addCoffeeInventory - FIM */
	
	
	/* Testes para addMilkInventory - INICIO */
	
	@Test
	public void testaRepoeLeiteValido() throws InvalidValueException{
		CM.addMilkInventory(100-CM.checkMilkInventory());
		int qtdLeite = CM.checkMilkInventory();
		assertEquals(100, qtdLeite);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeLeiteInvalido() throws InvalidValueException{
		CM.addMilkInventory(101-CM.checkMilkInventory());
	}
	
	/* Testes para addMilkInventory - FIM */
	
	
	/* Testes para addSugarInventory - INICIO */
	
	@Test
	public void testaRepoeAcucarValido() throws InvalidValueException{
		CM.addSugarInventory(100-CM.checkSugarInventory());
		int qtdAcucar = CM.checkSugarInventory();
		assertEquals(100, qtdAcucar);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeAcucarInvalido() throws InvalidValueException{
		CM.addSugarInventory(101-CM.checkSugarInventory());
	}
	
	/* Testes para addSugarInventory - FIM */
	
	
	/* Testes para addChocolateInventory - INICIO */
	
	@Test
	public void testaRepoeChocolateValido() throws InvalidValueException{
		/* Possivel teste 1 */
		CM.addChocolateInventory(100-CM.checkChocolateInventory());		
		int qtdChocolate = CM.checkChocolateInventory();
		assertEquals(100, qtdChocolate);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeChocolateInvalido() throws InvalidValueException{
		CM.addChocolateInventory(101-CM.checkChocolateInventory());
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
	public void testaInventorioLeite(){
		int qtdLeite = CM.checkMilkInventory();
		assertEquals(20, qtdLeite);
	}
	
	/* Testes para checkMilkInventory - FIM */
	
	
	/* Testes para checkSugarInventory - INICIO */
	
	@Test
	public void testaInventorioAcucar() throws Exception{
		int qtdAcucar = CM.checkSugarInventory();
		assertEquals(20, qtdAcucar);
	}
	
	/* Testes para checkSugarInventory - FIM */
	
	
	/* Testes para checkChocolateInventory - INICIO */
	
	@Test
	public void testaInventorioChocolate() throws Exception{
		int qtdChocolate = CM.checkChocolateInventory();
		assertEquals(20, qtdChocolate);
	}
	
	/* Testes para checkChocolateInventory - FIM */
	

	/* Testes para makeCoffee - INICIO */
	
	@Test
	public void testaFazerCafeSemTroco() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaValida1);
		troco = CM.makeCoffee("Cafe", CM.getRecipes().get(0).getPrice());
		assertEquals(0, troco);
	}
	
	@Test
	public void testaFazerCafeComTroco() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaValida1);
		troco = CM.makeCoffee("Cafe", CM.getRecipes().get(0).getPrice()+1);
		assertEquals(1, troco);
	}

	@Test (expected = InsufficientAmountOfMoneyException.class)
	public void testaFazerCafeDinheiroInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaValida1);
		troco = CM.makeCoffee("Cafe", CM.getRecipes().get(0).getPrice()-1);
		assertEquals(CM.getRecipes().get(0).getPrice()-1, troco);
	}
	
	@Test (expected = RecipeException.class)
	public void testaFazerCafeReceitaInexistente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaValida1);
		troco = CM.makeCoffee("Chocolate Quente", CM.getRecipes().get(0).getPrice()+1);
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}

	@Test (expected = InventoryException.class)
	public void testaFazerCafeInventorioCafeInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaTestaInventarioCafe);
		for(int i = 0; i < CM.checkCoffeeInventory()+1; i++){
			troco = CM.makeCoffee("Cafe Puro", CM.getRecipes().get(0).getPrice()+1);
		}
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}

	@Test (expected = InventoryException.class)
	public void testaFazerCafeInventorioLeiteInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaTestaInventarioLeite);
		for(int i = 0; i < CM.checkMilkInventory()+1; i++){
			troco = CM.makeCoffee("Leite Puro", CM.getRecipes().get(0).getPrice()+1);
		}
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}
	
	@Test (expected = InventoryException.class)
	public void testaFazerCafeInventorioAcucarInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaTestaInventarioAcucar);
		for(int i = 0; i < CM.checkSugarInventory()+1; i++){
			troco = CM.makeCoffee("Acucar Puro", CM.getRecipes().get(0).getPrice()+1);
		}
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}
	
	@Test (expected = InventoryException.class)
	public void testaFazerCafeInventorioChocolateInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		CM.addRecipe(receitaTestaInventarioChocolate);
		for(int i = 0; i < CM.checkChocolateInventory()+1; i++){
			troco = CM.makeCoffee("Cafe Chocolate", CM.getRecipes().get(0).getPrice()+1);
		}
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}
	/* Testes para makeCoffee - FIM */
	
	
	/* Testes para getRecipes - INICIO */
	
	@Test
	public void testaRetornaReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
		CM.addRecipe(receitaValida1);
		CM.addRecipe(receitaValida2);
		CM.addRecipe(receitaValida3);
		Vector<Recipe> receitas = new Vector<>();
		receitas.addElement(receitaValida1);
		receitas.addElement(receitaValida2);
		receitas.addElement(receitaValida3);
		assertEquals(receitas, CM.getRecipes());
	}
	
	/* Testes para getRecipes - FIM */

}