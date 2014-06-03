package exemplo.screenshots.testng;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshotListener extends TestListenerAdapter
{
	@Override
	public void onTestFailure(ITestResult tr)
	{
		super.onTestFailure(tr);
		
		String nomeClasse = tr.getClass().getSimpleName();
		String nomeTeste = tr.getMethod().getMethodName();
		
		tiraScreenshot(nomeClasse, nomeTeste);
	}

	public void tiraScreenshot(String nomeClasse, String nomeTeste)
	{
		try
		{
			// Cria um diretório "screenshots" na raiz do projeto
			new File("screenshots/").mkdirs();

			// Obtém um screenshot
			File screenshot = ((TakesScreenshot) TestNGBaseTest.getDriver())
					.getScreenshotAs(OutputType.FILE);

			// Cria um arquivo dentro do diretório "screenshots", contendo
			// o nome da classe/método de teste
			// Exemplo: "IncluirUsuarioTest-incluirComSucesso-screenshot.png"
			FileUtils.copyFile(screenshot, new File("screenshots/" + nomeClasse
					+ "-" + nomeTeste + "-screenshot.png"));

		} catch (Exception e)
		{
		}
	}
}
