package exemplo.screenshots.junit;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotRule extends TestWatcher
{
	@Override
	protected void failed(Throwable e, Description description)
	{
		String nomeClasse = description.getTestClass().getSimpleName();
		String nomeTeste = description.getMethodName();

		tiraScreenshot(nomeClasse, nomeTeste);
	}

	public void tiraScreenshot(String nomeClasse, String nomeTeste)
	{
		try
		{
			// Cria um diretório "screenshots" na raiz do projeto
			new File("screenshots/").mkdirs();

			// Obtém um screenshot
			File screenshot = ((TakesScreenshot) JUnitBaseTest.getDriver())
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
