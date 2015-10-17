package each.usp.ach2006.eler;

import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecipeTest {
	/* Testa a criação de uma receita */
	
	/* Segundo especificação:
	 * Na classe RecipeTest devem ser escritos os casos de teste para testar as operações da
	 * classe Recipe. Em particular, deve-se testar apenas a criação de uma receita por meio de seu construtor.
	 */
	
	@Test
	public void testCreateValidRecipe() throws InvalidValueException{
		Recipe recipe = new Recipe("Coffee",50,4,0,1,0);
		//Se não lançar exceção é porque a receita foi criada
		assertEquals(50,recipe.getPrice());
	}
}
