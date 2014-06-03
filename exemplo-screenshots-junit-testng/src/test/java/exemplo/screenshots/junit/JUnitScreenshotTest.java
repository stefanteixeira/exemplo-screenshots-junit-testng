package exemplo.screenshots.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JUnitScreenshotTest extends JUnitBaseTest
{
	@Before
	public void abrePagina()
	{
		driver.get("http://www.lojaexemplodelivros.com.br");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testeComSucesso()
	{
		String nomeLivro = "[PRODUTO DE EXEMPLO] - A Cabeça de Steve Jobs";
		WebElement linkLivroJobs = driver.findElement(By.linkText(nomeLivro));
		linkLivroJobs.click();
		wait.until(ExpectedConditions.titleContains(nomeLivro));
		
		String precoLivro = driver.findElement(By.id("product-price-45")).getText();
		assertEquals("R$634,90", precoLivro);
	}
	
	@Test
	public void testeComFalha()
	{
		String nomeLivro = "[PRODUTO DE EXEMPLO] - A Cabeça de Steve Jobs";
		WebElement linkLivroJobs = driver.findElement(By.linkText(nomeLivro));
		linkLivroJobs.click();
		wait.until(ExpectedConditions.titleContains(nomeLivro));
		
		String precoLivro = driver.findElement(By.id("product-price-45")).getText();
		assertEquals("R$0,00", precoLivro);
	}
}
